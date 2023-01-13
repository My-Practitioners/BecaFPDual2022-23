package org.drdel.beca.prjfinal.micro.gestoras.model.service;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.DireccionGestoraDTO;

import java.util.List;

public interface IDireccionGestoraService {

    DireccionGestoraDTO obtenerDireccionGestora (Long id);

    List<DireccionGestoraDTO> obtenerTodosDireccionGestora();

    List<DireccionGestoraDTO> obtenerDireccionGestoraPorDireccion(String direccion);

    Long crearDireccionGestora(DireccionGestoraDTO direccionGestoraDTO);


}
