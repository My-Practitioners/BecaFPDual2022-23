package org.drdel.beca.prjfinal.model.service;

import org.drdel.beca.prjfinal.model.domain.VariabilidadCapitalDTO;
import java.util.List;

public interface IVariabilidadCapitalService {

    VariabilidadCapitalDTO obtenerVariabilidadCapital (String code);

    List<VariabilidadCapitalDTO> obtenerTodosVariabilidadCapital();
}

