package org.drdel.beca.prjfinal.micro.clientes.model.service;

import org.drdel.beca.prjfinal.micro.clientes.model.domain.ClienteDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ClienteServiceImplTest {

    @Autowired
    ClienteServiceImpl clienteService;

    @ParameterizedTest
    @DisplayName("Obtencion de cliente por id para verificar existencia")
    @ValueSource(longs = {1,2})
    void testObtenerCliente(Long id){
        var cliente= clienteService.obtenerCliente(id);
        assertNotNull(cliente);
    }

    @Test
    @DisplayName("Obtencion de todos los clientes")
    void testObtenerTodasClientes(){
        assertEquals(101,clienteService.obtenerTodosClientes().size());
    }

    @ParameterizedTest
    @DisplayName("Obtencion de cliente por apellido para verificacion de existencia")
    @ValueSource(strings = "Mosley")
    void testObtenerClientePorApellido(String apellido){
        var cliente=clienteService.obtenerClientePorApellido(apellido);
        assertNotEquals(0,cliente.size());
    }

    @Test
    @DisplayName("Creacion de nuevo Cliente")
    void testCrearDireccionGestora(){
        Date fecha = new Date(121, 6, 2);
        ClienteDTO dto = new ClienteDTO(900L, "Carlos", "Rodríguez", "carlosrodrgiguez@gmail.com", fecha);
        var cliente = clienteService.crearCliente(dto);
        assertNotNull(cliente);
    }
}
