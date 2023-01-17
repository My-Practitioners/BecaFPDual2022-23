package org.drdel.beca.prjfinal.micro.clientes.model.exception;

import org.drdel.beca.prjfinal.micro.clientes.model.domain.ClienteDTO;
import org.drdel.beca.prjfinal.micro.clientes.model.rule.ClientesRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClienteException extends Exception{

    public ClienteException(String mensaje){
        super(mensaje);
    }

    private static final Logger log = LoggerFactory.getLogger(ClienteException.class);

    public static void crearCliente(Exception e) {

        log.error(e.getMessage(),e);
        log.error("El estado del nuevo cliente debe ser DRAFT(4)");

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
