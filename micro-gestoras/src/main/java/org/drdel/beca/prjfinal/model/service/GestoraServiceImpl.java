package org.drdel.beca.prjfinal.model.service;

import org.drdel.beca.prjfinal.model.dao.IGestoraDAO;
import org.drdel.beca.prjfinal.model.domain.GestoraDTO;
import org.drdel.beca.prjfinal.model.dtomapper.GestoraDTOMapper;
import org.drdel.beca.prjfinal.model.entity.Gestora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class GestoraServiceImpl implements IGestoraService{

    @Autowired
    IGestoraDAO gestoraDAO;

    @Override
    public GestoraDTO obtenerGestora(Long id) {
        var entity=gestoraDAO.findById(id).orElse(null);
        return entity!=null ? GestoraDTOMapper.transofrmEntityToDTO(entity):null;
    }

    @Override
    public List<GestoraDTO> obtenerTodasGestoras() {
        return GestoraDTOMapper.transformEntityListToDTOList(gestoraDAO.findAll());
    }

    @Override
    public List<GestoraDTO> obtenerGestoraPorNombre(String nombreDTO) {
        var listaGestora=gestoraDAO.findByNombre(nombreDTO);
        return GestoraDTOMapper.transformEntityListToDTOList(listaGestora);
    }

    @Override
    public Long crearGestora(GestoraDTO gestoraDTO) {
        var gestoraGuardada = gestoraDAO.save(GestoraDTOMapper.transformDTOToEntity(gestoraDTO));
        return gestoraGuardada.getIdGestora();
    }

    @Override
    public Gestora crearGestora2(Long idGestora, String nombre) {
        GestoraDTO gestoraDTO= new GestoraDTO(idGestora,nombre);
        return gestoraDAO.save(GestoraDTOMapper.transformDTOToEntity(gestoraDTO));
    }



    /*@Override
    public void borrarGestora(Long idGestora) throws IOException {
        gestoraDAO.deleteById(idGestora);

    }

     */

}
