package org.drdel.beca.prjfinal.micro.gestoras.model.service;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.DireccionGestoraDTO;
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
class DireccionGestoraServiceImplTest {
    @Autowired
    DireccionGestoraServiceImpl direccionGestoraService;

    @Test
    @DisplayName("Test Crear de Direccion Gestora")
    void testCrearDireccionGestora(){
        DireccionGestoraDTO dto=new DireccionGestoraDTO(570L,4,300L,"Garcia Lorca");
        var direccionGestora=direccionGestoraService.crearDireccionGestora(dto);
        assertEquals("Garcia Lorca",dto.getDireccion());
        direccionGestoraService.borrarDireccionGestora(570L);
    }

    @Test
    @DisplayName("Test Borrar de Direccion Gestora")
    void testBorrarDireccionGestora(){
        direccionGestoraService.borrarDireccionGestora(535L);
        assertNull(direccionGestoraService.obtenerDireccionGestora(535L));
        direccionGestoraService.crearDireccionGestora(new DireccionGestoraDTO(535L, 4, 134L, "RAFAEL CALVO, 40, 1º 2, 28010, MADRID"));

    }

    @Test
    @DisplayName("Test actualizar Direccion Gestora")
    void testActualizarDireccionGestora(){
        DireccionGestoraDTO dto=new DireccionGestoraDTO(100L,3,30L,"Calle de Guadalix");
        var direccionGestoraAct=direccionGestoraService.actualizarDireccionGestora(dto);
        assertNotNull(direccionGestoraAct);
    }

    @Test
    @DisplayName("Test activar Direccion Gestora")
    void testActivarDireccionGestora(){
        var direccionGestoraDraft=direccionGestoraService.obtenerDireccionGestora(10L);
        direccionGestoraService.activarDireccionGestora(direccionGestoraDraft);
        assertThat(direccionGestoraDraft.getIdEstadoDireccionGestora()).isEqualTo(1);
    }

    @Test
    @DisplayName("Test suspender Direccion Gestora solo si está en operative")
    void testSuspenderDireccionGestora(){
        var direccionGestoraOperative=direccionGestoraService.obtenerDireccionGestora(20L);
        direccionGestoraService.suspenderDireccionGestora(direccionGestoraOperative);
        assertThat(direccionGestoraOperative.getIdEstadoDireccionGestora()).isEqualTo(2);
    }

    @Test
    @DisplayName("Test cancelar Direccion Gestora solo si está en operative")
    void testCancelarDireccionGestora(){
        var gestoraOperative=direccionGestoraService.obtenerDireccionGestora(30L);
        direccionGestoraService.cancelarDireccionGestora(gestoraOperative);
        assertThat(gestoraOperative.getIdEstadoDireccionGestora()).isEqualTo(3);
    }

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

    @ParameterizedTest
    @DisplayName("Obtencion de direcion gestora por nombre de direccion para verificacion de existencia")
    @ValueSource(strings = "3RD FLOOR, 76 LOWER BAGGOT STREET DUBLIN 2")
    void testObtenerDireccionGestoraPorDireccion(String direccion){
        var direccionGestora=direccionGestoraService.obtenerDireccionGestoraPorDireccion(direccion);
        assertNotEquals(0,direccionGestora.size());
    }

    @Test
    @DisplayName("Obtencion de todas las direcciones gestora")
    void testObtenerTodasDireccionGestora(){
        assertEquals(569,direccionGestoraService.obtenerTodosDireccionGestora().size());
    }

}
