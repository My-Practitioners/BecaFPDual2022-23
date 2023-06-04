package org.drdel.beca.prjfinal.micro.gestoras.model.service;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.FondoInversionDTO;

import java.util.List;

public interface IFondoInversionService {

    FondoInversionDTO obtenerFondoInversion (String code);

    List<FondoInversionDTO> obtenerTodosFondoInversion();

    List<FondoInversionDTO> obtenerFondoInversionPorNombre(String nombre);

    String crearFondoInversion(FondoInversionDTO fondoInversion);

    String borrarFondoInversion(String cod);

    String actualizarFondoInversion(FondoInversionDTO fondoInversionDTO);

    String activarFondoInversion(FondoInversionDTO fondoInversionDTO);

    String cancelarFondoInversion(FondoInversionDTO fondoInversionDTO);

    String suspenderFondoInversion(FondoInversionDTO fondoInversionDTO);
}
