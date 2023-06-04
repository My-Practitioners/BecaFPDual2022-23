package org.drdel.beca.prjfinal.micro.gestoras.model.exception;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.DireccionGestoraDTO;
public class DireccionGestoraException extends Exception {

    public DireccionGestoraException(String mensaje){
        super(mensaje);
    }

    public static void crearDireccionGestora() throws DireccionGestoraException {
        throw new DireccionGestoraException("Para crear la Direccion gestora, su estado debe ser DRAFT(4)");
    }

    public static void borrarDireccionGestora() throws DireccionGestoraException{

        throw new DireccionGestoraException("Para borrar la Direccion gestora, su estado debe ser DRAFT(4)");
    }

    public static DireccionGestoraDTO activarDireccionGestora() throws DireccionGestoraException{

        throw new DireccionGestoraException("Para activar una Direccion gestora, su estado debe ser DRAFT(4)");
    }

    public static DireccionGestoraDTO suspenderDireccionGestora() throws DireccionGestoraException{

        throw new DireccionGestoraException("Para suspender una Direccion gestora, su estado debe ser OPERATIVE(1)");
    }

    public static DireccionGestoraDTO cancelarDireccionGestora() throws DireccionGestoraException{

        throw new DireccionGestoraException("Para cancelar una Direccion gestora, su estado debe ser OPERATIVE(1)");
    }
}
