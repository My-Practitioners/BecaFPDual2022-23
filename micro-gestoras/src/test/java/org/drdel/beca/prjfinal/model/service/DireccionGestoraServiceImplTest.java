package org.drdel.beca.prjfinal.model.service;

import org.drdel.beca.prjfinal.model.dao.IDireccionGestoraDAO;
import org.drdel.beca.prjfinal.model.dtomapper.DireccionGestoraDTOMapper;
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
class DireccionGestoraServiceImplTest {
    @Autowired
    private DireccionGestoraServiceImpl direccionGestoraService;
    @Autowired
    private IDireccionGestoraDAO iDireccionGestoraDAO;

    @ParameterizedTest
    @DisplayName("Obtencion de direccion gestora por id para verificar existencia")
    @ValueSource(longs = {1L,2L})
    void testObtenerDireccionGestora(Long id){

        var dirGest= direccionGestoraService.obtenerDireccionGestora(id);
        assertNotNull(dirGest);
    }
    @Test
    @DisplayName("Obtencion de direccion gestora por id")
    void testobtenerDireccionGestora(){
        var dirGest= direccionGestoraService.obtenerDireccionGestora(1L);
        assertEquals("121, AVENUE DES CHAMPS ELYSEES, 75008, PARIS",dirGest.getDireccion());
        dirGest= direccionGestoraService.obtenerDireccionGestora(2L);
        assertEquals("32, RUE DE MONCEAU, 75008, PARIS",dirGest.getDireccion());
    }

    @Test
    @DisplayName("Obtencion de todas las direcciones gestora")
    void testObtenerTodasDireccionGestora(){
        assertEquals(569,direccionGestoraService.obtenerTodosDireccionGestora().size());
    }


    @ParameterizedTest
    @DisplayName("Obtencion de direcion gestora por nombre de direccion para verificacion de existencia")
    @ValueSource(strings = "AV. DIAGONAL Nº 399, 08008, BARCELONA")
    void testObtenerDireccionGestoraPorDireccion(String direccion){
        var direccionGestora=direccionGestoraService.obtenerDireccionGestoraPorDireccion(direccion);
        assertNotEquals(0,direccionGestora.size());
    }


    /*
    @ParameterizedTest
    @DisplayName("Test borrar direccion gestora para saber si se elimino la existencia")
    @ValueSource(longs = 1)
    void testBorrarDireccionGestora(Long id)throws IOException {
        direccionGestoraService.borrarDireccionGestora(id);
        assertNull(direccionGestoraService.obtenerDireccionGestora(id));
    }*/

}
