package org.drdel.beca.prjfinal.micro.clientes.model.service;

import org.drdel.beca.prjfinal.micro.clientes.model.domain.ClienteDTO;
import org.drdel.beca.prjfinal.micro.clientes.model.exception.ClienteException;

import java.util.List;

public interface IClienteService {

     ClienteDTO obtenerCliente(Long id);

     List<ClienteDTO> obtenerTodosClientes();

     Long crearCliente(ClienteDTO clienteDTO) throws ClienteException;

     List<ClienteDTO> obtenerClientePorApellido(String apellido);

     Long borrarCliente(Long id);

     Long actualizarCliente(ClienteDTO clienteDTO);

     Long activarCliente(ClienteDTO clienteDTO);

     Long cancelarCliente(ClienteDTO clienteDTO);

     Long suspenderCliente(ClienteDTO clienteDTO);

}
