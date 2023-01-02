package org.drdel.beca.prjfinal.model.service;

import org.drdel.beca.prjfinal.model.domain.GestoraDTO;

import java.util.List;

public interface IGestoraService {



    GestoraDTO obtenerGestora (Long id);

    List<GestoraDTO> obtenerTodasGestoras();
}

