package org.drdel.beca.prjfinal.micro.clientes.model.service;

import org.drdel.beca.prjfinal.micro.clientes.model.domain.ClienteDTO;
import org.drdel.beca.prjfinal.micro.clientes.model.exception.ClienteException;
import org.drdel.beca.prjfinal.micro.clientes.model.rule.ClienteEstadoEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
    void testCrearCliente() throws ClienteException {
        ClienteDTO clienteDto = new ClienteDTO(900L, 0, "Pedro", "Rodriguez", "Pedrorodrgiguez@gmail.com", new Date(121, Calendar.JULY,22));
        var cliente = clienteService.crearCliente(clienteDto);
        assertNotNull(cliente);
    }

    @ParameterizedTest
    @DisplayName("Borrar cliente por id")
    @ValueSource(longs = {11L})
    void testBorrarCliente(Long id) throws ClienteException {
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
    void testActivarCliente() throws ClienteException {
        var idCliente = 2L;
        var clienteDraft = clienteService.obtenerCliente(idCliente);
        var idClienteReturned = clienteService.activarCliente(clienteDraft);
        // aseguro que los ID son iguales después de suspender el cliente
        assertEquals(idCliente, idClienteReturned);
        var clienteActivado = clienteService.obtenerCliente(idCliente);
        // aseguro que el estado nuevo ha cambiado en la BBDD
        assertThat(clienteActivado.getIdEstadoCliente()).isEqualTo(ClienteEstadoEnum.OPERATIVE.getEstadoEnum());
    }

    @Test
    @DisplayName("Cancelar cliente ")
    void testCancelarCliente() throws ClienteException {
        var idCliente = 5L;
        var clienteOperative = clienteService.obtenerCliente(idCliente);
        var idClienteReturned = clienteService.cancelarCliente(clienteOperative);
        // aseguro que los ID son iguales después de suspender el cliente
        assertEquals(idCliente, idClienteReturned);
        var clienteCancelado = clienteService.obtenerCliente(idCliente);
        // aseguro que el estado nuevo ha cambiado en la BBDD
        assertThat(clienteCancelado.getIdEstadoCliente()).isEqualTo(ClienteEstadoEnum.CANCELED.getEstadoEnum());
    }

    @Test
    @DisplayName("Suspender cliente")
    void testSuspenderCliente() throws ClienteException {
        var idCliente = 10L;
        var clienteOperative = clienteService.obtenerCliente(idCliente);
        var idClienteReturned = clienteService.suspenderCliente(clienteOperative);
        // aseguro que los ID son iguales después de suspender el cliente
        assertEquals(idCliente, idClienteReturned);
        var clienteSuspendido = clienteService.obtenerCliente(idCliente);
        // aseguro que el estado nuevo ha cambiado en la BBDD
        assertThat(clienteSuspendido.getIdEstadoCliente()).isEqualTo(ClienteEstadoEnum.SUSPENDED.getEstadoEnum());
    }


    @Test
    @DisplayName("Cambiar estado de cliente")
    void testCambiarEstadoCliente() throws ClienteException {
        var idCliente = 13L;
        var clienteOperative = clienteService.obtenerCliente(idCliente);
        var idClienteReturned = clienteService.cambiarEstadoCliente(clienteOperative, ClienteEstadoEnum.SUSPENDED.getEstadoEnum());
        // aseguro que los ID son iguales después de suspender el cliente
        assertEquals(idCliente, idClienteReturned);
        var clienteSuspendido = clienteService.obtenerCliente(idCliente);
        // aseguro que el estado nuevo ha cambiado en la BBDD
        assertThat(clienteSuspendido.getIdEstadoCliente()).isEqualTo(ClienteEstadoEnum.SUSPENDED.getEstadoEnum());
    }



}
