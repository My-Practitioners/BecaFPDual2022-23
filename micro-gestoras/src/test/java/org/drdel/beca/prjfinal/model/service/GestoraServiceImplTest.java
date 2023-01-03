package org.drdel.beca.prjfinal.model.service;

import org.drdel.beca.prjfinal.model.dao.IGestoraDAO;
import org.drdel.beca.prjfinal.model.domain.GestoraDTO;
import org.drdel.beca.prjfinal.model.dtomapper.GestoraDTOMapper;
import org.drdel.beca.prjfinal.model.entity.Gestora;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class GestoraServiceImplTest {

    @Autowired
    private GestoraServiceImpl gestoraService;
    @Autowired
    private IGestoraDAO iGestoraDAO;

    @ParameterizedTest
    @Order(1)
    @DisplayName("Obtencion de gestora por id para verificar existencia")
    @ValueSource(longs = {1,2})
    void testObtenerGestora(Long id){

        var gestDTO=gestoraService.obtenerGestora(id);
        assertNotNull(gestDTO);
    }

    @Test
    @Order(2)
    @DisplayName("Obtencion de gestora por id")
    void testobtenerGestora(){
        var gestDTO=gestoraService.obtenerGestora(1L);
        assertEquals("360 CORA SGIIC, S.A.",gestDTO.getNombre());
        gestDTO= gestoraService.obtenerGestora(2L);
        assertEquals("4FOUNDERS CAPITAL SGEIC, S.A.",gestDTO.getNombre());

    }

    @Order(3)
    @Test
    @DisplayName("Obtencion de todas las gestoras")
    void testObtenerTodasGestora(){
        assertEquals(237,gestoraService.obtenerTodasGestoras().size());
    }

    /*
    @Test
    @DisplayName("Test Creacion de Gestora")
    void crearGestora(GestoraDTO gestoraDTO){
        gestoraDTO.setIdGestora(238);
        gestoraDTO.setNombre("Gestora creada por el TEST");
        iGestoraDAO.save(GestoraDTOMapper.transformDTOToEntity(gestoraDTO));
        var gestoraAssert=gestoraService.obtenerGestora(238L);
        assertNotNull(gestoraAssert);

    }*/
/*
    @ParameterizedTest

    @DisplayName("Test borrar gestora para saber si se elimino la existencia")
    @ValueSource(longs = 1)
    void testBorrarGestora(Long id) throws IOException {
        gestoraService.borrarGestora(id);
        assertNull(gestoraService.obtenerGestora(id));
    }
*/
    @ParameterizedTest
    @DisplayName("Obtencion del nombre de gestora para verificacion de existencia")
    @ValueSource(strings = "A&G FONDOS, SGIIC, SA")
    void testObtenerGestoraPorNombre(String nombre){
        gestoraService.obtenerGestoraPorNombre(nombre);
        var gestora=iGestoraDAO.findByNombre(nombre);
        GestoraDTOMapper.transformEntityToDTOList(gestora);

        assertNotNull(gestora);

    }

}
