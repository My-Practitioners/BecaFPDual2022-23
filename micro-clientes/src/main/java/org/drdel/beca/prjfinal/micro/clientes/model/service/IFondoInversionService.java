package org.drdel.beca.prjfinal.micro.clientes.model.service;

import org.drdel.beca.prjfinal.micro.clientes.model.domain.FondoInversionDTO;

import java.util.List;

public interface IFondoInversionService {

    FondoInversionDTO obtenerFondoInversion (String code);

    List<FondoInversionDTO> obtenerTodosFondoInversion();

    List<FondoInversionDTO> obtenerFondoInversionPorNombre(String nombre);

    String crearFondoInversion(FondoInversionDTO fondoInversion);

}
