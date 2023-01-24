package org.drdel.beca.prjfinal.micro.gestoras.model.exception;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.VariabilidadCapitalDTO;

public class VariabilidadCapitalException extends Exception{

    public VariabilidadCapitalException(String mensaje){
        super(mensaje);
    }

    public static void crearVariabilidadCapital() throws VariabilidadCapitalException {
        throw new VariabilidadCapitalException("Para crear la Variabilidad Capital, su estado debe ser DRAFT(4)");
    }

    public static void borrarVariabilidadCapital() throws VariabilidadCapitalException{

        throw new VariabilidadCapitalException("Para borrar la Variabilidad Capital, su estado debe ser DRAFT(4)");
    }

    public static VariabilidadCapitalDTO activarVariabilidadCapital() throws VariabilidadCapitalException{

        throw new VariabilidadCapitalException("Para activar una Variabilidad Capital, su estado debe ser DRAFT(4)");
    }

    public static VariabilidadCapitalDTO suspenderVariabilidadCapital() throws VariabilidadCapitalException{

        throw new VariabilidadCapitalException("Para suspender una Variabilidad Capital, su estado debe ser OPERATIVE(1)");
    }

    public static VariabilidadCapitalDTO cancelarVariabilidadCapital() throws VariabilidadCapitalException{

        throw new VariabilidadCapitalException("Para cancelar una Variabilidad Capital, su estado debe ser OPERATIVE(1)");
    }
}
