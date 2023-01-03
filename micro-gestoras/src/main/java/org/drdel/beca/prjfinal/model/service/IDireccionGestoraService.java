package org.drdel.beca.prjfinal.model.service;

import org.drdel.beca.prjfinal.model.domain.DireccionGestoraDTO;
import org.drdel.beca.prjfinal.model.entity.DireccionGestora;

import java.io.IOException;
import java.util.List;

public interface IDireccionGestoraService {

    DireccionGestoraDTO obtenerDireccionGestora (Long id);

    List<DireccionGestoraDTO>obtenerTodosDireccionGestora();

    Long  crearDireccionGestora (DireccionGestoraDTO direccionGestoraDTO);

    void borrarDireccionGestora(Long idDireccion) throws IOException;

}
