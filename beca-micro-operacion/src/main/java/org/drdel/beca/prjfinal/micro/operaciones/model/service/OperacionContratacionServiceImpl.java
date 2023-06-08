package org.drdel.beca.prjfinal.micro.operaciones.model.service;

import org.drdel.beca.prjfinal.micro.operaciones.model.dao.IFondosClienteDao;
import org.drdel.beca.prjfinal.micro.operaciones.model.dao.IFondosClienteHistoryDao;
import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondoClienteDTO;
import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondoClienteHistoryDTO;
import org.drdel.beca.prjfinal.micro.operaciones.model.dtomapper.FondoClienteDTOMapper;
import org.drdel.beca.prjfinal.micro.operaciones.model.dtomapper.FondoClienteHistoryDTOMapper;
import org.drdel.beca.prjfinal.micro.operaciones.model.exception.FondoClienteHistoryException;
import org.drdel.beca.prjfinal.micro.operaciones.model.rules.ContratacionRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OperacionContratacionServiceImpl implements IOperacionContratacionService{

    @Autowired
    FondoClienteHistoryServiceImpl fondoClienteHistoryService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${fondos.service.url}")
    private String fondosServiceUrl;

    @Value("${clientes.service.url}")
    private String clientesServiceUrl;

    @Autowired
    IFondosClienteHistoryDao fondosClienteHistoryDao;
    @Autowired
    ContratacionRules rules;

    @Autowired
    IFondosClienteDao iFondosClienteDao;

    @Override
    public Long activarFondoCliente(FondoClienteHistoryDTO dto) {
        FondoClienteHistoryDTO fondoClienteHistoryDTO = new FondoClienteHistoryDTO();
        rules.checkToActiveFondoCliente(dto);
        fondoClienteHistoryDTO.setImporte(dto.getImporte());
        fondoClienteHistoryDTO.setIdFondoCliente(dto.getIdFondoCliente());
        dto.setIdEstadoContratacion(1);
        dto.setIdOperacionContratacion(4);
        fondosClienteHistoryDao.save(FondoClienteHistoryDTOMapper.transformDTOToEntity(fondoClienteHistoryDTO));
        return dto.getIdFondoCliente();
    }


    @Override
    public Long suspenderFondoCliente(FondoClienteHistoryDTO dto) {
        FondoClienteHistoryDTO fondoClienteHistoryDTO = new FondoClienteHistoryDTO();
        rules.checkToSuspendFondoCliente(dto);
        fondoClienteHistoryDTO.setImporte(dto.getImporte());
        fondoClienteHistoryDTO.setIdFondoCliente(dto.getIdFondoCliente());
        fondoClienteHistoryDTO.setIdEstadoContratacion(3);
        fondoClienteHistoryDTO.setIdOperacionContratacion(3);
        fondosClienteHistoryDao.save(FondoClienteHistoryDTOMapper.transformDTOToEntity(fondoClienteHistoryDTO));
        return dto.getIdFondoCliente();
    }

    @Override
    public Long cancelarFondoCliente(FondoClienteHistoryDTO dto) {
        FondoClienteHistoryDTO fondoClienteHistoryDTO = new FondoClienteHistoryDTO();
        rules.checkToCancelFondoCliente(dto);
        fondoClienteHistoryDTO.setImporte(dto.getImporte());
        fondoClienteHistoryDTO.setIdFondoCliente(dto.getIdFondoCliente());
        fondoClienteHistoryDTO.setIdEstadoContratacion(2);
        fondoClienteHistoryDTO.setIdOperacionContratacion(5);
        fondosClienteHistoryDao.save(FondoClienteHistoryDTOMapper.transformDTOToEntity(fondoClienteHistoryDTO));
        return dto.getIdFondoCliente();

    }

    @Override
    public Long modificarImporte(FondoClienteHistoryDTO dto, double importe) {
        FondoClienteHistoryDTO fondoClienteHistoryDTO = new FondoClienteHistoryDTO();
        rules.checkToModifyContratacion(dto);
        fondoClienteHistoryDTO.setImporte(importe);
        fondoClienteHistoryDTO.setIdFondoCliente(dto.getIdFondoCliente());
        fondoClienteHistoryDTO.setIdEstadoContratacion(dto.getIdEstadoContratacion());
        fondoClienteHistoryDTO.setIdOperacionContratacion(dto.getIdOperacionContratacion());
        fondosClienteHistoryDao.save(FondoClienteHistoryDTOMapper.transformDTOToEntity(fondoClienteHistoryDTO));
        return fondoClienteHistoryDTO.getIdFondoCliente();
    }

    @Override
    public Long contratarFondo(Integer id, String codIsin, FondoClienteDTO fondoClienteDTO) {
        FondoClienteHistoryDTO fondoClienteHistoryDTO = new FondoClienteHistoryDTO();

       boolean verifyFondo = verificarExistenciaFondo(codIsin);
        if(verifyFondo == false){
            try {
                FondoClienteHistoryException.verificaFondo();
            } catch (FondoClienteHistoryException e) {
                throw new RuntimeException(e);
            }
        }

        boolean verifyCliente = verificarExistenciaCliente(id);
        if(verifyCliente == false){
            try {
                FondoClienteHistoryException.verificaCliente();
            } catch (FondoClienteHistoryException e) {
                throw new RuntimeException(e);
            }
        }

        iFondosClienteDao.save(FondoClienteDTOMapper.transformDTOToEntity(fondoClienteDTO));

        fondoClienteHistoryDTO.setIdFondoCliente(fondoClienteDTO.getIdFondoCliente());
        fondoClienteHistoryDTO.setIdEstadoContratacion(1);
        fondoClienteHistoryDTO.setIdOperacionContratacion(1);
        fondoClienteHistoryDTO.setImporte(fondoClienteDTO.getImporte());
        fondosClienteHistoryDao.save(FondoClienteHistoryDTOMapper.transformDTOToEntity(fondoClienteHistoryDTO));

        return fondoClienteDTO.getIdFondoCliente();
    }

    public boolean verificarExistenciaFondo(String codIsin) {
        String fondoUrl = fondosServiceUrl + "/oscarjorge97/Instrumentos/1.0.0/api//fondos/" + codIsin;
        ResponseEntity<String> response = restTemplate.getForEntity(fondoUrl, String.class);

        return response.getStatusCode() == HttpStatus.OK;
    }

    public boolean verificarExistenciaCliente(Integer clienteId) {
        String clienteUrl = clientesServiceUrl + "/oscarjorge97/Instrumentos/1.0.0/api/clientes/" + clienteId;
        ResponseEntity<String> response = restTemplate.getForEntity(clienteUrl, String.class);

        return response.getStatusCode() == HttpStatus.OK;
    }

}
