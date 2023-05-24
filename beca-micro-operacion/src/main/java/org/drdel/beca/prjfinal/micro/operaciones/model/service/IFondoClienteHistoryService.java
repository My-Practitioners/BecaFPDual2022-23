package org.drdel.beca.prjfinal.micro.operaciones.model.service;

import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondoClienteHistoryDTO;

import java.util.List;

public interface IFondoClienteHistoryService {

    List<FondoClienteHistoryDTO> obtenerTodosFondoCliente();
    FondoClienteHistoryDTO obtenerFondoCliente(Long id);
}
