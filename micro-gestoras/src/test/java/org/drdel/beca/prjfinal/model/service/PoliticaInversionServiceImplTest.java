package org.drdel.beca.prjfinal.model.service;

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
class PoliticaInversionServiceImplTest {
    @Autowired
    PoliticaInversionServiceImpl politicaInversionService;

    @ParameterizedTest
    @DisplayName("Obtencion de Politica de Inversion por codigo para verificar existencia")
    @ValueSource(strings = {"inm","mix"} )
    void testobtenerPoliticaInversion(String code) {
        // Call the service method
        var varPol = politicaInversionService.obtenerPoliticaInversion(code);
        assertNotNull(varPol);
    }

    @Test
    @DisplayName("Obtencion de Politica de Inversion por codigo")
    void testobtenerPoliticaInversion() {
        // Call the service method
        var varPol = politicaInversionService.obtenerPoliticaInversion("args");
        assertEquals("alto riesgo", varPol.getDescripcion());
        varPol = politicaInversionService.obtenerPoliticaInversion("par");
        assertEquals("participaciones", varPol.getDescripcion());
    }

    @Test
    @DisplayName("Obtencion de todos los tipos de Politica de Inversion")
    void obtenerTodosPoliticaInversion(){
        assertEquals(6, politicaInversionService.obtenerTodosPoliticaInversion().size());
    }

}
