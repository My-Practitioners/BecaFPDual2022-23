package org.drdel.beca.prjfinal.micro.gestoras.model.rules;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.GestoraDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.exception.GestoraException;
import org.drdel.beca.prjfinal.micro.gestoras.model.service.GestoraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GestoraRules {
    @Autowired
    GestoraServiceImpl gestoraService;


    public GestoraDTO activarEstado(GestoraDTO gestoraDto) {

        boolean draftToActive=false;

        int estadoOperative= EstadoEnum.OPERATIVE.getEstadoEnum();
        if (gestoraDto.getIdEstadoGestora()==EstadoEnum.DRAFT.getEstadoEnum()){
            draftToActive=true;
        }
        if (draftToActive){
            gestoraDto.setIdEstadoGestora(estadoOperative);
            return gestoraDto;
        }else {
            try {
                return GestoraException.activarGestora();
            } catch (GestoraException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    public GestoraDTO suspenderEstado(GestoraDTO gestoraDto) {

        boolean operativeToSuspended=false;

        int estadoSuspended=EstadoEnum.SUSPENDED.getEstadoEnum();
        if (gestoraDto.getIdEstadoGestora()==EstadoEnum.OPERATIVE.getEstadoEnum()){
            operativeToSuspended=true;
        }
        if (operativeToSuspended){
            gestoraDto.setIdEstadoGestora(estadoSuspended);
            return gestoraDto;
        }else {
            try {
                return GestoraException.suspenderGestora();
            } catch (GestoraException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    public GestoraDTO cancelarEstado(GestoraDTO gestoraDto) {

        boolean operativeToCanceled=false;

        int estadoCanceled=EstadoEnum.CANCELED.getEstadoEnum();
        if (gestoraDto.getIdEstadoGestora()==EstadoEnum.OPERATIVE.getEstadoEnum()){
            operativeToCanceled=true;
        }
        if (operativeToCanceled){
            gestoraDto.setIdEstadoGestora(estadoCanceled);
            return gestoraDto;
        }else {
            try {
                return GestoraException.cancelarGestora();
            } catch (GestoraException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    public  GestoraDTO checkEstadoToCrear(GestoraDTO gestoraDto)  {

        boolean igualdad= gestoraDto.getIdEstadoGestora() == EstadoEnum.DRAFT.getEstadoEnum();

        if (igualdad) {
            return gestoraDto;
        }else {
            try {
                GestoraException.crearGestora();
            } catch (GestoraException e) {
                throw new IllegalArgumentException(e);
            }
        }
        return gestoraDto;
    }

    public Long checkEstadoToBorrar(Long id){

        boolean igualdad=false;

        var estadoGestoraDto=gestoraService.obtenerGestora(id).getIdEstadoGestora();
        int estadoDraft=EstadoEnum.DRAFT.getEstadoEnum();
        if (estadoGestoraDto==estadoDraft){
            igualdad=true;
        }
        if (igualdad){
            return id;
        }else {
            try {
                GestoraException.borrarGestora();
            }catch (GestoraException e){
                throw new IllegalArgumentException(e);
            }
        }
        return id;
    }
}
