package org.drdel.beca.prjfinal.micro.operaciones.model.service;

import org.drdel.beca.prjfinal.micro.operaciones.model.dao.IFondosClienteDao;
import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondoClienteDTO;
import org.drdel.beca.prjfinal.micro.operaciones.model.dtomapper.FondoClienteDTOMapper;
import org.drdel.beca.prjfinal.micro.operaciones.model.rules.ContratacionRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FondoClienteServiceImpl implements IFondoClienteService {

    @Autowired
    IFondosClienteDao iFondosClienteDao;
    @Autowired
    ContratacionRules rules;



    @Override
    public FondoClienteDTO obtenerFondoCliente(Long id) {
        var fondoCliente = iFondosClienteDao.findById(id).orElse(null);
        return fondoCliente != null ? FondoClienteDTOMapper.transformEntityToDTO(fondoCliente) : null;
    }

    @Override
    public List<FondoClienteDTO> obtenerTodosFondoCliente() {
        return FondoClienteDTOMapper.transformEntityToDTOList(iFondosClienteDao.findAll());
    }
}