package org.drdel.beca.prjfinal.micro.operaciones.model.exception;

import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondosClienteHistoryDTO;

public class FondosClienteHistoryException extends Exception{

    public FondosClienteHistoryException(String mensaje){
        super(mensaje);
    }

    public static FondosClienteHistoryDTO suspenderFondoCliente() throws FondosClienteHistoryException{
        throw new FondosClienteHistoryException("Para suspender un fondo de un cliente, su estado debe ser OPERATIVE(1)");
    }

    public static FondosClienteHistoryDTO cancelarFondoCliente() throws FondosClienteHistoryException{
        throw new FondosClienteHistoryException("Para cancelar un fondo de un cliente, su estado debe ser OPERATIVE(1)");
    }

}
