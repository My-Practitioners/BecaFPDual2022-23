package org.drdel.beca.prjfinal.micro.gestoras.model.rules;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.GestoraDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.domain.VariabilidadCapitalDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.exception.GestoraException;
import org.drdel.beca.prjfinal.micro.gestoras.model.exception.VariabilidadCapitalException;
import org.drdel.beca.prjfinal.micro.gestoras.model.service.VariabilidadCapitalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class VariabilidadCapitalRules {
    @Autowired
    VariabilidadCapitalServiceImpl variabilidadCapitalService;

    public VariabilidadCapitalDTO activarEstado(VariabilidadCapitalDTO variabilidadCapitalDto) {

        boolean draftToActive=false;

        int estadoOperative= EstadoEnum.OPERATIVE.getEstadoEnum();
        if (variabilidadCapitalDto.getIdEstadoVariabilidadCapital()==EstadoEnum.DRAFT.getEstadoEnum()){
            draftToActive=true;
        }
        if (draftToActive){
            variabilidadCapitalDto.setIdEstadoVariabilidadCapital(estadoOperative);
            return variabilidadCapitalDto;
        }else {
            try {
                return VariabilidadCapitalException.activarVariabilidadCapital();
            } catch (VariabilidadCapitalException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public VariabilidadCapitalDTO suspenderEstado(VariabilidadCapitalDTO variabilidadCapitalDto) {

        boolean operativeToSuspended=false;

        int estadoSuspended=EstadoEnum.SUSPENDED.getEstadoEnum();
        if (variabilidadCapitalDto.getIdEstadoVariabilidadCapital()==EstadoEnum.OPERATIVE.getEstadoEnum()){
            operativeToSuspended=true;
        }
        if (operativeToSuspended){
            variabilidadCapitalDto.setIdEstadoVariabilidadCapital(estadoSuspended);
            return variabilidadCapitalDto;
        }else {
            try {
                return VariabilidadCapitalException.suspenderVariabilidadCapital();
            } catch (VariabilidadCapitalException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public VariabilidadCapitalDTO cancelarEstado(VariabilidadCapitalDTO variabilidadCapitalDto) {

        boolean operativeToCanceled=false;

        int estadoCanceled=EstadoEnum.CANCELED.getEstadoEnum();
        if (variabilidadCapitalDto.getIdEstadoVariabilidadCapital()==EstadoEnum.OPERATIVE.getEstadoEnum()){
            operativeToCanceled=true;
        }
        if (operativeToCanceled){
            variabilidadCapitalDto.setIdEstadoVariabilidadCapital(estadoCanceled);
            return variabilidadCapitalDto;
        }else {
            try {
                return VariabilidadCapitalException.cancelarVariabilidadCapital();
            } catch (VariabilidadCapitalException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public  VariabilidadCapitalDTO checkEstadoToCrear(VariabilidadCapitalDTO variabilidadCapitalDto)  {

        boolean igualdad=false;

        if (variabilidadCapitalDto.getIdEstadoVariabilidadCapital() == EstadoEnum.DRAFT.getEstadoEnum()) {
            igualdad=true;
        }
        if (igualdad) {
            return variabilidadCapitalDto;
        }else {
            try {
                VariabilidadCapitalException.crearVariabilidadCapital();
            } catch (VariabilidadCapitalException e) {
                throw new RuntimeException(e);
            }
        }
        return variabilidadCapitalDto;
    }

    public String checkEstadoToBorrar(String cod){

        boolean igualdad=false;

        var variabilidadCapitalDto=variabilidadCapitalService.obtenerVariabilidadCapital(cod).getIdEstadoVariabilidadCapital();
        int estadoDraft=EstadoEnum.DRAFT.getEstadoEnum();
        if (variabilidadCapitalDto==estadoDraft){
            igualdad=true;
        }
        if (igualdad){
            return cod;
        }else {
            try {
                VariabilidadCapitalException.borrarVariabilidadCapital();
            }catch (VariabilidadCapitalException e){
                throw new RuntimeException(e);
            }
        }
        return cod;
    }
}
