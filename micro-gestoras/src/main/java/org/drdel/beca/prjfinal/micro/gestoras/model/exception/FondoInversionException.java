package org.drdel.beca.prjfinal.micro.gestoras.model.exception;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.FondoInversionDTO;

public class FondoInversionException extends Exception{

    public FondoInversionException(String mensaje){
        super(mensaje);
    }

    public static void crearFondoInversion() throws FondoInversionException {
        throw new FondoInversionException("Para crear un fondo de inversión, su estado debe ser DRAFT(4)");
    }

    public static void borrarFondoInversion() throws FondoInversionException{
        throw new FondoInversionException("Para borrar un fondo de inversión, su estado debe ser DRAFT(4)");
    }

    public static FondoInversionDTO activarFondoInversion() throws FondoInversionException{
        throw new FondoInversionException("Para activar un fondo de inversión, su estado debe ser DRAFT(4)");
    }

    public static FondoInversionDTO suspenderFondoInversion() throws FondoInversionException{
        throw new FondoInversionException("Para suspender un fondo de inversión, su estado debe ser OPERATIVE(1)");
    }

    public static FondoInversionDTO cancelarFondoInversion() throws FondoInversionException{
        throw new FondoInversionException("Para cancelar un fondo de inversión, su estado debe ser OPERATIVE(1)");
    }
}
