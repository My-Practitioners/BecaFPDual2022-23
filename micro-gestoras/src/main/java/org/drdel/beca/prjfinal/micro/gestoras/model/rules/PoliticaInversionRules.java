package org.drdel.beca.prjfinal.micro.gestoras.model.rules;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.PoliticaInversionDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.exception.PoliticaInversionException;
import org.drdel.beca.prjfinal.micro.gestoras.model.service.PoliticaInversionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PoliticaInversionRules {

    @Autowired
    PoliticaInversionServiceImpl politicaInversionService;

    public PoliticaInversionDTO activarPoliticaInversion(PoliticaInversionDTO politicaInversionDTO) {

        boolean draftToActive=false;

        int estadoOperative=EstadoEnum.OPERATIVE.getEstadoEnum();
        if (politicaInversionDTO.getIdEstadoPoliticaInversion()==EstadoEnum.DRAFT.getEstadoEnum()){
            draftToActive=true;
        }
        if (draftToActive){
            politicaInversionDTO.setIdEstadoPoliticaInversion(estadoOperative);
            return politicaInversionDTO;
        }else {
            try {
                return PoliticaInversionException.activarPoliticaInversion();
            } catch (PoliticaInversionException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public PoliticaInversionDTO suspenderPoliticaInversion(PoliticaInversionDTO politicaInversionDTO) {

        boolean operativeToSuspended=false;

        int estadoSuspended=EstadoEnum.SUSPENDED.getEstadoEnum();
        if (politicaInversionDTO.getIdEstadoPoliticaInversion()==EstadoEnum.OPERATIVE.getEstadoEnum()){
            operativeToSuspended=true;
        }
        if (operativeToSuspended){
            politicaInversionDTO.setIdEstadoPoliticaInversion(estadoSuspended);
            return politicaInversionDTO;
        }else {
            try {
                return PoliticaInversionException.suspenderPoliticaInversion();
            } catch (PoliticaInversionException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public PoliticaInversionDTO cancelarPoliticaInversion(PoliticaInversionDTO politicaInversionDTO) {

        boolean operativeToCanceled=false;

        int estadoCanceled=EstadoEnum.CANCELED.getEstadoEnum();
        if (politicaInversionDTO.getIdEstadoPoliticaInversion()==EstadoEnum.OPERATIVE.getEstadoEnum()){
            operativeToCanceled=true;
        }
        if (operativeToCanceled){
            politicaInversionDTO.setIdEstadoPoliticaInversion(estadoCanceled);
            return politicaInversionDTO;
        }else {
            try {
                return PoliticaInversionException.cancelarPoliticaInversion();
            } catch (PoliticaInversionException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public  PoliticaInversionDTO checkCrearPoliticaInversion(PoliticaInversionDTO politicaInversionDTO, EstadoEnum estadoEnum)  {

        boolean igualdad=false;

        if (politicaInversionDTO.getIdEstadoPoliticaInversion() == estadoEnum.getEstadoEnum()) {
            igualdad=true;
        }
        if (igualdad) {
            return politicaInversionDTO;
        }else {
            try {
                PoliticaInversionException.crearPoliticaInversion();
            } catch (PoliticaInversionException e) {
                throw new RuntimeException(e);
            }
        }
        return politicaInversionDTO;
    }

    public String checkBorrarPoliticaInversion(String code){

        boolean igualdad=false;

        var politicaInversionDto=politicaInversionService.obtenerPoliticaInversion(code).getIdEstadoPoliticaInversion();
        int estadoDraft=EstadoEnum.DRAFT.getEstadoEnum();
        if (politicaInversionDto==estadoDraft){
            igualdad=true;
        }
        if (igualdad){
            return code;
        }else {
            try {
                PoliticaInversionException.borrarPoliticaInversion();
            }catch (PoliticaInversionException e){
                throw new RuntimeException(e);
            }
        }
        return code;
    }
}
