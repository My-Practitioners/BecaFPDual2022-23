package org.drdel.beca.prjfinal.micro.gestoras.model.service;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.GestoraDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.domain.VariabilidadCapitalDTO;
import org.junit.jupiter.api.Assertions;
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
class VariabilidadCapitalServiceImplTest {

    @Autowired
    VariabilidadCapitalServiceImpl variabilidadCapitalService;


    @Test
    @DisplayName("Test Crear nueva Variabilidad Capital")
    void testCrearVariabilidadCapital(){
        VariabilidadCapitalDTO dto=new VariabilidadCapitalDTO("capm",4,"capital mixto");
        var variabilidadCap=variabilidadCapitalService.crearVariabilidadCapital(dto);
        assertNotNull(variabilidadCap);
        assertEquals("capm",dto.getCodVariabilidadCapital());
        variabilidadCapitalService.borrarVariabilidadCapital("capm");
    }

    @Test
    @DisplayName("Test borrar Variabilidad Capital")
    void testBorrarGestora(){
        variabilidadCapitalService.borrarVariabilidadCapital("capv");
        assertNull(variabilidadCapitalService.obtenerVariabilidadCapital("capv"));
        variabilidadCapitalService.crearVariabilidadCapital(new VariabilidadCapitalDTO("capv",4,"capital fijo"));
    }

    @Test
    @DisplayName("Test actualizar Variabilidad Capital")
    void testActualizarVariabilidadCapital(){
        VariabilidadCapitalDTO variabilidadCapitalDto = new VariabilidadCapitalDTO("capv", 4, "capital actualizado");
        var variabilidadCapital = variabilidadCapitalService.actualizarVariabilidadCapital(variabilidadCapitalDto);
        assertNotNull(variabilidadCapital);
    }

    @Test
    @DisplayName("Test activar Variabilidad Capital solo si está en estado DRAFT")
    void testActivarVariabilidadCapital(){
        var variabilidadCapitalDraft=variabilidadCapitalService.obtenerVariabilidadCapital("capv");
        variabilidadCapitalService.activarVariabilidadCapital(variabilidadCapitalDraft);
        assertThat(variabilidadCapitalDraft.getIdEstadoVariabilidadCapital()).isEqualTo(1);
    }


    //creamos una nueva capital obligatoriamente en draft y luego la pasamos a operative para poder operar con ella
    @Test
    @DisplayName("Test suspender Variabilidad Capital solo si está en operative")
    void testSuspenderVariabilidadCapital(){
        var capNuevaDraft= new VariabilidadCapitalDTO("capt",4,"capital tester");
        variabilidadCapitalService.activarVariabilidadCapital(capNuevaDraft);

        var variabilidadCapitalOperative=variabilidadCapitalService.obtenerVariabilidadCapital("capt");
        variabilidadCapitalService.suspenderVariabilidadCapital(variabilidadCapitalOperative);
        assertThat(variabilidadCapitalOperative.getIdEstadoVariabilidadCapital()).isEqualTo(2);
    }

    @Test
    @DisplayName("Test cancelar Variabilidad Capital solo sis está en operative")
    void testCancelarVariabilidadCapital(){
        var variabilidadCapitalOperative= variabilidadCapitalService.obtenerVariabilidadCapital("capf");
        variabilidadCapitalService.cancelarVariabilidadCapital(variabilidadCapitalOperative);
        assertThat(variabilidadCapitalOperative.getIdEstadoVariabilidadCapital()).isEqualTo(3);
    }

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
        Assertions.assertEquals("capital fijo", varCap.getDescripcion());
        varCap = variabilidadCapitalService.obtenerVariabilidadCapital("capv");
        Assertions.assertEquals("capital variable", varCap.getDescripcion());
    }

    @Test
    @DisplayName("Test obtención de todos los tipos de variabilidad capital")
    void testObtenerTodasVaribilidadCapital(){
        assertEquals(2,variabilidadCapitalService.obtenerTodosVariabilidadCapital().size());
    }

    @ParameterizedTest
    @DisplayName("Obtención de Variabilidad Capital por descripcion para verificacion de existencia")
    @ValueSource(strings = "capital fijo")
    void testObtenerGestoraPorDescripcion(String descripcion){
        var variabilidadCapital=variabilidadCapitalService.obtenerVariabilidadPorDescripcion(descripcion);
        assertNotEquals(0,variabilidadCapital.size());
    }


}
