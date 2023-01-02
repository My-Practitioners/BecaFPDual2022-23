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
class GestoraServiceImplTest {

    @Autowired
    private GestoraServiceImpl gestoraService;

    @ParameterizedTest
    @DisplayName("Obtencion de gestora por id para verificar existencia")
    @ValueSource(longs = {1,2})
    void testObtenerGestora(Long id){

        var gestDTO=gestoraService.obtenerGestora(id);
        assertNotNull(gestDTO);
    }

    @Test
    @DisplayName("Obtencion de gestora por id")
    void testobtenerGestora(){
        var gestDTO=gestoraService.obtenerGestora(1L);
        assertEquals("360 CORA SGIIC, S.A.",gestDTO.getNombre());
        gestDTO= gestoraService.obtenerGestora(2L);
        assertEquals("4FOUNDERS CAPITAL SGEIC, S.A.",gestDTO.getNombre());

    }
}
