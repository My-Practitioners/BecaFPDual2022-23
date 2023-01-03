package org.drdel.beca.prjfinal.model.service;

import org.drdel.beca.prjfinal.model.dao.IFondoInversionDAO;
import org.drdel.beca.prjfinal.model.dtomapper.FondoInversionDTOMapper;
import org.drdel.beca.prjfinal.model.dtomapper.PoliticaInversionDTOMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FondoInversionServiceImplTest {
    @Autowired
    private FondoInversionServiceImpl fondoInversionService;

    @Autowired
    private IFondoInversionDAO iFondoInversionDAO;

    @ParameterizedTest
    @DisplayName("Obtencion de Fondo de Inversion por codigo para verificar existencia")
    @ValueSource(strings = {"ES0176200030","ES0119251017"} )
    void testobtenerFondoInversion(String code) {
        // Call the service method
        var varFon = fondoInversionService.obtenerFondoInversion(code);
        assertNotNull(varFon);
    }

    @Test
    @DisplayName("Obtencion de Fondo de Inversion por codigo")
    void testobtenerFondoInversion() {
        // Call the service method
        var varFon = fondoInversionService.obtenerFondoInversion("ES0119251009");
        assertEquals("CODEX GLOBAL FUND, FI", varFon.getNombreFondo());
        varFon = fondoInversionService.obtenerFondoInversion("ES0162933032");
        assertEquals("CORE ASSETS,SICAV,S.A.", varFon.getNombreFondo());
    }

    @Test
    @DisplayName("Obtencion de todos los tipos de Fondo de Inversion")
    void obtenerTodosPoliticaInversion(){
        assertEquals(5334, fondoInversionService.obtenerTodosFondoInversion().size());
    }

    @ParameterizedTest
    @DisplayName("Obtencion de nombre de Fondo de Inversion para verificacion de existencia")
    @ValueSource(strings = "ALCO INVERSIONES FINANCIERAS, SICAV, S.A")
    void testObtenerPoliticaInversionPorNombre(String nombre){
        fondoInversionService.obtenerFondoInversionPorNombre(nombre);
        var fondoInversion=iFondoInversionDAO.findByNombre(nombre);
        FondoInversionDTOMapper.transformEntityListToDTOList(fondoInversion);
        assertNotNull(fondoInversion);
    }
}

