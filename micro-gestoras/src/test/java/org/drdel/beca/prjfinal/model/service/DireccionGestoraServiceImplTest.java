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
class DireccionGestoraServiceImplTest {
    @Autowired
    private DireccionGestoraServiceImpl direccionGestoraService;

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
        assertEquals("121, AVENUE DES CHAMPS ELYSÉES, 75008, PARIS",dirGest.getDireccion());
        dirGest= direccionGestoraService.obtenerDireccionGestora(2L);
        assertEquals("32, RUE DE MONCEAU, 75008, PARIS",dirGest.getDireccion());
    }
}
