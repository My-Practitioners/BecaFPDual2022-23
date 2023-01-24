package org.drdel.beca.prjfinal.micro.gestoras.model.service;

import org.drdel.beca.prjfinal.micro.gestoras.model.dtomapper.FondoInversionDTOMapper;
import org.drdel.beca.prjfinal.micro.gestoras.model.dao.IFondoInversionDAO;
import org.drdel.beca.prjfinal.micro.gestoras.model.domain.FondoInversionDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.rules.EstadoEnum;
import org.drdel.beca.prjfinal.micro.gestoras.model.rules.FondoInversionRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FondoInversionServiceImpl implements IFondoInversionService{

    @Autowired
    IFondoInversionDAO fondoInversionDAO;

    @Autowired
    FondoInversionRules fondoInversionRules;

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
        fondoInversionRules.checkCrearFondoInversion(fondoInversionDTO, EstadoEnum.DRAFT);
        fondoInversionDAO.save(FondoInversionDTOMapper.transformDTOToEntity(fondoInversionDTO));
        return fondoInversionDTO.getCodIsin();
    }

    @Override
    public String borrarFondoInversion(String cod) {
        fondoInversionRules.checkBorrarFondoInversion(cod);
        var fondoInversionEntity = fondoInversionDAO.findById(cod).orElse(null);
        fondoInversionDAO.deleteById(cod);
        return Objects.requireNonNull(fondoInversionEntity).getCodIsin();
    }

    @Override
    public String actualizarFondoInversion(FondoInversionDTO fondoInversionDTO) {
        fondoInversionDAO.save(FondoInversionDTOMapper.transformDTOToEntity(fondoInversionDTO));
        return fondoInversionDTO.getCodIsin();
    }

    @Override
    public String activarFondoInversion(FondoInversionDTO fondoInversionDTO) {
        fondoInversionRules.activarFondoInversion(fondoInversionDTO);
        fondoInversionDAO.save(FondoInversionDTOMapper.transformDTOToEntity(fondoInversionDTO));
        return fondoInversionDTO.getCodIsin();
    }

    @Override
    public String cancelarFondoInversion(FondoInversionDTO fondoInversionDTO) {
        fondoInversionRules.cancelarFondoInversion(fondoInversionDTO);
        fondoInversionDAO.save(FondoInversionDTOMapper.transformDTOToEntity(fondoInversionDTO));
        return fondoInversionDTO.getCodIsin();
    }

    @Override
    public String suspenderFondoInversion(FondoInversionDTO fondoInversionDTO) {
        fondoInversionRules.suspenderFondoInversion(fondoInversionDTO);
        fondoInversionDAO.save(FondoInversionDTOMapper.transformDTOToEntity(fondoInversionDTO));
        return fondoInversionDTO.getCodIsin();
    }

}
