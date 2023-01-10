package org.drdel.beca.prjfinal.micro.clientes.model.service;

import org.drdel.beca.prjfinal.micro.clientes.model.dtomapper.FondoInversionDTOMapper;
import org.drdel.beca.prjfinal.micro.clientes.model.dao.IFondoInversionDAO;
import org.drdel.beca.prjfinal.micro.clientes.model.domain.FondoInversionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FondoInversionServiceImpl implements IFondoInversionService{

    @Autowired
    IFondoInversionDAO fondoInversionDAO;

    @Override
    public FondoInversionDTO obtenerFondoInversion(String code) {
        var entity = fondoInversionDAO.findById(code).orElse(null);
        return entity!=null ? FondoInversionDTOMapper.transformEntityToDTO(entity) : null;
    }

    @Override
    public List<FondoInversionDTO> obtenerTodosFondoInversion() {
        return FondoInversionDTOMapper.transformEntityListToDTOList(fondoInversionDAO.findAll());
    }

    @Override
    public List<FondoInversionDTO> obtenerFondoInversionPorNombre(String nombre) {
        var listaFondo=fondoInversionDAO.findByNombreFondo(nombre);
        return FondoInversionDTOMapper.transformEntityListToDTOList(listaFondo);
    }

    @Override
    public String crearFondoInversion(FondoInversionDTO fondoInversionDTO) {
        FondoInversionDTO fondoInversionDTO1 = new FondoInversionDTO("ES111111111", "ES22222222", "JDUIBNCS88NHFDSI", "FONDOX", 6L, 8L, "arsg", "capv", "no", "SICA90");
        var fondoGuardado = fondoInversionDAO.save(FondoInversionDTOMapper.transformDTOToEntity(fondoInversionDTO1));
        return fondoGuardado.getCodIsin();
    }



}
