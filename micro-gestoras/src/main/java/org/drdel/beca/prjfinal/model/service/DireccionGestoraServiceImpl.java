package org.drdel.beca.prjfinal.model.service;

import org.drdel.beca.prjfinal.model.dao.IDireccionGestoraDAO;
import org.drdel.beca.prjfinal.model.domain.DireccionGestoraDTO;
import org.drdel.beca.prjfinal.model.dtomapper.DireccionGestoraDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
        return DireccionGestoraDTOMapper.transformEntityToDTOList(direccionGestoraDAO.findAll());
    }



    /*@Override
    public Long crearDireccionGestora(DireccionGestoraDTO direccionGestoraDTO) {
        var direccionGestoraSalvado=direccionGestoraDAO.save(DireccionGestoraDTOMapper.transformDTOToEntity(direccionGestoraDTO));
        return direccionGestoraSalvado.getIdDireccion();
    }*/

    /*@Override
    public void borrarDireccionGestora(Long idDireccion) throws IOException {
        direccionGestoraDAO.deleteById(idDireccion);
    }*/

    @Override
    public List<DireccionGestoraDTO> obtenerDireccionGestoraPorDireccion(String direccion) {
        var listaDireccionGestora=direccionGestoraDAO.findByDireccion(direccion);
        return DireccionGestoraDTOMapper.transformEntityToDTOList(listaDireccionGestora);
    }

}
