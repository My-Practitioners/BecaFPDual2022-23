package org.drdel.beca.prjfinal.micro.gestoras.model.service;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.PoliticaInversionDTO;

import java.util.List;

public interface IPoliticaInversionService {

    PoliticaInversionDTO obtenerPoliticaInversion (String code);

    List<PoliticaInversionDTO> obtenerTodosPoliticaInversion();

    List<PoliticaInversionDTO> obtenerPoliticaInversionPorDescripcion(String descripcion);

    String crearPoliticaInversion(PoliticaInversionDTO politicaInversionDTO);

    String borrarPoliticaInversion(String cod);

    String actualizarPoliticaInversion(PoliticaInversionDTO politicaInversionDTO);

    String activarPoliticaInversion(PoliticaInversionDTO politicaInversionDTO);

    String cancelarPoliticaInversion(PoliticaInversionDTO politicaInversionDTO);

    String suspenderPoliticaInversion(PoliticaInversionDTO politicaInversionDTO);

}
