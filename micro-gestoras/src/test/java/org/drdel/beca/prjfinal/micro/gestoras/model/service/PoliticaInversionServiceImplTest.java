package org.drdel.beca.prjfinal.micro.gestoras.model.service;

import org.drdel.beca.prjfinal.micro.gestoras.model.dtomapper.PoliticaInversionDTOMapper;
import org.drdel.beca.prjfinal.micro.gestoras.model.dao.IPoliticaInversionDAO;
import org.drdel.beca.prjfinal.micro.gestoras.model.domain.PoliticaInversionDTO;
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
class PoliticaInversionServiceImplTest {
    @Autowired
    PoliticaInversionServiceImpl politicaInversionService;

    @Autowired
    IPoliticaInversionDAO iPoliticaInversionDAO;

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
        var varPol = politicaInversionService.obtenerPoliticaInversion("arsg");
        assertEquals("alto riesgo", varPol.getDescripcion());
        varPol = politicaInversionService.obtenerPoliticaInversion("par");
        assertEquals("participaciones", varPol.getDescripcion());
    }

    @Test
    @DisplayName("Obtencion de todos los tipos de Politica de Inversion")
    void testobtenerTodosPoliticaInversion(){
        assertEquals(6, politicaInversionService.obtenerTodosPoliticaInversion().size());
    }

    @ParameterizedTest
    @DisplayName("Obtencion de descripcion de Politica de Inversion para verificacion de existencia")
    @ValueSource(strings = "obligaciones")
    void testObtenerPoliticaInversionPorDescripcion(String descripcion){
        politicaInversionService.obtenerPoliticaInversionPorDescripcion(descripcion);
        var politicaInversion=iPoliticaInversionDAO.findByDescripcion(descripcion);
        PoliticaInversionDTOMapper.transformEntityListToDTOList(politicaInversion);
        assertNotNull(politicaInversion);
    }

    @Test
    @DisplayName("Creacion de nueva Politica de Inversion")
    void testCrearPoliticaInversion(){
        PoliticaInversionDTO dto = new PoliticaInversionDTO("muy", 4, "muy arriesgada");
        var politicaInversion = politicaInversionService.crearPoliticaInversion(dto);
        assertNotNull(politicaInversion);
    }

    @ParameterizedTest
    @DisplayName("Borrar Politica de Inversion por cod")
    @ValueSource(strings = {"otr"})
    void testBorrarPoliticaInversion(String cod){
        String politicaInversionBorrada= politicaInversionService.borrarPoliticaInversion(cod);
        var politica=politicaInversionService.obtenerPoliticaInversion(cod);
        assertNull(politica);
        assertThat(politicaInversionBorrada).isEqualTo("otr");
    }

    @Test
    @DisplayName("Actualizar Politica de Inversion")
    void testActualizarPoliticaInversion(){
        PoliticaInversionDTO dto = new PoliticaInversionDTO("muy", 2, "arriesgadísima");
        var politicaInversion = politicaInversionService.actualizarPoliticaInversion(dto);
        assertNotNull(politicaInversion);
    }

    @Test
    @DisplayName("Activar Politica de Inversion")
    void testActivarPoliticaInversion(){
        var politicaDraft=politicaInversionService.obtenerPoliticaInversion("par");
        politicaInversionService.activarPoliticaInversion(politicaDraft);
        assertThat(politicaDraft.getIdEstadoPoliticaInversion()).isEqualTo(1);
    }

    @Test
    @DisplayName("Cancelar Politica de Inversion")
    void testCancelarPoliticaInversion(){
        var politicaOperative=politicaInversionService.obtenerPoliticaInversion("obl");
        politicaInversionService.cancelarPoliticaInversion(politicaOperative);
        assertThat(politicaOperative.getIdEstadoPoliticaInversion()).isEqualTo(3);
    }

    @Test
    @DisplayName("Suspender Politica de Inversion")
    void testSuspenderPoliticaInversion(){
        var politicaOperative=politicaInversionService.obtenerPoliticaInversion("mix");
        politicaInversionService.suspenderPoliticaInversion(politicaOperative);
        assertThat(politicaOperative.getIdEstadoPoliticaInversion()).isEqualTo(2);
    }
}
