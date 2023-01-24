package org.drdel.beca.prjfinal.micro.gestoras.model.service;

import org.drdel.beca.prjfinal.micro.gestoras.model.dao.IGestoraDAO;
import org.drdel.beca.prjfinal.micro.gestoras.model.domain.GestoraDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.dtomapper.GestoraDTOMapper;
import org.drdel.beca.prjfinal.micro.gestoras.model.rules.GestoraRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestoraServiceImpl implements IGestoraService{

    @Autowired
    IGestoraDAO gestoraDao;
    @Autowired
    GestoraRules gestoraRules;

    @Override
    public GestoraDTO obtenerGestora(Long id) {
        var entity= gestoraDao.findById(id).orElse(null);
        return entity!=null ? GestoraDTOMapper.transofrmEntityToDTO(entity):null;
    }

    @Override
    public List<GestoraDTO> obtenerTodasGestoras() {
        return GestoraDTOMapper.transformEntityListToDTOList(gestoraDao.findAll());
    }

    @Override
    public List<GestoraDTO> obtenerGestoraPorNombre(String nombreDTO) {
        var listaGestora= gestoraDao.findByNombre(nombreDTO);
        return GestoraDTOMapper.transformEntityListToDTOList(listaGestora);
    }

    @Override
    public Long crearGestora(GestoraDTO gestoraDto) {
        gestoraRules.checkEstadoToCrear(gestoraDto);
        var gestoraGuardada = gestoraDao.save(GestoraDTOMapper.transformDTOToEntity(gestoraDto));
        return gestoraGuardada.getIdGestora();
    }

    @Override
    public Long borrarGestora(Long idGestora) {
        gestoraRules.checkEstadoToBorrar(idGestora);
        gestoraDao.deleteById(idGestora);
        return idGestora;
    }

    @Override
    public Long actualizarGestora(GestoraDTO gestoraDto) {
        gestoraDao.save(GestoraDTOMapper.transformDTOToEntity(gestoraDto));
        return gestoraDto.getIdGestora();
    }

    @Override
    public Long activarGestora(GestoraDTO gestoraDto) {
        gestoraRules.activarEstado(gestoraDto);
        gestoraDao.save(GestoraDTOMapper.transformDTOToEntity(gestoraDto));
        return gestoraDto.getIdGestora();
    }


    @Override
    public Long suspenderGestora(GestoraDTO gestoraDto) {
        gestoraRules.suspenderEstado(gestoraDto);
        gestoraDao.save(GestoraDTOMapper.transformDTOToEntity(gestoraDto));
        return gestoraDto.getIdGestora();
    }

    @Override
    public Long cancelarGestora(GestoraDTO gestoraDto) {
        gestoraRules.cancelarEstado(gestoraDto);
        gestoraDao.save(GestoraDTOMapper.transformDTOToEntity(gestoraDto));
        return gestoraDto.getIdGestora();
    }


}
