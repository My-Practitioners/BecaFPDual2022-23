package org.drdel.beca.prjfinal.model.service;

import org.drdel.beca.prjfinal.model.dao.IGestoraDAO;
import org.drdel.beca.prjfinal.model.domain.GestoraDTO;
import org.drdel.beca.prjfinal.model.dtomapper.GestoraDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        return GestoraDTOMapper.transformEntityToDTOList(gestoraDAO.findAll());
    }

   /* @Override
    public Long crearGestora(GestoraDTO gestoraDTO) {
        var gestoraSalvado=gestoraDAO.save(GestoraDTOMapper.transformDTOToEntity(gestoraDTO));
        return gestoraSalvado.getIdGestora();
    }
    */


    @Override
    public void borrarGestora(Long idGestora) throws IOException {
        gestoraDAO.deleteById(idGestora);

    }

    @Override
    public List<GestoraDTO> obtenerGestoraPorNombre(String nombreDTO) {
        var listaGestora=gestoraDAO.findByNombre(nombreDTO);
        return GestoraDTOMapper.transformEntityToDTOList(listaGestora);
    }


}
