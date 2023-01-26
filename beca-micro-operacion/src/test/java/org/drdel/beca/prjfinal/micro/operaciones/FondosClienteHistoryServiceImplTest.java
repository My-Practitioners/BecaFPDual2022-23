package org.drdel.beca.prjfinal.micro.operaciones;

import org.drdel.beca.prjfinal.micro.operaciones.model.service.FondosClienteHistoryServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FondosClienteHistoryServiceImplTest {

    @Autowired
    FondosClienteHistoryServiceImpl fondosClienteHistoryService;

    @ParameterizedTest
    @DisplayName("Obtencion de cliente por id para verificar existencia")
    @ValueSource(longs= {1, 2})
    void testObtenerFondoCliente(Long id){
        var fondo= fondosClienteHistoryService.obtenerFondoCliente(id);
        assertNotNull(fondo);
    }
    @Test
    @DisplayName("Suspender fondo de cliente")
    void testSuspenderFondoCliente(){
        var fondo = fondosClienteHistoryService.obtenerFondoCliente(1L);
        fondosClienteHistoryService.suspenderFondoCliente(fondo);
        assertThat(fondo.getEstadosContratacion()).isEqualTo(3);
        assertThat(fondo.getOperacionesContratacion()).isEqualTo("Suspender Fondo");
    }

    @Test
    @DisplayName("Cancelar fondo de cliente")
    void testCancelarFondoCliente(){
        var fondo = fondosClienteHistoryService.obtenerFondoCliente(2L);
        fondosClienteHistoryService.cancelarFondoCliente(fondo);
        assertThat(fondo.getEstadosContratacion()).isEqualTo(2);
        assertThat(fondo.getOperacionesContratacion()).isEqualTo("Cancelar Fondo");
    }

}
