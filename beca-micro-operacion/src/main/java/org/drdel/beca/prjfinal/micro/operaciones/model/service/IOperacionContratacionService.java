package org.drdel.beca.prjfinal.micro.operaciones.model.service;

import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondoClienteDTO;
import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondoClienteHistoryDTO;
import org.drdel.beca.prjfinal.micro.operaciones.model.entity.FondoCliente;
import org.drdel.beca.prjfinal.micro.operaciones.model.entity.FondoClienteHistory;

public interface IOperacionContratacionService {

    Long activarFondoCliente(FondoClienteHistoryDTO fondoClienteHistoryDto);

    Long suspenderFondoCliente(FondoClienteHistoryDTO fondoClienteHistoryDTO);

    Long cancelarFondoCliente(FondoClienteHistoryDTO fondoClienteHistoryDTO);

    Long modificarImporte(FondoClienteHistoryDTO fondoClienteHistoryDTO, double importe);

    Long contratarFondo(Integer id, String codIsin, FondoClienteDTO fondoClienteDTO);
}
