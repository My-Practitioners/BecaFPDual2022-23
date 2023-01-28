package org.drdel.beca.prjfinal.micro.clientes.model.service;

import org.drdel.beca.prjfinal.micro.clientes.model.domain.ClienteDTO;
import org.drdel.beca.prjfinal.micro.clientes.model.exception.ClienteException;

import java.util.List;

public interface IClienteService {

     ClienteDTO obtenerCliente(Long id);

     List<ClienteDTO> obtenerTodosClientes();

     Long crearCliente(ClienteDTO clienteDto) throws ClienteException;

     List<ClienteDTO> obtenerClientePorApellido(String apellido);

     Long borrarCliente(Long id) throws ClienteException;

     Long actualizarCliente(ClienteDTO clienteDto);

     Long activarCliente(ClienteDTO clienteDto) throws ClienteException;

     Long cancelarCliente(ClienteDTO clienteDto) throws ClienteException;

     Long suspenderCliente(ClienteDTO clienteDto) throws ClienteException;

}
