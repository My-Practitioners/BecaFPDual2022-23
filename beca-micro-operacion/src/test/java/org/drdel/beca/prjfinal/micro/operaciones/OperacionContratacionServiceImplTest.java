package org.drdel.beca.prjfinal.micro.operaciones;

import org.drdel.beca.prjfinal.micro.operaciones.model.service.FondoClienteHistoryServiceImpl;
import org.drdel.beca.prjfinal.micro.operaciones.model.service.OperacionContratacionServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OperacionContratacionServiceImplTest {
    @Autowired
    OperacionContratacionServiceImpl operacionContratacionService;
    @Autowired
    FondoClienteHistoryServiceImpl fondoClienteHistoryService;

    @Test
    @DisplayName("Test activar fondo de cliente")
    void testActivarFondoCliente(){
        var fondoClienteHistoryDTO=fondoClienteHistoryService.obtenerFondoClienteHistory(4L);
        operacionContratacionService.activarFondoCliente(fondoClienteHistoryDTO);
        assertThat(fondoClienteHistoryDTO.getIdEstadoContratacion()).isEqualTo(1);
        assertThat(fondoClienteHistoryDTO.getIdOperacionContratacion()).isEqualTo(4);
    }

    @Test
    @DisplayName("Suspender fondo de cliente")
    void testSuspenderFondoCliente(){
        var fondoClienteHistoryDTO = fondoClienteHistoryService.obtenerFondoClienteHistory(1L);
        operacionContratacionService.suspenderFondoCliente(fondoClienteHistoryDTO);
        assertThat(fondoClienteHistoryDTO.getIdEstadoContratacion()).isEqualTo(3);
        assertThat(fondoClienteHistoryDTO.getIdOperacionContratacion()).isEqualTo(3);
    }

    @Test
    @DisplayName("Cancelar fondo de cliente")
    void testCancelarFondoCliente(){
        var fondoClienteHistoryDTO = fondoClienteHistoryService.obtenerFondoClienteHistory(2L);
        operacionContratacionService.cancelarFondoCliente(fondoClienteHistoryDTO);
        assertThat(fondoClienteHistoryDTO.getIdEstadoContratacion()).isEqualTo(2);
        assertThat(fondoClienteHistoryDTO.getIdOperacionContratacion()).isEqualTo(5);
    }


    @ParameterizedTest
    @DisplayName("Test para modificar importe si su estado está operativo y su operacion es modificar importe")
    @ValueSource(doubles = 2109.5)
    void testModificarImporte(double importe){
        var dto=fondoClienteHistoryService.obtenerFondoClienteHistory(3L);
        operacionContratacionService.modificarImporte(dto,importe);
        assertThat(dto.getImporte()).isEqualTo(2109.5);
    }
}
