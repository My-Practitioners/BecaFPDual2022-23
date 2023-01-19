package org.drdel.beca.prjfinal.micro.clientes.model.rule;

import org.drdel.beca.prjfinal.micro.clientes.model.domain.ClienteDTO;
import org.drdel.beca.prjfinal.micro.clientes.model.exception.ClienteException;
import org.drdel.beca.prjfinal.micro.clientes.model.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ClientesRules {
    @Autowired
    ClienteServiceImpl clienteService;


    public ClienteDTO activarEstado(ClienteDTO clienteDto)  {
        boolean draftToActive=false;
        int activar=ClienteEstadoEnum.OPERATIVE.getEstadoEnum();


        if (clienteDto.getIdEstadoCliente()==ClienteEstadoEnum.DRAFT.getEstadoEnum()){
            draftToActive=true;
        }
        if (draftToActive){
            clienteDto.setIdEstadoCliente(activar);
            return clienteDto;
        }else {
            try {
                return ClienteException.activarCliente();
            } catch (ClienteException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public ClienteDTO suspenderEstado(ClienteDTO clienteDto) {
        boolean operativeToSuspended=false;
        int suspender=ClienteEstadoEnum.SUSPENDED.getEstadoEnum();


        if (clienteDto.getIdEstadoCliente()==ClienteEstadoEnum.OPERATIVE.getEstadoEnum()){
            operativeToSuspended=true;
        }
        if (operativeToSuspended){
            clienteDto.setIdEstadoCliente(suspender);
            return clienteDto;
        }else {
            try {
                return ClienteException.cancelarCliente();
            } catch (ClienteException e) {
                throw new RuntimeException(e);
            }
        }

    }


    public ClienteDTO cancelarEstado(ClienteDTO clienteDto) {
        boolean operativeToCanceled=false;
        int cancelar=ClienteEstadoEnum.CANCELED.getEstadoEnum();


        if (clienteDto.getIdEstadoCliente()==ClienteEstadoEnum.OPERATIVE.getEstadoEnum()){
            operativeToCanceled=true;
        }
        if (operativeToCanceled){
            clienteDto.setIdEstadoCliente(cancelar);
            return clienteDto;
        }else {
            try {
                return ClienteException.cancelarCliente();
            } catch (ClienteException e) {
                throw new RuntimeException(e);
            }
        }

    }



    public  ClienteDTO checkCrearEstado(ClienteDTO clienteDto, ClienteEstadoEnum clienteEstadoEnum)  {

        boolean igualdad=false;

            if (clienteDto.getIdEstadoCliente() == clienteEstadoEnum.getEstadoEnum()) {
                igualdad=true;
            }
            if (igualdad) {
                return clienteDto;
            }else {
                try {
                    ClienteException.crearCliente();
                } catch (ClienteException e) {
                    throw new RuntimeException(e);
                }
            }


        return clienteDto;
    }

    public Long checkBorrarEstado(Long id){

        boolean igualdad=false;

        var clienteDto=clienteService.obtenerCliente(id).getIdEstadoCliente();
        int estadoDraft=ClienteEstadoEnum.DRAFT.getEstadoEnum();
        if (clienteDto==estadoDraft){
            igualdad=true;
        }
        if (igualdad){
            return id;
        }else {
            try {
                ClienteException.borrarCliente();
            }catch (ClienteException e){
                throw new RuntimeException(e);
            }
        }
        return id;
    }


}
