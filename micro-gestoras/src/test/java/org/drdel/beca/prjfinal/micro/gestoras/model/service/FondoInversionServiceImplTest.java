package org.drdel.beca.prjfinal.micro.gestoras.model.service;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.FondoInversionDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FondoInversionServiceImplTest {
    @Autowired
    FondoInversionServiceImpl fondoInversionService;

    @ParameterizedTest
    @DisplayName("Obtención de Fondo de Inversion por código para verificar existencia")
    @ValueSource(strings = {"ES0158677007","ES0158706038"} )
    void testObtenerFondoInversion(String code) {
        // Call the service method
        var varFon = fondoInversionService.obtenerFondoInversion(code);
        assertNotNull(varFon);
    }

    @Test
    @DisplayName("Obtención de Fondo de Inversion por código")
    void testObtenerFondoInversion() {
        // Call the service method
        var varFon = fondoInversionService.obtenerFondoInversion("ES0119251009");
        assertEquals("CODEX GLOBAL FUND, FI", varFon.getNombreFondo());
        varFon = fondoInversionService.obtenerFondoInversion("ES0162933032");
        assertEquals("CORE ASSETS,SICAV,S.A.", varFon.getNombreFondo());
    }

    @Test
    @DisplayName("Obtención de todos los tipos de Fondo de Inversion")
    void testObtenerTodosPoliticaInversion(){
        assertEquals(5334, fondoInversionService.obtenerTodosFondoInversion().size());
    }

    @ParameterizedTest
    @DisplayName("Obtención de nombre de Fondo de Inversion para verification de existencia")
    @ValueSource(strings = "ALCO INVERSIONES FINANCIERAS, SICAV, S.A")
    void testObtenerFondoPorNombre(String nombre){
        var fondosInversion=fondoInversionService.obtenerFondoInversionPorNombre(nombre);
        assertNotEquals(0, fondosInversion.size());
    }

    @Test
    @DisplayName("Creacion de nuevo Fondo de Inversion")
    void testCrearFondoInversion(){
        FondoInversionDTO dto = new FondoInversionDTO("ES111111111",4, "ES22222222", "JDUIBNCS88NHFDSI", "FONDOX", 6L, 8L, "arsg", "capv", "no", "SICA90");
        var fondoInversion = fondoInversionService.crearFondoInversion(dto);
        assertNotNull(fondoInversion);
        fondoInversionService.borrarFondoInversion("ES111111111");
    }

    @ParameterizedTest
    @DisplayName("Borrar Fondo de Inversion por cod")
    @ValueSource(strings = {"ES0176200030"})
    void testBorrarFondoInversion(String cod){
        String fondoInversionBorrado= fondoInversionService.borrarFondoInversion(cod);
        var fondo=fondoInversionService.obtenerFondoInversion(cod);
        assertNull(fondo);
        assertThat(fondoInversionBorrado).isEqualTo("ES0176200030");
    }

    @Test
    @DisplayName("Actualizar Fondo de Inversion")
    void testActualizarFondoInversion(){
        FondoInversionDTO dto = new FondoInversionDTO("ES111111112",1, "ES22232222", "JDUIBNCS88NHFDSI", "FONDOX", 7L, 9L, "arsg", "capv", "no", "SICA902");
        var fondoInversion = fondoInversionService.actualizarFondoInversion(dto);
        assertNotNull(fondoInversion);
    }

    @Test
    @DisplayName("Activar Fondo de Inversion")
    void testActivarFondoInversion(){
        var fondoDraft=fondoInversionService.obtenerFondoInversion("ES0119251009");
        fondoInversionService.activarFondoInversion(fondoDraft);
        assertThat(fondoDraft.getIdEstadoFondoInversion()).isEqualTo(1);
    }

    @Test
    @DisplayName("Cancelar Fondo de Inversion")
    void testCancelarFondoInversion(){
        var fondoOperative=fondoInversionService.obtenerFondoInversion("ES0119251017");
        fondoInversionService.cancelarFondoInversion(fondoOperative);
        assertThat(fondoOperative.getIdEstadoFondoInversion()).isEqualTo(3);
    }

    @Test
    @DisplayName("Suspender Fondo de Inversion")
    void testSuspenderFondoInversion(){
        var fondoOperative=fondoInversionService.obtenerFondoInversion("ES0156668032");
        fondoInversionService.suspenderFondoInversion(fondoOperative);
        assertThat(fondoOperative.getIdEstadoFondoInversion()).isEqualTo(2);
    }
}

