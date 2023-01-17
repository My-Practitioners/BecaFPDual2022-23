package org.drdel.beca.prjfinal.micro.clientes.model.exception;

public class ClienteException extends Exception{

    public ClienteException(String mensaje){
        super(mensaje);
    }

    public static void crearCliente() throws ClienteException{

        throw new ClienteException("El estado del nuevo cliente debe ser DRAFT(4)");
    }

    public static void borrarCliente() throws ClienteException{

        throw new ClienteException("Para borrar el cliente, su estado debe ser DRAFT(4)");
    }

    public static void activarCliente() throws ClienteException{

        throw new ClienteException("Para activar un cliente, su estado debe ser DRAFT(4)");
    }

    public static void suspenderCliente() throws ClienteException{

        throw new ClienteException("Para suspender un cliente, su estado debe ser OPERATIVE(1)");
    }

    public static void cancelarCliente() throws ClienteException{

        throw new ClienteException("Para cancelar un cliente, su estado debe ser OPERATIVE(1)");
    }
}
