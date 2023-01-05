package org.drdel.beca.prjfinal.model.service;

import org.drdel.beca.prjfinal.model.domain.GestoraDTO;
import org.drdel.beca.prjfinal.model.entity.Gestora;


import java.util.List;

public interface IGestoraService {

    GestoraDTO obtenerGestora (Long id);

    List<GestoraDTO> obtenerTodasGestoras();

    List<GestoraDTO> obtenerGestoraPorNombre(String nombreDTO);

    Long crearGestora(GestoraDTO gestoraDTO);

    Gestora crearGestora2(Long idDireccion, String nombre);
}

