package org.drdel.beca.prjfinal.micro.gestoras.model.service;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.VariabilidadCapitalDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.entity.VariabilidadCapital;

import java.util.List;

public interface IVariabilidadCapitalService {

    VariabilidadCapitalDTO obtenerVariabilidadCapital (String code);

    List<VariabilidadCapitalDTO> obtenerTodosVariabilidadCapital();

    List<VariabilidadCapitalDTO> obtenerVariabilidadPorDescripcion(String decripcion);


    String crearVariabilidadCapital(VariabilidadCapitalDTO variabilidadCapitalDto);

    String borrarVariabilidadCapital(String codVariabilidadCapital);

    String actualizarVariabilidadCapital(VariabilidadCapitalDTO variabilidadCapitalDto);

    String activarVariabilidadCapital(VariabilidadCapitalDTO variabilidadCapitalDto);

    String suspenderVariabilidadCapital(VariabilidadCapitalDTO variabilidadCapitalDto);

    String cancelarVariabilidadCapital(VariabilidadCapitalDTO variabilidadCapitalDto);

}

