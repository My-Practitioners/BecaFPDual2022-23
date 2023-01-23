package org.drdel.beca.prjfinal.micro.gestoras.model.service;

import org.drdel.beca.prjfinal.micro.gestoras.model.dtomapper.PoliticaInversionDTOMapper;
import org.drdel.beca.prjfinal.micro.gestoras.model.dao.IPoliticaInversionDAO;
import org.drdel.beca.prjfinal.micro.gestoras.model.domain.PoliticaInversionDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.rules.EstadoEnum;
import org.drdel.beca.prjfinal.micro.gestoras.model.rules.PoliticaInversionRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PoliticaInversionServiceImpl implements IPoliticaInversionService{

    @Autowired
    IPoliticaInversionDAO politicaInversionDAO;

    @Autowired
    PoliticaInversionRules politicaInversionRules;

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
    public List<PoliticaInversionDTO> obtenerPoliticaInversionPorDescripcion(String descripcion) {
        var listaPolitica=politicaInversionDAO.findByDescripcion(descripcion);
        return PoliticaInversionDTOMapper.transformEntityListToDTOList(listaPolitica);
    }

    @Override
    public String crearPoliticaInversion(PoliticaInversionDTO politicaInversionDTO) {
        politicaInversionRules.checkCrearPoliticaInversion(politicaInversionDTO, EstadoEnum.DRAFT);
        politicaInversionDAO.save(PoliticaInversionDTOMapper.transformDTOToEntity(politicaInversionDTO));
        return politicaInversionDTO.getCodPinversion();
    }

    @Override
    public String borrarPoliticaInversion(String cod) {
        politicaInversionRules.checkBorrarPoliticaInversion(cod);
        var politicaInversionEntity= politicaInversionDAO.findById(cod).orElse(null);
        politicaInversionDAO.deleteById(cod);
        return Objects.requireNonNull(politicaInversionEntity).getCodPinversion();
    }

    @Override
    public String actualizarPoliticaInversion(PoliticaInversionDTO politicaInversionDTO) {
        politicaInversionDAO.save(PoliticaInversionDTOMapper.transformDTOToEntity(politicaInversionDTO));
        return politicaInversionDTO.getCodPinversion();
    }

    @Override
    public String activarPoliticaInversion(PoliticaInversionDTO politicaInversionDTO) {
        politicaInversionRules.activarPoliticaInversion(politicaInversionDTO);
        politicaInversionDAO.save(PoliticaInversionDTOMapper.transformDTOToEntity(politicaInversionDTO));
        return politicaInversionDTO.getCodPinversion();
    }

    @Override
    public String cancelarPoliticaInversion(PoliticaInversionDTO politicaInversionDTO) {
        politicaInversionRules.cancelarPoliticaInversion(politicaInversionDTO);
        politicaInversionDAO.save(PoliticaInversionDTOMapper.transformDTOToEntity(politicaInversionDTO));
        return politicaInversionDTO.getCodPinversion();
    }

    @Override
    public String suspenderPoliticaInversion(PoliticaInversionDTO politicaInversionDTO) {
        politicaInversionRules.suspenderPoliticaInversion(politicaInversionDTO);
        politicaInversionDAO.save(PoliticaInversionDTOMapper.transformDTOToEntity(politicaInversionDTO));
        return politicaInversionDTO.getCodPinversion();
    }

}

