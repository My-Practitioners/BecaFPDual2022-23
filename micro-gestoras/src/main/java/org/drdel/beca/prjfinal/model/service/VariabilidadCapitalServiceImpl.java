package org.drdel.beca.prjfinal.model.service;

import org.drdel.beca.prjfinal.model.domain.VariabilidadCapitalDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class VariabilidadCapitalServiceImpl implements IVariabilidadCapitalService{

    private final List<VariabilidadCapitalDTO> listaVariabilidadCapital;

    //Constructor
    public VariabilidadCapitalServiceImpl(){
        this.listaVariabilidadCapital= Arrays.asList(
                new VariabilidadCapitalDTO("capf","capital fijo"),
                new VariabilidadCapitalDTO("capv","capital variable")
        );
    }

    @Override
    public VariabilidadCapitalDTO obtenerVariabilidadCapital(String code) {
        Optional<VariabilidadCapitalDTO> selectedVariabilidadCapital = this.listaVariabilidadCapital.stream()
                .filter(s -> code.equals(s.getCodVariabilidadCapital()))
                .findFirst();
        return selectedVariabilidadCapital.orElse(null);
    }

    @Override
    public List<VariabilidadCapitalDTO> obtenerTodosVariabilidadCapital() {
        return listaVariabilidadCapital;
    }

}
