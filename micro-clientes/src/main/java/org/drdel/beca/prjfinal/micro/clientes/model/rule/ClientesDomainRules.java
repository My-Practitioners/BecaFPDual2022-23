package org.drdel.beca.prjfinal.micro.clientes.model.rule;

import org.drdel.beca.prjfinal.micro.clientes.model.domain.ClienteDTO;
import org.drdel.beca.prjfinal.micro.clientes.model.exception.ClienteException;
import org.springframework.stereotype.Controller;

@Controller
public class ClientesDomainRules {

    public ClienteDTO checkClientesBR0001EstadoAActivar(ClienteDTO clienteDto) throws ClienteException{
        if (EstadosRules.checkStatus(clienteDto.getIdEstadoCliente(), ClienteEstadoEnum.OPERATIVE.getEstadoEnum())) {
            clienteDto.setIdEstadoCliente(ClienteEstadoEnum.OPERATIVE.getEstadoEnum());
            return clienteDto;
        } else {
            throw new ClienteException(String.format(ClientesDomainMessages.MSG_CLIENTES0001_CAMBIAR_ESTADO_ACTIVAR_NO,clienteDto.getIdEstadoCliente()));
        }
    }

    public ClienteDTO checkClientesBR0002EstadoASuspender(ClienteDTO clienteDto) throws ClienteException{
        if (EstadosRules.checkStatus(clienteDto.getIdEstadoCliente(), ClienteEstadoEnum.SUSPENDED.getEstadoEnum())) {
            clienteDto.setIdEstadoCliente(ClienteEstadoEnum.SUSPENDED.getEstadoEnum());
            return clienteDto;
        } else {
            throw new ClienteException(String.format(ClientesDomainMessages.MSG_CLIENTES0002_CAMBIAR_ESTADO_SUSPENDER_NO,clienteDto.getIdEstadoCliente()));
        }
    }

    public ClienteDTO checkClientesBR0003EstadoACancelar(ClienteDTO clienteDto) throws ClienteException{
        if (EstadosRules.checkStatus(clienteDto.getIdEstadoCliente(), ClienteEstadoEnum.CANCELED.getEstadoEnum())) {
            clienteDto.setIdEstadoCliente(ClienteEstadoEnum.CANCELED.getEstadoEnum());
            return clienteDto;
        } else {
            throw new ClienteException(String.format(ClientesDomainMessages.MSG_CLIENTES0003_CAMBIAR_ESTADO_CANCELAR_NO,clienteDto.getIdEstadoCliente()));
        }
    }

    public ClienteDTO checkClientesBR0004EstadoACrear(ClienteDTO clienteDto) throws ClienteException{
        if (!ClienteEstadoEnum.DRAFT.getEstadoEnum().equals(clienteDto.getIdEstadoCliente())) {
            throw new ClienteException(String.format(ClientesDomainMessages.MSG_CLIENTES0004_ESTADO_CREACION_DRAFT,clienteDto.getIdEstadoCliente()));
        }
        return clienteDto;
    }

    public ClienteDTO checkClientesBR0005BorrarCliente(ClienteDTO clienteDto) throws ClienteException{
        if (!ClienteEstadoEnum.DRAFT.getEstadoEnum().equals(clienteDto.getIdEstadoCliente())) {
            throw new ClienteException(String.format(ClientesDomainMessages.MSG_CLIENTES0005_ESTADO_BORRAR_DRAFT,clienteDto.getIdEstadoCliente()));
        }
        return clienteDto;
    }

}
