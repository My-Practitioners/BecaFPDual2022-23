package org.drdel.beca.prjfinal.model.service;

import org.drdel.beca.prjfinal.model.dao.IDireccionGestoraDAO;
import org.drdel.beca.prjfinal.model.domain.DireccionGestoraDTO;
import org.drdel.beca.prjfinal.model.dtomapper.DireccionGestoraDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DireccionGestoraServiceImpl implements IDireccionGestoraService{

    @Autowired
    IDireccionGestoraDAO direccionGestoraDAO;

    @Override
    public DireccionGestoraDTO obtenerDireccionGestora(Long id) {
        var entity= direccionGestoraDAO.findById(id).orElse(null);
        return entity!=null ? ;
    }

    @Override
    public List<DireccionGestoraDTO> obtenerTodosDireccionGestora() {
        return DireccionGestoraDTOMapper.transformEntityToDTOList(direccionGestoraDAO.findAll());
    }
}
