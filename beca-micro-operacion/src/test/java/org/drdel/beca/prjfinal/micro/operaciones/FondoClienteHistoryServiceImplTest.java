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
        var fondo= fondoClienteHistoryService.obtenerFondoClienteHistory(id);
        assertNotNull(fondo);
    }

    @Test
    @DisplayName("Test obtener todos los fondo cliente de la base de datos")
    void TestObtenerTodosFondoCliente(){
        assertEquals(8,fondoClienteHistoryService.obtenerTodosFondoClienteHistory().size());
    }
}
