package org.drdel.beca.prjfinal.micro.clientes.model.service;

import org.drdel.beca.prjfinal.micro.clientes.model.domain.ClienteDTO;

import java.util.List;

public interface IClienteService {

     ClienteDTO obtenerCliente(Long id);

     List<ClienteDTO> obtenerTodosClientes();

     Long crearCliente(ClienteDTO clienteDto);

     List<ClienteDTO> obtenerClientePorApellido(String apellido);

     Long borrarCliente(Long id);

     Long actualizarCliente(ClienteDTO clienteDto);

     Long activarCliente(ClienteDTO clienteDto);

     Long cancelarCliente(ClienteDTO clienteDto);

     Long suspenderCliente(ClienteDTO clienteDto);

}
