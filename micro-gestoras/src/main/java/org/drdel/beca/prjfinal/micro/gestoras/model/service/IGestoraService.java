package org.drdel.beca.prjfinal.micro.gestoras.model.service;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.GestoraDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.entity.Gestora;


import java.util.List;

public interface IGestoraService {

    GestoraDTO obtenerGestora (Long id);

    List<GestoraDTO> obtenerTodasGestoras();

    List<GestoraDTO> obtenerGestoraPorNombre(String nombreDto);

    Long crearGestora (GestoraDTO gestoraDto);

    Long borrarGestora(Long id);

    Long actualizarGestora(GestoraDTO gestoraDto);

    Long activarGestora(GestoraDTO gestoraDto);

    Long suspenderGestora(GestoraDTO gestoraDto);

    Long cancelarGestora(GestoraDTO gestoraDto);
}

