package org.drdel.beca.prjfinal.micro.operaciones.model.service;

import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondoClienteHistoryDTO;

import java.util.List;

public interface IFondoClienteHistoryService {

    List<FondoClienteHistoryDTO> obtenerTodosFondoCliente();
    FondoClienteHistoryDTO obtenerFondoCliente(Long id);

    Long activarFondoCliente(FondoClienteHistoryDTO fondoClienteHistoryDto);
    Long suspenderFondoCliente(FondoClienteHistoryDTO fondoClienteHistoryDTO);

    Long cancelarFondoCliente(FondoClienteHistoryDTO fondoClienteHistoryDTO);

    Long modificarImporte(FondoClienteHistoryDTO fondoClienteHistoryDTO, double importe);

}
