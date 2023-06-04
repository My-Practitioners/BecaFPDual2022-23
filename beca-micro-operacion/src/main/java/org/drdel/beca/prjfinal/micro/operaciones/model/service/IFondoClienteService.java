package org.drdel.beca.prjfinal.micro.operaciones.model.service;

import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondoClienteDTO;


import java.util.List;

public interface IFondoClienteService {
    FondoClienteDTO obtenerFondoCliente(Long id);

    List<FondoClienteDTO> obtenerTodosFondoCliente();
}
