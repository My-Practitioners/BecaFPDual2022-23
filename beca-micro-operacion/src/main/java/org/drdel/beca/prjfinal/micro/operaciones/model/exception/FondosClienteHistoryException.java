package org.drdel.beca.prjfinal.micro.operaciones.model.exception;

import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondosClienteHistoryDTO;

public class FondosClienteHistoryException extends Exception{

    public FondosClienteHistoryException(String mensaje){
        super(mensaje);
    }

    public static FondosClienteHistoryDTO suspenderFondoCliente() throws FondosClienteHistoryException{
        throw new FondosClienteHistoryException("Este fondo de cliente ya estaba suspendido");
    }

    public static FondosClienteHistoryDTO cancelarFondoCliente() throws FondosClienteHistoryException{
        throw new FondosClienteHistoryException("Este fondo de cliente ya estaba cancelado");
    }

}
