package org.drdel.beca.prjfinal.micro.gestoras.model.exception;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.GestoraDTO;

public class GestoraException extends Exception {
    public GestoraException(String mensaje){
        super(mensaje);
    }

    public static void crearGestora() throws GestoraException {
        throw new GestoraException("Para crear la gestora, su estado debe ser DRAFT(4)");
    }

    public static void borrarGestora() throws GestoraException{

        throw new GestoraException("Para borrar la gestora, su estado debe ser DRAFT(4)");
    }

    public static GestoraDTO activarGestora() throws GestoraException{

        throw new GestoraException("Para activar una gestora, su estado debe ser DRAFT(4)");
    }

    public static GestoraDTO suspenderGestora() throws GestoraException{

        throw new GestoraException("Para suspender una gestora, su estado debe ser OPERATIVE(1)");
    }

    public static GestoraDTO cancelarGestora() throws GestoraException{

        throw new GestoraException("Para cancelar una gestora, su estado debe ser OPERATIVE(1)");
    }
}
