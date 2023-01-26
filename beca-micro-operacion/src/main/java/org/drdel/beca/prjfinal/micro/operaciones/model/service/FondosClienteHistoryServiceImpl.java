package org.drdel.beca.prjfinal.micro.operaciones.model.service;

import org.drdel.beca.prjfinal.micro.operaciones.model.dao.IFondosClienteHistoryDao;
import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondosClienteHistoryDTO;
import org.drdel.beca.prjfinal.micro.operaciones.model.dtomapper.FondosClienteHistoryDTOMapper;
import org.drdel.beca.prjfinal.micro.operaciones.model.exception.FondosClienteHistoryException;
import org.springframework.beans.factory.annotation.Autowired;

public class FondosClienteHistoryServiceImpl implements IFondosClienteHistoryService {

    @Autowired
    IFondosClienteHistoryDao fondosClienteHistoryDao;

    @Override
    public FondosClienteHistoryDTO obtenerFondoCliente(Long id) {
        var fondoCliente = fondosClienteHistoryDao.findById(id).orElse(null);
        return fondoCliente != null ? FondosClienteHistoryDTOMapper.transformEntityToDTO(fondoCliente) : null;
    }

    @Override
    public int suspenderFondoCliente(FondosClienteHistoryDTO fondosClienteHistoryDTO) {
        if (fondosClienteHistoryDTO.getEstadosContratacion() != 3
                && fondosClienteHistoryDTO.getOperacionesContratacion() != "Suspender Fondo") {
            fondosClienteHistoryDTO.setEstadosContratacion(3);
            fondosClienteHistoryDTO.setOperacionesContratacion("Suspender Fondo");
            fondosClienteHistoryDao.save(FondosClienteHistoryDTOMapper.transformDTOToEntity(fondosClienteHistoryDTO));
            return fondosClienteHistoryDTO.getEstadosContratacion();
        } else {
            try {
                return FondosClienteHistoryException.suspenderFondoCliente().getEstadosContratacion();
            } catch (FondosClienteHistoryException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    @Override
    public int cancelarFondoCliente(FondosClienteHistoryDTO fondosClienteHistoryDTO) {
        if (fondosClienteHistoryDTO.getEstadosContratacion() != 2
                && fondosClienteHistoryDTO.getOperacionesContratacion() != "Cancelar Fondo") {
            fondosClienteHistoryDTO.setEstadosContratacion(2);
            fondosClienteHistoryDTO.setOperacionesContratacion("Cancelar Fondo");
            fondosClienteHistoryDao.save(FondosClienteHistoryDTOMapper.transformDTOToEntity(fondosClienteHistoryDTO));
            return fondosClienteHistoryDTO.getEstadosContratacion();
        } else {
            try {
                return FondosClienteHistoryException.suspenderFondoCliente().getEstadosContratacion();
            } catch (FondosClienteHistoryException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }
}
