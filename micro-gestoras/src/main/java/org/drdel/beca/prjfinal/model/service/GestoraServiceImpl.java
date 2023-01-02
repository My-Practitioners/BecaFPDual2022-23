package org.drdel.beca.prjfinal.model.service;

import org.drdel.beca.prjfinal.model.dao.IGestoraDAO;
import org.drdel.beca.prjfinal.model.domain.GestoraDTO;
import org.drdel.beca.prjfinal.model.dtomapper.GestoraDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class GestoraServiceImpl implements IGestoraService{

    @Autowired
    IGestoraDAO gestoraDAO;


    @Override
    public GestoraDTO obtenerGestora(Long id) {
        var entity=gestoraDAO.findById(id).orElse(null);
        return entity!=null ? ;
    }

    @Override
    public List<GestoraDTO> obtenerTodasGestoras() {
        return GestoraDTOMapper.transformEntityToDTOList(gestoraDAO.findAll());
    }

}
