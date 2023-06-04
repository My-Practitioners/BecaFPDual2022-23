package org.drdel.beca.prjfinal.micro.operaciones.model.exception;

import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondoClienteHistoryDTO;

public class FondoClienteHistoryException extends Exception{

    public FondoClienteHistoryException(String mensaje){
        super(mensaje);
    }

    public static FondoClienteHistoryDTO verificaCliente() throws FondoClienteHistoryException {
        throw new FondoClienteHistoryException("El cliente que has indicado no existe.");
    }

    public static FondoClienteHistoryDTO verificaFondo() throws FondoClienteHistoryException {
        throw new FondoClienteHistoryException("El fondo que has indicado no existe.");
    }

    public static FondoClienteHistoryDTO activarFondoCliente() throws FondoClienteHistoryException {
        throw new FondoClienteHistoryException("Este fondo de cliente ya estaba suspendido.");
    }

    public static FondoClienteHistoryDTO suspenderFondoCliente() throws FondoClienteHistoryException {
        throw new FondoClienteHistoryException("Este fondo de cliente ya estaba suspendido.");
    }

    public static FondoClienteHistoryDTO cancelarFondoCliente() throws FondoClienteHistoryException {
        throw new FondoClienteHistoryException("Este fondo de cliente ya estaba cancelado.");
    }
    public static FondoClienteHistoryDTO modificarImporte() throws FondoClienteHistoryException{
        throw new FondoClienteHistoryException("Para modificar un importe de un fondo cliente, su estado de contratacion debe ser Operative(1), y su operacion de contratacion debe ser Modificar Importe(2).");
    }
}
