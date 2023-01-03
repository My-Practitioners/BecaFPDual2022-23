package org.drdel.beca.prjfinal.model.service;

import org.drdel.beca.prjfinal.model.dao.IPoliticaInversionDAO;
import org.drdel.beca.prjfinal.model.domain.PoliticaInversionDTO;
import org.drdel.beca.prjfinal.model.dtomapper.PoliticaInversionDTOMapper;
import org.drdel.beca.prjfinal.model.entity.PoliticaInversion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;

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

    /*@Test
    @DisplayName("Test de creacion de nueva Politica de Inversion")
    void testcrearNuevaPoliticaInversion(){
        PoliticaInversionDTO politicaInversionDTO = new PoliticaInversionDTO("muya","muy arriesgada");
        doReturn(politicaInversionDTO).when(iPoliticaInversionDAO).save(any());

        var p1 = politicaInversionService.obtenerTodosPoliticaInversion().size();
        assertEquals(7, p1);

        var varPol = politicaInversionService.obtenerPoliticaInversion("muya");
        assertEquals("muy arriesgada", varPol.getDescripcion());
    }*/

}
