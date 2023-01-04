package org.drdel.beca.prjfinal.model.service;

import org.drdel.beca.prjfinal.model.dao.IPoliticaInversionDAO;
import org.drdel.beca.prjfinal.model.domain.GestoraDTO;
import org.drdel.beca.prjfinal.model.domain.PoliticaInversionDTO;
import org.drdel.beca.prjfinal.model.dtomapper.GestoraDTOMapper;
import org.drdel.beca.prjfinal.model.dtomapper.PoliticaInversionDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliticaInversionServiceImpl implements IPoliticaInversionService{

    @Autowired
    IPoliticaInversionDAO politicaInversionDAO;

    @Override
    public PoliticaInversionDTO obtenerPoliticaInversion(String code) {
        var entity = politicaInversionDAO.findById(code).orElse(null);
        return entity!=null ? PoliticaInversionDTOMapper.transformEntityToDTO(entity) : null;
    }

    @Override
    public List<PoliticaInversionDTO> obtenerTodosPoliticaInversion() {
        return PoliticaInversionDTOMapper.transformEntityListToDTOList(politicaInversionDAO.findAll());
    }

    @Override
    public String crearPoliticaInversion(PoliticaInversionDTO politicaInversionDTO) {
        var politicaGuardada = politicaInversionDAO.save(PoliticaInversionDTOMapper.transformDTOToEntity(politicaInversionDTO));
        return politicaGuardada.getCodPinversion();
    }

    @Override
    public List<PoliticaInversionDTO> obtenerPoliticaInversionPorDescripcion(String descripcion) {
        var listaPolitica=politicaInversionDAO.findByDescripcion(descripcion);
        return PoliticaInversionDTOMapper.transformEntityListToDTOList(listaPolitica);
    }
}
