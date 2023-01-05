package org.drdel.beca.prjfinal.model.service;

import org.drdel.beca.prjfinal.model.dao.IVariabilidadCapitalDao;
import org.drdel.beca.prjfinal.model.domain.VariabilidadCapitalDTO;
import org.drdel.beca.prjfinal.model.dtomapper.VariabilidadCapitalDTOMapper;
import org.drdel.beca.prjfinal.model.entity.VariabilidadCapital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VariabilidadCapitalServiceImpl implements IVariabilidadCapitalService{

    @Autowired
    IVariabilidadCapitalDao variabilidadCapitalDao;

    @Override
    public VariabilidadCapitalDTO obtenerVariabilidadCapital(String code) {
        var entity = variabilidadCapitalDao.findById(code).orElse(null);
        return entity!=null ? VariabilidadCapitalDTOMapper.transformEntityToDTO(entity) : null;
    }

    @Override
    public List<VariabilidadCapitalDTO> obtenerTodosVariabilidadCapital() {
        return VariabilidadCapitalDTOMapper.transformEntityListToDTOList(variabilidadCapitalDao.findAll());
    }

    @Override
    public List<VariabilidadCapitalDTO> obtenerVariabilidadPorDescripcion(String descripcion) {
        var listaVariabilidadCapital=variabilidadCapitalDao.findByDescripcion(descripcion);
        return VariabilidadCapitalDTOMapper.transformEntityListToDTOList(listaVariabilidadCapital);
    }

    @Override
    public VariabilidadCapital crearVariabilidadCapital(String codPInversion, String descripcion) {
        VariabilidadCapitalDTO variabilidadCapitalDTO= new VariabilidadCapitalDTO(codPInversion,descripcion);
        return variabilidadCapitalDao.save(VariabilidadCapitalDTOMapper.transformDTOToEntity(variabilidadCapitalDTO));
    }

}
