package org.drdel.beca.prjfinal.micro.clientes.model.rule;

import org.drdel.beca.prjfinal.micro.clientes.model.domain.ClienteDTO;
import org.drdel.beca.prjfinal.micro.clientes.model.exception.ClienteException;

public class ClientesRules {


    public ClienteDTO activarEstado(ClienteDTO clienteDto, ClienteEstadoEnum clienteEstadoEnum) throws ClienteException {
        clienteEstadoEnum=ClienteEstadoEnum.ACTIVAR;

        if (clienteDto.getIdEstadoCliente()==clienteEstadoEnum.getEstadoEnum()){
            return clienteDto;
        }else {
            return ClienteException.activarCliente();
        }

    }


    public ClienteDTO suspenderEstado(ClienteDTO clienteDto, ClienteEstadoEnum clienteEstadoEnum) throws ClienteException {
        clienteEstadoEnum=ClienteEstadoEnum.SUSPENDER;

        if (clienteDto.getIdEstadoCliente()==clienteEstadoEnum.getEstadoEnum()){
            return clienteDto;
        }else {
            return ClienteException.suspenderCliente();
        }

    }


    public ClienteDTO cancelarEstado(ClienteDTO clienteDto, ClienteEstadoEnum clienteEstadoEnum) throws ClienteException {
        clienteEstadoEnum=ClienteEstadoEnum.CANCELAR;

        if (clienteDto.getIdEstadoCliente()==clienteEstadoEnum.getEstadoEnum()){
            return clienteDto;
        }else {
            return ClienteException.cancelarCliente();
        }

    }



    public  ClienteDTO crearEstado(ClienteDTO clienteDto, ClienteEstadoEnum clienteEstadoEnum) throws ClienteException {
        clienteEstadoEnum=ClienteEstadoEnum.DRAFT;

        try {
            if (clienteDto.getIdEstadoCliente() == clienteEstadoEnum.getEstadoEnum()) {
                return clienteDto;
            }
        }catch (Exception e){
            ClienteException.crearCliente(e);
        }

        return clienteDto;

    }


}
