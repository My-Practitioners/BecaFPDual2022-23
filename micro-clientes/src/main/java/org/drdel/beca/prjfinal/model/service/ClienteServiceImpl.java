package org.drdel.beca.prjfinal.model.service;

import org.drdel.beca.prjfinal.model.dao.IClienteDao;
import org.drdel.beca.prjfinal.model.dao.IFondoInversionDAO;
import org.drdel.beca.prjfinal.model.domain.ClienteDTO;
import org.drdel.beca.prjfinal.model.dtomapper.ClienteDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    IClienteDao clienteDao;

    /*@Autowired
    IFondoInversionDAO fondoInversionDAO;*/

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
        var clienteSalvado = clienteDao.save(ClienteDTOMapper.transformDTOToEntity(cliente));
        return clienteSalvado.getId();
    }

    /*@Override
    public ClienteDTO obtenerClienteConFondo(Long id) {

        var clienteEntity = clienteDao.findById(id).orElse(null);
        ClienteDTO clienteDto = null;

        if (clienteEntity != null) {
            clienteDto = ClienteDTOMapper.transformEntityToDTO(clienteEntity);
            var listaFondosEntity = fondoInversionDAO.findByClienteId(id);
            if (listaFondosEntity != null)
                clienteDto.setFondos(FondoInversionDTOMapper.transformEntityListToDTOList(listaFondosEntity));
        }
        return clienteDto;
    }*/

}
