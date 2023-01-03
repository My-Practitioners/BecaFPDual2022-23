package org.drdel.beca.prjfinal.model.service;

import org.drdel.beca.prjfinal.model.domain.FondoInversionDTO;
import org.drdel.beca.prjfinal.model.domain.PoliticaInversionDTO;

import java.util.List;

public interface IFondoInversionService {

    FondoInversionDTO obtenerFondoInversion (String code);

    List<FondoInversionDTO> obtenerTodosFondoInversion();

    String crearFondoInversion(FondoInversionDTO fondoInversion);

    List<FondoInversionDTO> obtenerFondoInversionPorNombre(String nombre);
}
