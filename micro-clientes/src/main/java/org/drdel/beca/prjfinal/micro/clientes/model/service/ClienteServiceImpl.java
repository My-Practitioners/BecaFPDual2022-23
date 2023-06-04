package org.drdel.beca.prjfinal.micro.clientes.model.service;

import org.drdel.beca.prjfinal.micro.clientes.model.dtomapper.ClienteDTOMapper;
import org.drdel.beca.prjfinal.micro.clientes.model.dao.IClienteDao;
import org.drdel.beca.prjfinal.micro.clientes.model.domain.ClienteDTO;
import org.drdel.beca.prjfinal.micro.clientes.model.exception.ClienteException;
import org.drdel.beca.prjfinal.micro.clientes.model.rule.ClientesDomainMessages;
import org.drdel.beca.prjfinal.micro.clientes.model.rule.ClientesDomainRules;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class ClienteServiceImpl implements IClienteService{

    private final IClienteDao clienteDao;

    public ClienteServiceImpl(IClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    @Override
    public ClienteDTO obtenerCliente(Long id) {
        var clienteEntity = clienteDao.findById(id).orElse(null);
        return clienteEntity!=null ? ClienteDTOMapper.transformEntityToDTO(clienteEntity) : null;
    }

    @Override
    public List<ClienteDTO> obtenerTodosClientes() {
        return ClienteDTOMapper.transformEntityListToDTOList( clienteDao.findAll());
    }

    @Override
    public List<ClienteDTO> obtenerClientePorApellido(String apellido) {
        var listaCliente= clienteDao.findByApellido(apellido);
        return ClienteDTOMapper.transformEntityListToDTOList(listaCliente);
    }

    @Override
    public Long crearCliente(ClienteDTO clienteDto) throws ClienteException {
        ClientesDomainRules.checkClientesBR0004EstadoACrear(clienteDto);
        clienteDao.save(ClienteDTOMapper.transformDTOToEntity(clienteDto));
        return clienteDto.getId();
    }

    @Override
    public Long borrarCliente(Long id) throws ClienteException {
        var dto = obtenerCliente(id);
        ClientesDomainRules.checkClientesBR0005BorrarCliente(dto);
        var clienteEntity= clienteDao.findById(id).orElse(null);
        clienteDao.deleteById(id);
        return Objects.requireNonNull(clienteEntity).getId();
    }

    @Override
    public Long actualizarCliente(ClienteDTO clienteDto) {
        clienteDao.save(ClienteDTOMapper.transformDTOToEntity(clienteDto));
        return clienteDto.getId();
    }

    @Override
    public Long activarCliente(ClienteDTO clienteDto) throws ClienteException {
        ClientesDomainRules.checkClientesBR0001EstadoAActivar(clienteDto);
        clienteDao.save(ClienteDTOMapper.transformDTOToEntity(clienteDto));
        return clienteDto.getId();
    }

    @Override
    public Long cancelarCliente(ClienteDTO clienteDto) throws ClienteException {
        ClientesDomainRules.checkClientesBR0003EstadoACancelar(clienteDto);
        clienteDao.save(ClienteDTOMapper.transformDTOToEntity(clienteDto));
        return clienteDto.getId();
    }

    @Override
    public Long suspenderCliente(ClienteDTO clienteDto) throws ClienteException {
        ClientesDomainRules.checkClientesBR0002EstadoASuspender(clienteDto);
        clienteDao.save(ClienteDTOMapper.transformDTOToEntity(clienteDto));
        return clienteDto.getId();
    }
    public Long cambiarEstadoCliente(ClienteDTO clienteDto, Integer nuevoEstado) throws ClienteException{

        switch (nuevoEstado) {
            //ClienteEstadoEnum.OPERATIVE -> ACTIVAR
            case 1:
                ClientesDomainRules.checkClientesBR0001EstadoAActivar(clienteDto);
                break;
            //ClienteEstadoEnum.SUSPENDED -> SUSPENDER
            case 2:
                ClientesDomainRules.checkClientesBR0002EstadoASuspender(clienteDto);
                break;
            //ClienteEstadoEnum.CANCELLED -> CANCELAR
            case 3:
                ClientesDomainRules.checkClientesBR0003EstadoACancelar(clienteDto);
                break;
            default :
                throw new ClienteException(String.format(ClientesDomainMessages.MSG_CLIENTES0006_ESTADO_INVALIDO, nuevoEstado));
        }

        clienteDao.save(ClienteDTOMapper.transformDTOToEntity(clienteDto));
        return clienteDto.getId();
    }

}
