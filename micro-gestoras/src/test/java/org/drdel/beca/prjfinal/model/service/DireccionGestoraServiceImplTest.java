package org.drdel.beca.prjfinal.model.service;

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

    @ParameterizedTest
    @DisplayName("Obtencion de direccion gestora por id para verificar existencia")
    @ValueSource(longs = {1,2})
    void testObtenerDireccionGestora(Long id){

        var dirGestora= direccionGestoraService.obtenerDireccionGestora(id);
        assertNotNull(dirGestora);
    }
    @Test
    @DisplayName("Obtencion de direccion gestora por id")
    void testobtenerDireccionGestora(){
        var dirGestora= direccionGestoraService.obtenerDireccionGestora(1L);
        assertEquals("121, AVENUE DES CHAMPS ELYSEES, 75008, PARIS",dirGestora.getDireccion());
        dirGestora= direccionGestoraService.obtenerDireccionGestora(2L);
        assertEquals("32, RUE DE MONCEAU, 75008, PARIS",dirGestora.getDireccion());
    }

    @Test
    @DisplayName("Obtencion de todas las direcciones gestora")
    void testObtenerTodasDireccionGestora(){
        assertEquals(569,direccionGestoraService.obtenerTodosDireccionGestora().size());
    }


    @ParameterizedTest
    @DisplayName("Obtencion de direcion gestora por nombre de direccion para verificacion de existencia")
    @ValueSource(strings = "3RD FLOOR, 76 LOWER BAGGOT STREET DUBLIN 2")
    void testObtenerDireccionGestoraPorDireccion(String direccion){
        var direccionGestora=direccionGestoraService.obtenerDireccionGestoraPorDireccion(direccion);
        assertNotEquals(0,direccionGestora.size());
    }

}
