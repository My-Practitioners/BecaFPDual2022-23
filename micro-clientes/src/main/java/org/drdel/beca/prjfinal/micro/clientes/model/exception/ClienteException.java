package org.drdel.beca.prjfinal.micro.clientes.model.exception;

import org.drdel.beca.prjfinal.micro.clientes.model.domain.ClienteDTO;

public class ClienteException extends Exception{

    public ClienteException(String mensaje){
        super(mensaje);
    }

    public static void crearCliente() throws ClienteException {
        throw new ClienteException("Para crear el cliente, su estado debe ser DRAFT(4)");
    }

    public static ClienteDTO borrarCliente() throws ClienteException{

        throw new ClienteException("Para borrar el cliente, su estado debe ser DRAFT(4)");
    }

    public static ClienteDTO activarCliente() throws ClienteException{

        throw new ClienteException("Para activar un cliente, su estado debe ser DRAFT(4)");
    }

    public static ClienteDTO suspenderCliente() throws ClienteException{

        throw new ClienteException("Para suspender un cliente, su estado debe ser OPERATIVE(1)");
    }

    public static ClienteDTO cancelarCliente() throws ClienteException{

        throw new ClienteException("Para cancelar un cliente, su estado debe ser OPERATIVE(1)");
    }
}
