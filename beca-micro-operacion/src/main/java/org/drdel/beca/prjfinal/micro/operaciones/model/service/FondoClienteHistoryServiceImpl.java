package org.drdel.beca.prjfinal.micro.operaciones.model.service;

import org.drdel.beca.prjfinal.micro.operaciones.model.dao.IFondosClienteHistoryDao;
import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondoClienteHistoryDTO;
import org.drdel.beca.prjfinal.micro.operaciones.model.dtomapper.FondoClienteHistoryDTOMapper;
import org.drdel.beca.prjfinal.micro.operaciones.model.rules.ContratacionRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FondoClienteHistoryServiceImpl implements IFondoClienteHistoryService {

    @Autowired
    IFondosClienteHistoryDao fondosClienteHistoryDao;
    @Autowired
    ContratacionRules rules;


    @Override
    public FondoClienteHistoryDTO obtenerFondoCliente(Long id) {
        var fondoCliente = fondosClienteHistoryDao.findById(id).orElse(null);
        return fondoCliente != null ? FondoClienteHistoryDTOMapper.transformEntityToDTO(fondoCliente) : null;
    }

    @Override
    public List<FondoClienteHistoryDTO> obtenerTodosFondoCliente() {
        return FondoClienteHistoryDTOMapper.transformEntityToDTOList(fondosClienteHistoryDao.findAll());
    }
}
