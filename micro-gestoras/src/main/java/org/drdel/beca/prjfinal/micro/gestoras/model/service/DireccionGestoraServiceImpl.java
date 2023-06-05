package org.drdel.beca.prjfinal.micro.gestoras.model.service;

import org.drdel.beca.prjfinal.micro.gestoras.model.dao.IDireccionGestoraDAO;
import org.drdel.beca.prjfinal.micro.gestoras.model.domain.DireccionGestoraDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.dtomapper.DireccionGestoraDTOMapper;
import org.drdel.beca.prjfinal.micro.gestoras.model.rules.DireccionGestoraRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionGestoraServiceImpl implements IDireccionGestoraService{

    @Autowired
    IDireccionGestoraDAO direccionGestoraDao;
    @Autowired
    DireccionGestoraRules direccionGestoraRules;

    @Override
    public DireccionGestoraDTO obtenerDireccionGestora(Long id) {
        var entity= direccionGestoraDao.findById(id).orElse(null);
        return entity!=null ? DireccionGestoraDTOMapper.transformEntityToDTO(entity):null;
    }

    @Override
    public List<DireccionGestoraDTO> obtenerTodosDireccionGestora() {
        return DireccionGestoraDTOMapper.transformEntityListToDTOList(direccionGestoraDao.findAll());
    }

    @Override
    public List<DireccionGestoraDTO> obtenerDireccionGestoraPorDireccion(String direccion) {
        var listaDireccionGestora= direccionGestoraDao.findByDireccion(direccion);
        return DireccionGestoraDTOMapper.transformEntityListToDTOList(listaDireccionGestora);
    }

    @Override
    public Long crearDireccionGestora(DireccionGestoraDTO direccionGestoraDTO) {
        direccionGestoraRules.checkEstadoToCrear(direccionGestoraDTO);
        var direccionGuardada = direccionGestoraDao.save(DireccionGestoraDTOMapper.transformDTOToEntity(direccionGestoraDTO));
        return direccionGuardada.getIdDireccion();
    }

    @Override
    public Long borrarDireccionGestora(Long idDireccionGestora) {
        direccionGestoraRules.checkEstadoToBorrar(idDireccionGestora);
        direccionGestoraDao.deleteById(idDireccionGestora);
        return idDireccionGestora;
    }

    @Override
    public Long actualizarDireccionGestora(DireccionGestoraDTO direccionGestoraDto) {
        direccionGestoraDao.save(DireccionGestoraDTOMapper.transformDTOToEntity(direccionGestoraDto));
        return direccionGestoraDto.getIdDireccion();
    }

    @Override
    public Long activarDireccionGestora(DireccionGestoraDTO direccionGestoraDto) {
        direccionGestoraRules.activarEstado(direccionGestoraDto);
        direccionGestoraDao.save(DireccionGestoraDTOMapper.transformDTOToEntity(direccionGestoraDto));
        return direccionGestoraDto.getIdDireccion();
    }

    @Override
    public Long suspenderDireccionGestora(DireccionGestoraDTO direccionGestoraDto) {
        direccionGestoraRules.suspenderEstado(direccionGestoraDto);
        direccionGestoraDao.save(DireccionGestoraDTOMapper.transformDTOToEntity(direccionGestoraDto));
        return direccionGestoraDto.getIdDireccion();
    }

    @Override
    public Long cancelarDireccionGestora(DireccionGestoraDTO direccionGestoraDto) {
        direccionGestoraRules.cancelarEstado(direccionGestoraDto);
        direccionGestoraDao.save(DireccionGestoraDTOMapper.transformDTOToEntity(direccionGestoraDto));
        return direccionGestoraDto.getIdDireccion();
    }

}
