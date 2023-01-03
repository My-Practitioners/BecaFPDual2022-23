package org.drdel.beca.prjfinal.model.service;

import org.drdel.beca.prjfinal.model.dao.IFondoInversionDAO;
import org.drdel.beca.prjfinal.model.domain.FondoInversionDTO;
import org.drdel.beca.prjfinal.model.domain.PoliticaInversionDTO;
import org.drdel.beca.prjfinal.model.dtomapper.FondoInversionDTOMapper;
import org.drdel.beca.prjfinal.model.dtomapper.PoliticaInversionDTOMapper;
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
    public String crearFondoInversion(FondoInversionDTO fondoInversion) {
        var nuevoFondoInversion = fondoInversionDAO.save(FondoInversionDTOMapper.transformDTOToEntity(fondoInversion));
        return nuevoFondoInversion.getCodIsin();
    }

    @Override
    public List<FondoInversionDTO> obtenerFondoInversionPorNombre(String nombre) {
        var listaFondo=fondoInversionDAO.findByNombre(nombre);
        return FondoInversionDTOMapper.transformEntityListToDTOList(listaFondo);
    }
}
