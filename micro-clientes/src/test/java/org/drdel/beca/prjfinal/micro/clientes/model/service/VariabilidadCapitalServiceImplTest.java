package org.drdel.beca.prjfinal.micro.clientes.model.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class VariabilidadCapitalServiceImplTest {

    @Autowired
    VariabilidadCapitalServiceImpl variabilidadCapitalService;

    @ParameterizedTest
    @DisplayName("Obtencion de Variabilidad de Capital por codigo para verificar existencia")
    @ValueSource(strings = {"capf","capv"} )
    void testobtenerVariabilidadCapital(String code) {
        // Call the service method
        var varCap = variabilidadCapitalService.obtenerVariabilidadCapital(code);
        assertNotNull(varCap);
    }

    @Test
    @DisplayName("Obtencion de Variabilidad de Capital por codigo")
    void testobtenerVariabilidadCapital() {
        // Call the service method
        var varCap = variabilidadCapitalService.obtenerVariabilidadCapital("capf");
        assertEquals("capital fijo", varCap.getDescripcion());
        varCap = variabilidadCapitalService.obtenerVariabilidadCapital("capv");
        assertEquals("capital variable", varCap.getDescripcion());
    }

    @Test
    @DisplayName("Obtencion de todos los tipos de Variabilidad de Capital")
    void obtenerTodosVariabilidadCapital(){
        assertEquals(2, variabilidadCapitalService.obtenerTodosVariabilidadCapital().size());
    }

    @ParameterizedTest
    @DisplayName("Obtención de Variabilidad Capital por descripcion para verificacion de existencia")
    @ValueSource(strings = "capital fijo")
    void testObtenerGestoraPorDescripcion(String descripcion){
        var variabilidadCapital=variabilidadCapitalService.obtenerVariabilidadPorDescripcion(descripcion);
        assertNotEquals(0,variabilidadCapital.size());
    }

    @ParameterizedTest
    @DisplayName("Creacion de nueva Variabilidad Capital")
    @ValueSource(strings = "capm")
    void testCrearVariabilidadCapital(String codPInversion){
        var variabilidad=variabilidadCapitalService.crearVariabilidadCapital(codPInversion,"capital mixto");
        assertNotNull(variabilidad);
    }

}
