package org.drdel.beca.prjfinal.micro.gestoras.model.service;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.GestoraDTO;
import org.junit.jupiter.api.Disabled;
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
class GestoraServiceImplTest {

    @Autowired
    GestoraServiceImpl gestoraService;

    @Test
    @DisplayName("Test crear Gestora")
    void testCrearGestora(){
        GestoraDTO dto = new GestoraDTO(900L,4, "GESTORAX");
        var gestora = gestoraService.crearGestora(dto);
        assertEquals("GESTORAX",dto.getNombre());
    }

    @Test
    @DisplayName("Test borrar Gestora")
    void testBorrarGestora(){
        gestoraService.borrarGestora(237L);
        assertNull(gestoraService.obtenerGestora(237L));
    }

    @Test
    @DisplayName("Test actualizar gestora")
    void testActualizarGestora(){
        GestoraDTO gestoraDto = new GestoraDTO(15L, 2, "GestoraUpdate");
        var cliente = gestoraService.actualizarGestora(gestoraDto);
        assertNotNull(cliente);
    }

    @Test
    @DisplayName("Test activar gestora solo si está en estado DRAFT")
    void testActivarGestora(){
        var gestoraDraft=gestoraService.obtenerGestora(10L);
        gestoraService.activarGestora(gestoraDraft);
        assertThat(gestoraDraft.getIdEstadoGestora()).isEqualTo(1);
    }

    @Test
    @DisplayName("Test de suspender gestora solo si está en operative")
    void testSuspenderGestora(){
        var gestoraOperative=gestoraService.obtenerGestora(20L);
        gestoraService.suspenderGestora(gestoraOperative);
        assertThat(gestoraOperative.getIdEstadoGestora()).isEqualTo(2);
    }

    @Test
    @DisplayName("Test de cancelar gestora solo si está en operative")
    void testCancelarGestora(){
        var gestoraOperative=gestoraService.obtenerGestora(30L);
        gestoraService.cancelarGestora(gestoraOperative);
        assertThat(gestoraOperative.getIdEstadoGestora()).isEqualTo(3);
    }


    @Test
    @DisplayName("Obtención de gestora por id para verificar existencia")
    void testObtenerGestora(){
        var gestora=gestoraService.obtenerGestora(2L);
        assertNotNull(gestora);
    }

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
}
