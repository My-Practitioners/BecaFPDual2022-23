package org.drdel.beca.prjfinal.micro.gestoras.model.service;

import org.drdel.beca.prjfinal.micro.gestoras.model.dao.IDireccionGestoraDAO;
import org.drdel.beca.prjfinal.micro.gestoras.model.domain.DireccionGestoraDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.dtomapper.DireccionGestoraDTOMapper;
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
        return entity!=null ? DireccionGestoraDTOMapper.transformEntityToDTO(entity):null;
    }

    @Override
    public List<DireccionGestoraDTO> obtenerTodosDireccionGestora() {
        return DireccionGestoraDTOMapper.transformEntityListToDTOList(direccionGestoraDAO.findAll());
    }

    @Override
    public List<DireccionGestoraDTO> obtenerDireccionGestoraPorDireccion(String direccion) {
        var listaDireccionGestora=direccionGestoraDAO.findByDireccion(direccion);
        return DireccionGestoraDTOMapper.transformEntityListToDTOList(listaDireccionGestora);
    }

    @Override
    public Long crearDireccionGestora(DireccionGestoraDTO direccionGestoraDTO) {
        var direccionGuardada = direccionGestoraDAO.save(DireccionGestoraDTOMapper.transformDTOToEntity(direccionGestoraDTO));
        return direccionGuardada.getIdDireccion();
    }

}
