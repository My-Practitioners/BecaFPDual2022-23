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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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
    void testCrearCliente(){
        ClienteDTO dto = new ClienteDTO(900L, "Carlos", "Rodríguez", "carlosrodrgiguez@gmail.com", new Date(121,6,22));
        var cliente = clienteService.crearCliente(dto);
        assertNotNull(cliente);
    }

    @ParameterizedTest
    @DisplayName("Eliminar cliente por id")
    @ValueSource(longs = {10})
    void testBorrarCliente(Long id){
        long clienteBorrado = clienteService.borrarCliente(id);
        assertThat(clienteBorrado).isEqualTo(10);
    }

    @Test
    @DisplayName("Actualizar cliente")
    void testActualizarCliente(){
        ClienteDTO dto = new ClienteDTO(1L, "María", "Rivera", "mariarivera@gmail.com", new Date(120, 4, 13));
        var cliente = clienteService.actualizarCliente(dto);
        assertNotNull(cliente);
    }
}
