package org.drdel.beca.prjfinal.micro.operaciones;

import org.drdel.beca.prjfinal.micro.operaciones.model.service.FondoClienteHistoryServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FondoClienteHistoryServiceImplTest {

    @Autowired
    FondoClienteHistoryServiceImpl fondoClienteHistoryService;

    @ParameterizedTest
    @DisplayName("Obtencion de cliente por id para verificar existencia")
    @ValueSource(longs= {1, 2})
    void testObtenerFondoCliente(Long id){
        var fondo= fondoClienteHistoryService.obtenerFondoCliente(id);
        assertNotNull(fondo);
    }

    @Test
    @DisplayName("Test obtener todos los fondo cliente de la base de datos")
    void TestObtenerTodosFondoCliente(){
        assertEquals(8,fondoClienteHistoryService.obtenerTodosFondoCliente().size());
    }

    @Test
    @DisplayName("Test activar fondo de cliente")
    void testActivarFondoCliente(){
        var dto=fondoClienteHistoryService.obtenerFondoCliente(4L);
        fondoClienteHistoryService.activarFondoCliente(dto);
        assertThat(dto.getIdEstadoContratacion()).isEqualTo(1);
        assertThat(dto.getIdOperacionContratacion()).isEqualTo(4);
    }

    @Test
    @DisplayName("Suspender fondo de cliente")
    void testSuspenderFondoCliente(){
        var fondo = fondoClienteHistoryService.obtenerFondoCliente(1L);
        fondoClienteHistoryService.suspenderFondoCliente(fondo);
        assertThat(fondo.getIdEstadoContratacion()).isEqualTo(3);
        assertThat(fondo.getIdOperacionContratacion()).isEqualTo(3);
    }

    @Test
    @DisplayName("Cancelar fondo de cliente")
    void testCancelarFondoCliente(){
        var fondo = fondoClienteHistoryService.obtenerFondoCliente(2L);
        fondoClienteHistoryService.cancelarFondoCliente(fondo);
        assertThat(fondo.getIdEstadoContratacion()).isEqualTo(2);
        assertThat(fondo.getIdOperacionContratacion()).isEqualTo(5);
    }


    @ParameterizedTest
    @DisplayName("Test para modificar importe si su estado está operativo y su operacion es modificar importe")
    @ValueSource(doubles = 2109.5)
    void testModificarImporte(double importe){
        var dto=fondoClienteHistoryService.obtenerFondoCliente(3L);
        fondoClienteHistoryService.modificarImporte(dto,importe);
        assertThat(dto.getImporte()).isEqualTo(2109.5);
    }
}
