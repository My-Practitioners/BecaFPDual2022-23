package org.drdel.beca.prjfinal.model.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
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
class GestoraServiceImplTest {

    @Autowired
    private GestoraServiceImpl gestoraService;

    @ParameterizedTest
    @Order(1)
    @DisplayName("Obtención de gestora por id para verificar existencia")
    @ValueSource(longs = {1,2})
    void testObtenerGestora(Long id){
        var gestora=gestoraService.obtenerGestora(id);
        assertNotNull(gestora);
    }

    @Test
    @Order(2)
    @DisplayName("Obtención de gestora por id")
    void testObtenerGestora(){
        var gestora=gestoraService.obtenerGestora(1L);
        assertEquals("360 CORA SGIIC, S.A.",gestora.getNombre());
        gestora= gestoraService.obtenerGestora(2L);
        assertEquals("4FOUNDERS CAPITAL SGEIC, S.A.",gestora.getNombre());

    }

    @Order(3)
    @Test
    @Disabled("Test de bajo performance")
    @DisplayName("Obtención de todas las gestoras")
    void testObtenerTodasGestora(){
        assertEquals(237,gestoraService.obtenerTodasGestoras().size());
    }



    @ParameterizedTest
    @DisplayName("Obtención del nombre de gestora para verification de existencia")
    @ValueSource(strings = "A&G FONDOS, SGIIC, SA")
    void testObtenerGestoraPorNombre(String nombre){
        var gestoras=gestoraService.obtenerGestoraPorNombre(nombre);
        assertNotEquals(0, gestoras.size());
    }


    /*
    @Test
    @DisplayName("Test Creación de Gestora")
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


}
