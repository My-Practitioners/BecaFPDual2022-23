package org.drdel.beca.prjfinal.micro.gestoras.model.service;

import org.drdel.beca.prjfinal.micro.gestoras.model.entity.VariabilidadCapital;
import org.drdel.beca.prjfinal.micro.gestoras.model.dao.IVariabilidadCapitalDao;
import org.drdel.beca.prjfinal.micro.gestoras.model.domain.VariabilidadCapitalDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.dtomapper.VariabilidadCapitalDTOMapper;
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
