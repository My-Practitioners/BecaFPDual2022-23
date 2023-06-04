package org.drdel.beca.prjfinal.micro.gestoras.model.exception;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.PoliticaInversionDTO;

public class PoliticaInversionException extends Exception{

    public PoliticaInversionException(String mensaje){
        super(mensaje);
    }

    public static void crearPoliticaInversion() throws PoliticaInversionException {
        throw new PoliticaInversionException("Para crear una política de inversión, su estado debe ser DRAFT(4)");
    }

    public static void borrarPoliticaInversion() throws PoliticaInversionException{
        throw new PoliticaInversionException("Para borrar una política de inversión, su estado debe ser DRAFT(4)");
    }

    public static PoliticaInversionDTO activarPoliticaInversion() throws PoliticaInversionException{
        throw new PoliticaInversionException("Para activar una política de inversión, su estado debe ser DRAFT(4)");
    }

    public static PoliticaInversionDTO suspenderPoliticaInversion() throws PoliticaInversionException{
        throw new PoliticaInversionException("Para suspender una política de inversión, su estado debe ser OPERATIVE(1)");
    }

    public static PoliticaInversionDTO cancelarPoliticaInversion() throws PoliticaInversionException{
        throw new PoliticaInversionException("Para cancelar una política de inversión, su estado debe ser OPERATIVE(1)");
    }
}
