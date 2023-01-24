package org.drdel.beca.prjfinal.micro.gestoras.model.rules;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.FondoInversionDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.exception.FondoInversionException;
import org.drdel.beca.prjfinal.micro.gestoras.model.service.FondoInversionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FondoInversionRules {

    @Autowired
    FondoInversionServiceImpl fondoInversionService;

    public FondoInversionDTO activarFondoInversion(FondoInversionDTO fondoInversionDTO) {

        boolean draftToActive=false;

        int estadoOperative=EstadoEnum.OPERATIVE.getEstadoEnum();
        if (fondoInversionDTO.getIdEstadoFondoInversion()==EstadoEnum.DRAFT.getEstadoEnum()){
            draftToActive=true;
        }
        if (draftToActive){
            fondoInversionDTO.setIdEstadoFondoInversion(estadoOperative);
            return fondoInversionDTO;
        }else {
            try {
                return FondoInversionException.activarFondoInversion();
            } catch (FondoInversionException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public FondoInversionDTO suspenderFondoInversion(FondoInversionDTO fondoInversionDTO) {

        boolean operativeToSuspended=false;

        int estadoSuspended=EstadoEnum.SUSPENDED.getEstadoEnum();
        if (fondoInversionDTO.getIdEstadoFondoInversion()==EstadoEnum.OPERATIVE.getEstadoEnum()){
            operativeToSuspended=true;
        }
        if (operativeToSuspended){
            fondoInversionDTO.setIdEstadoFondoInversion(estadoSuspended);
            return fondoInversionDTO;
        }else {
            try {
                return FondoInversionException.suspenderFondoInversion();
            } catch (FondoInversionException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public FondoInversionDTO cancelarFondoInversion(FondoInversionDTO fondoInversionDTO) {

        boolean operativeToCanceled=false;

        int estadoCanceled=EstadoEnum.CANCELED.getEstadoEnum();
        if (fondoInversionDTO.getIdEstadoFondoInversion()==EstadoEnum.OPERATIVE.getEstadoEnum()){
            operativeToCanceled=true;
        }
        if (operativeToCanceled){
            fondoInversionDTO.setIdEstadoFondoInversion(estadoCanceled);
            return fondoInversionDTO;
        }else {
            try {
                return FondoInversionException.cancelarFondoInversion();
            } catch (FondoInversionException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public  FondoInversionDTO checkCrearFondoInversion(FondoInversionDTO fondoInversionDTO, EstadoEnum estadoEnum)  {

        boolean igualdad=false;

        if (fondoInversionDTO.getIdEstadoFondoInversion() == estadoEnum.getEstadoEnum()) {
            igualdad=true;
        }
        if (igualdad) {
            return fondoInversionDTO;
        }else {
            try {
                FondoInversionException.crearFondoInversion();
            } catch (FondoInversionException e) {
                throw new RuntimeException(e);
            }
        }
        return fondoInversionDTO;
    }

    public String checkBorrarFondoInversion(String code){

        boolean igualdad=false;

        var fondoInversionDTO=fondoInversionService.obtenerFondoInversion(code).getIdEstadoFondoInversion();
        int estadoDraft=EstadoEnum.DRAFT.getEstadoEnum();
        if (fondoInversionDTO==estadoDraft){
            igualdad=true;
        }
        if (igualdad){
            return code;
        }else {
            try {
                FondoInversionException.borrarFondoInversion();
            }catch (FondoInversionException e){
                throw new RuntimeException(e);
            }
        }
        return code;
    }
}
