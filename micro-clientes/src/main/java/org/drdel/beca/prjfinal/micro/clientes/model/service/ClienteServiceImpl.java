package org.drdel.beca.prjfinal.micro.clientes.model.service;

import org.drdel.beca.prjfinal.micro.clientes.model.dtomapper.ClienteDTOMapper;
import org.drdel.beca.prjfinal.micro.clientes.model.dao.IClienteDao;
import org.drdel.beca.prjfinal.micro.clientes.model.domain.ClienteDTO;
import org.drdel.beca.prjfinal.micro.clientes.model.exception.ClienteException;
import org.drdel.beca.prjfinal.micro.clientes.model.rule.ClientesDomainRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class ClienteServiceImpl implements IClienteService{
    @Autowired
    IClienteDao clienteDao;

    @Autowired
    ClientesDomainRules clientesDomainRules;

    @Override
    public ClienteDTO obtenerCliente(Long id) {
        var clienteEntity= clienteDao.findById(id).orElse(null);
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
        clientesDomainRules.checkClientesBR0004EstadoACrear(clienteDto);
        clienteDao.save(ClienteDTOMapper.transformDTOToEntity(clienteDto));
        return clienteDto.getId();
    }

    @Override
    public Long borrarCliente(Long id) throws ClienteException {
        var dto = obtenerCliente(id);
        clientesDomainRules.checkClientesBR0005BorrarCliente(dto);
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
        clientesDomainRules.checkClientesBR0001EstadoAActivar(clienteDto);
        clienteDao.save(ClienteDTOMapper.transformDTOToEntity(clienteDto));
        return clienteDto.getId();
    }

    @Override
    public Long cancelarCliente(ClienteDTO clienteDto) throws ClienteException {
        clientesDomainRules.checkClientesBR0003EstadoACancelar(clienteDto);
        clienteDao.save(ClienteDTOMapper.transformDTOToEntity(clienteDto));
        return clienteDto.getId();
    }

    @Override
    public Long suspenderCliente(ClienteDTO clienteDto) throws ClienteException {
        clientesDomainRules.checkClientesBR0002EstadoASuspender(clienteDto);
        clienteDao.save(ClienteDTOMapper.transformDTOToEntity(clienteDto));
        return clienteDto.getId();
    }
}
