package org.drdel.beca.prjfinal.micro.clientes.model.service;

import org.drdel.beca.prjfinal.micro.clientes.model.dtomapper.ClienteDTOMapper;
import org.drdel.beca.prjfinal.micro.clientes.model.dao.IClienteDao;
import org.drdel.beca.prjfinal.micro.clientes.model.domain.ClienteDTO;
import org.drdel.beca.prjfinal.micro.clientes.model.rule.ClienteEstadoEnum;
import org.drdel.beca.prjfinal.micro.clientes.model.rule.ClientesRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    IClienteDao clienteDao;

    @Autowired
    ClientesRules clientesRules;





    @Override
    public ClienteDTO obtenerCliente(Long id) {
        var clienteEntity = clienteDao.findById(id).orElse(null);
        return clienteEntity!=null ? ClienteDTOMapper.transformEntityToDTO(clienteEntity) : null;
    }

    @Override
    public List<ClienteDTO> obtenerTodosClientes() {
        return ClienteDTOMapper.transformEntityListToDTOList(clienteDao.findAll());
    }

    @Override
    public List<ClienteDTO> obtenerClientePorApellido(String apellido) {
        var listaCliente=clienteDao.findByApellido(apellido);
        return ClienteDTOMapper.transformEntityListToDTOList(listaCliente);
    }

    @Override
    public Long crearCliente(ClienteDTO cliente) {
        clientesRules.checkCrearEstado(cliente, ClienteEstadoEnum.DRAFT);
        clienteDao.save(ClienteDTOMapper.transformDTOToEntity(cliente));
        return cliente.getId();
    }

    @Override
    public Long borrarCliente(Long id) {
        var clienteEntity = clienteDao.findById(id).orElse(null);
        clienteDao.deleteById(id);
        return clienteEntity.getId();
    }

    @Override
    public Long actualizarCliente(ClienteDTO cliente) {
        clienteDao.save(ClienteDTOMapper.transformDTOToEntity(cliente));
        return cliente.getId();
    }

    @Override
    public Long activarCliente(ClienteDTO clienteDTO) {
        clientesRules.activarEstado(clienteDTO);
        clienteDao.save(ClienteDTOMapper.transformDTOToEntity(clienteDTO));
        return clienteDTO.getId();
    }

}
