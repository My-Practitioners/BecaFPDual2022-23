package org.drdel.beca.prjfinal.model.service;

import org.drdel.beca.prjfinal.model.dao.IFondoInversionDAO;
import org.drdel.beca.prjfinal.model.domain.FondoInversionDTO;
import org.drdel.beca.prjfinal.model.dtomapper.FondoInversionDTOMapper;
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
        var fondoGuardado = fondoInversionDAO.save(FondoInversionDTOMapper.transformDTOToEntity(fondoInversionDTO));
        return fondoGuardado.getCodIsin();
    }
}
