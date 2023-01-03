package org.drdel.beca.prjfinal.model.service;

import org.drdel.beca.prjfinal.model.domain.GestoraDTO;
import org.drdel.beca.prjfinal.model.domain.PoliticaInversionDTO;

import java.util.List;

public interface IPoliticaInversionService {

    PoliticaInversionDTO obtenerPoliticaInversion (String code);

    List<PoliticaInversionDTO> obtenerTodosPoliticaInversion();

    String crearPoliticaInversion(PoliticaInversionDTO politicaInversionDTO);

    void borrarPoliticaInversion(String codPInversion);

    List<PoliticaInversionDTO> obtenerPoliticaInversionPorDescripcion(String descripcion);

}
