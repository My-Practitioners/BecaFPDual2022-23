package org.drdel.beca.prjfinal.micro.operaciones.model.service;

import org.drdel.beca.prjfinal.micro.operaciones.model.dao.IFondosClienteHistoryDao;
import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondoClienteHistoryDTO;
import org.drdel.beca.prjfinal.micro.operaciones.model.dtomapper.FondoClienteHistoryDTOMapper;
import org.drdel.beca.prjfinal.micro.operaciones.model.rules.ContratacionRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperacionContratacionServiceImpl implements IOperacionContratacionService{

    @Autowired
    IFondosClienteHistoryDao fondosClienteHistoryDao;
    @Autowired
    ContratacionRules rules;

    @Override
    public Long activarFondoCliente(FondoClienteHistoryDTO dto) {
        rules.checkToActiveFondoCliente(dto);
        dto.setIdEstadoContratacion(1);
        dto.setIdOperacionContratacion(4);
        fondosClienteHistoryDao.save(FondoClienteHistoryDTOMapper.transformDTOToEntity(dto));
        return dto.getIdFondoCliente();
    }


    @Override
    public Long suspenderFondoCliente(FondoClienteHistoryDTO dto) {
        rules.checkToSuspendFondoCliente(dto);
        dto.setIdEstadoContratacion(3);
        dto.setIdOperacionContratacion(3);
        fondosClienteHistoryDao.save(FondoClienteHistoryDTOMapper.transformDTOToEntity(dto));
        return dto.getIdFondoCliente();
    }

    @Override
    public Long cancelarFondoCliente(FondoClienteHistoryDTO dto) {
        rules.checkToCancelFondoCliente(dto);
        dto.setIdEstadoContratacion(2);
        dto.setIdOperacionContratacion(5);
        fondosClienteHistoryDao.save(FondoClienteHistoryDTOMapper.transformDTOToEntity(dto));
        return dto.getIdFondoCliente();

    }

    @Override
    public Long modificarImporte(FondoClienteHistoryDTO dto ,double importe) {
        rules.checkToModifyContratacion(dto);
        dto.setImporte(importe);
        fondosClienteHistoryDao.save(FondoClienteHistoryDTOMapper.transformDTOToEntity(dto));
        return dto.getIdFondoCliente();
    }
}
