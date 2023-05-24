package org.drdel.beca.prjfinal.micro.operaciones.model.service;

import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondoClienteHistoryDTO;

public interface IOperacionContratacionService {
    Long activarFondoCliente(FondoClienteHistoryDTO fondoClienteHistoryDto);

    Long suspenderFondoCliente(FondoClienteHistoryDTO fondoClienteHistoryDTO);

    Long cancelarFondoCliente(FondoClienteHistoryDTO fondoClienteHistoryDTO);

    Long modificarImporte(FondoClienteHistoryDTO fondoClienteHistoryDTO, double importe);
}
