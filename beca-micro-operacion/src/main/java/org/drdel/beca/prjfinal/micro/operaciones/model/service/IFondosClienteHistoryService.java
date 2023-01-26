package org.drdel.beca.prjfinal.micro.operaciones.model.service;

import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondosClienteHistoryDTO;

public interface IFondosClienteHistoryService {

    FondosClienteHistoryDTO obtenerFondoCliente(Long id);

    int suspenderFondoCliente(FondosClienteHistoryDTO fondosClienteHistoryDTO);

    int cancelarFondoCliente(FondosClienteHistoryDTO fondosClienteHistoryDTO);

}
