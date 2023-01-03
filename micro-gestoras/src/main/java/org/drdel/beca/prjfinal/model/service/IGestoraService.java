package org.drdel.beca.prjfinal.model.service;

import org.drdel.beca.prjfinal.model.domain.GestoraDTO;

import java.io.IOException;
import java.util.List;

public interface IGestoraService {



    GestoraDTO obtenerGestora (Long id);

    List<GestoraDTO> obtenerTodasGestoras();

    Long crearGestora(GestoraDTO gestoraDTO);

    void borrarGestora(Long idGestora) throws IOException;

    List<GestoraDTO> obtenerGestoraPorNombre(String nombreDTO);
}

