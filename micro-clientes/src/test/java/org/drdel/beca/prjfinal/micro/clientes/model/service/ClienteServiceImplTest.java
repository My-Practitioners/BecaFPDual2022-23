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

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ClienteServiceImplTest {
    @Autowired
    ClienteServiceImpl clienteService;

    @ParameterizedTest
    @DisplayName("Obtencion de cliente por id para verificar existencia")
    @ValueSource(longs= {3,10})
    void testObtenerCliente(Long id){
        var cliente= clienteService.obtenerCliente(id);
        assertNotNull(cliente);
    }

    @Test
    @DisplayName("Obtencion de todos los clientes")
    void testObtenerTodasClientes(){
        assertEquals(101, clienteService.obtenerTodosClientes().size());
    }

    @ParameterizedTest
    @DisplayName("Obtencion de cliente por apellido para verificacion de existencia")
    @ValueSource(strings = "Raymond")
    void testObtenerClientePorApellido(String apellido){
        var cliente= clienteService.obtenerClientePorApellido(apellido);
        assertNotEquals(0, cliente.size());
    }

    @Test
    @DisplayName("Creacion de nuevo Cliente")
    void testCrearCliente()  {
        ClienteDTO clienteDto = new ClienteDTO(900L, 4, "Pedro", "Rodriguez", "Pedrorodrgiguez@gmail.com", new Date(121, Calendar.JULY,22));
        var cliente = clienteService.crearCliente(clienteDto);
        assertNotNull(cliente);
    }

    @ParameterizedTest
    @DisplayName("Borrar cliente por id")
    @ValueSource(longs = {11L})
    void testBorrarCliente(Long id){
        long clienteBorrado= clienteService.borrarCliente(id);
        var cliente=clienteService.obtenerCliente(id);
        assertNull(cliente);
        assertThat(clienteBorrado).isEqualTo(11L);
    }

    @Test
    @DisplayName("Actualizar cliente")
    void testActualizarCliente(){
        ClienteDTO dto = new ClienteDTO(10L, 2, "Maria", "Rivera", "mariarivera@gmail.com", new Date(120, Calendar.MAY, 13));
        var cliente = clienteService.actualizarCliente(dto);
        assertNotNull(cliente);
    }

    @Test
    @DisplayName("Activar cliente")
    void testActivarCliente(){
        var clienteDraft=clienteService.obtenerCliente(2L);
        clienteService.activarCliente(clienteDraft);
        assertThat(clienteDraft.getIdEstadoCliente()).isEqualTo(1);
    }

    @Test
    @DisplayName("Cancelar cliente")
    void testCancelarCliente(){
        var clienteOperative=clienteService.obtenerCliente(5L);
        clienteService.cancelarCliente(clienteOperative);
        assertThat(clienteOperative.getIdEstadoCliente()).isEqualTo(3);
    }

    @Test
    @DisplayName("Suspender cliente")
    void testSuspenderCliente(){
        var clienteOperative=clienteService.obtenerCliente(10L);
        clienteService.suspenderCliente(clienteOperative);
        assertThat(clienteOperative.getIdEstadoCliente()).isEqualTo(2);
    }
}
