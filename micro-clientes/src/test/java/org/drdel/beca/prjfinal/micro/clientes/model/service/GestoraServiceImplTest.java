package org.drdel.beca.prjfinal.micro.clientes.model.service;

import org.junit.jupiter.api.Disabled;
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
class GestoraServiceImplTest {

    @Autowired
    GestoraServiceImpl gestoraService;

    @ParameterizedTest
    @DisplayName("Obtención de gestora por id para verificar existencia")
    @ValueSource(longs = {1,2})
    void testObtenerGestora(Long id){
        var gestora=gestoraService.obtenerGestora(id);
        assertNotNull(gestora);
    }

    @Test
    @DisplayName("Obtención de Gestora por id")
    void testObtenerGestora(){
        var gestora=gestoraService.obtenerGestora(1L);
        assertEquals("360 CORA SGIIC, S.A.",gestora.getNombre());
        gestora= gestoraService.obtenerGestora(2L);
        assertEquals("4FOUNDERS CAPITAL SGEIC, S.A.",gestora.getNombre());
    }

    @Disabled
    @Test
    @DisplayName("Obtención de todas las Gestoras")
    void testObtenerTodasGestora(){
        assertEquals(237,gestoraService.obtenerTodasGestoras().size());
    }

    @ParameterizedTest
    @DisplayName("Obtención del nombre de Gestora para verification de existencia")
    @ValueSource(strings = "A&G FONDOS, SGIIC, SA")
    void testObtenerGestoraPorNombre(String nombre){
        var gestoras=gestoraService.obtenerGestoraPorNombre(nombre);
        assertNotEquals(0, gestoras.size());
    }


    @ParameterizedTest
    @DisplayName("Creacion de nueva Gestora2")
    @ValueSource(longs = 900)
    void testCrearGestora(Long idGestora){
        var gestora=gestoraService.crearGestora2(idGestora,"gestoraPrueba");
        assertNotNull(gestora);

    }

    /*@Test
    @DisplayName("Creacion de nueva Gestora")
    void testCrearGestora(){
        GestoraDTO dto = new GestoraDTO(900L, "GESTORAX");
        var gestora = gestoraService.crearGestora(dto);
        assertEquals("GESTORAX",dto.getNombre());
    }
    */
}
