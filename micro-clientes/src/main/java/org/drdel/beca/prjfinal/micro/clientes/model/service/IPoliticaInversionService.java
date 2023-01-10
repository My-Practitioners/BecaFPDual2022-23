package org.drdel.beca.prjfinal.micro.clientes.model.service;

import org.drdel.beca.prjfinal.micro.clientes.model.domain.PoliticaInversionDTO;

import java.util.List;

public interface IPoliticaInversionService {

    PoliticaInversionDTO obtenerPoliticaInversion (String code);

    List<PoliticaInversionDTO> obtenerTodosPoliticaInversion();

    List<PoliticaInversionDTO> obtenerPoliticaInversionPorDescripcion(String descripcion);

    String crearPoliticaInversion(PoliticaInversionDTO politicaInversionDTO);

}
