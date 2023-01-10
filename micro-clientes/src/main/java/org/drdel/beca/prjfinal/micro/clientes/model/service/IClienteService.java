package org.drdel.beca.prjfinal.micro.clientes.model.service;

import org.drdel.beca.prjfinal.micro.clientes.model.domain.ClienteDTO;

import java.io.IOException;
import java.util.List;

public interface IClienteService {

    public ClienteDTO obtenerCliente(Long id);

    public List<ClienteDTO> obtenerTodosClientes();

    public Long crearCliente(ClienteDTO cliente);

    public List<ClienteDTO> obtenerClientePorApellido(String apellido);

    public void borrarCliente(Long id);

}
