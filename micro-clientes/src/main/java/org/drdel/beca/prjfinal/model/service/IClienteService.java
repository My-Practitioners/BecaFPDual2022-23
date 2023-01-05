package org.drdel.beca.prjfinal.model.service;

import org.drdel.beca.prjfinal.model.domain.ClienteDTO;

import java.util.List;

public interface IClienteService {

    public ClienteDTO obtenerCliente(Long id);

    public List<ClienteDTO> obtenerTodosClientes();

    public Long crearCliente(ClienteDTO cliente);

    public List<ClienteDTO> obtenerClientePorNombre(String nombre);

    /*public ClienteDTO obtenerClienteConFondo(Long id);*/
}
