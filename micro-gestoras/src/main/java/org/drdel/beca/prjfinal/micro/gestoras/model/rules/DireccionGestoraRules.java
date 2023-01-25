package org.drdel.beca.prjfinal.micro.gestoras.model.rules;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.DireccionGestoraDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.exception.DireccionGestoraException;
import org.drdel.beca.prjfinal.micro.gestoras.model.service.DireccionGestoraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DireccionGestoraRules {

    @Autowired
    DireccionGestoraServiceImpl direccionGestoraService;


    public DireccionGestoraDTO activarEstado(DireccionGestoraDTO direccionGestoraDto) {

        boolean draftToActive=false;

        int estadoOperative= EstadoEnum.OPERATIVE.getEstadoEnum();
        if (direccionGestoraDto.getIdEstadoDireccionGestora()==EstadoEnum.DRAFT.getEstadoEnum()){
            draftToActive=true;
        }
        if (draftToActive){
            direccionGestoraDto.setIdEstadoDireccionGestora(estadoOperative);
            return direccionGestoraDto;
        }else {
            try {
                return DireccionGestoraException.activarDireccionGestora();
            } catch (DireccionGestoraException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    public DireccionGestoraDTO suspenderEstado(DireccionGestoraDTO direccionGestoraDto) {

        boolean operativeToSuspended=false;

        int estadoSuspended=EstadoEnum.SUSPENDED.getEstadoEnum();
        if (direccionGestoraDto.getIdEstadoDireccionGestora()==EstadoEnum.OPERATIVE.getEstadoEnum()){
            operativeToSuspended=true;
        }
        if (operativeToSuspended){
            direccionGestoraDto.setIdEstadoDireccionGestora(estadoSuspended);
            return direccionGestoraDto;
        }else {
            try {
                return DireccionGestoraException.suspenderDireccionGestora();
            } catch (DireccionGestoraException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    public DireccionGestoraDTO cancelarEstado(DireccionGestoraDTO direccionGestoraDto) {

        boolean operativeToCanceled=false;

        int estadoCanceled=EstadoEnum.CANCELED.getEstadoEnum();
        if (direccionGestoraDto.getIdEstadoDireccionGestora()==EstadoEnum.OPERATIVE.getEstadoEnum()){
            operativeToCanceled=true;
        }
        if (operativeToCanceled){
            direccionGestoraDto.setIdEstadoDireccionGestora(estadoCanceled);
            return direccionGestoraDto;
        }else {
            try {
                return DireccionGestoraException.cancelarDireccionGestora();
            } catch (DireccionGestoraException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    public  DireccionGestoraDTO checkEstadoToCrear(DireccionGestoraDTO direccionGestoraDto)  {

        boolean igualdad= direccionGestoraDto.getIdEstadoDireccionGestora() == EstadoEnum.DRAFT.getEstadoEnum();

        if (igualdad) {
            return direccionGestoraDto;
        }else {
            try {
                DireccionGestoraException.crearDireccionGestora();
            } catch (DireccionGestoraException e) {
                throw new IllegalArgumentException(e);
            }
        }
        return direccionGestoraDto;
    }

    public Long checkEstadoToBorrar(Long id){

        boolean igualdad=false;

        var estadoDireccionGestoraDto=direccionGestoraService.obtenerDireccionGestora(id).getIdEstadoDireccionGestora();
        int estadoDraft=EstadoEnum.DRAFT.getEstadoEnum();
        if (estadoDireccionGestoraDto==estadoDraft){
            igualdad=true;
        }
        if (igualdad){
            return id;
        }else {
            try {
                DireccionGestoraException.borrarDireccionGestora();
            }catch (DireccionGestoraException e){
                throw new IllegalArgumentException(e);
            }
        }
        return id;
    }

}
