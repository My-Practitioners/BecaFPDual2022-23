package org.drdel.beca.prjfinal.micro.gestoras.model.service;

import org.drdel.beca.prjfinal.micro.gestoras.model.dao.IVariabilidadCapitalDao;
import org.drdel.beca.prjfinal.micro.gestoras.model.domain.VariabilidadCapitalDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.dtomapper.VariabilidadCapitalDTOMapper;
import org.drdel.beca.prjfinal.micro.gestoras.model.rules.VariabilidadCapitalRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VariabilidadCapitalServiceImpl implements IVariabilidadCapitalService{

    @Autowired
    IVariabilidadCapitalDao variabilidadCapitalDao;
    @Autowired
    VariabilidadCapitalRules variabilidadCapitalRules;

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
    public String crearVariabilidadCapital(VariabilidadCapitalDTO variabilidadCapitalDto) {
        variabilidadCapitalRules.checkEstadoToCrear(variabilidadCapitalDto);
        var variabilidadCapGuardada=variabilidadCapitalDao.save(VariabilidadCapitalDTOMapper.transformDTOToEntity(variabilidadCapitalDto));
        return variabilidadCapGuardada.getCodVariabilidadCapital();
    }

    @Override
    public String borrarVariabilidadCapital(String codVariabilidadCapital) {
        variabilidadCapitalRules.checkEstadoToBorrar(codVariabilidadCapital);
        variabilidadCapitalDao.deleteById(codVariabilidadCapital);
        return codVariabilidadCapital;
    }

    @Override
    public String actualizarVariabilidadCapital(VariabilidadCapitalDTO variabilidadCapitalDto) {
        variabilidadCapitalDao.save(VariabilidadCapitalDTOMapper.transformDTOToEntity(variabilidadCapitalDto));
        return variabilidadCapitalDto.getCodVariabilidadCapital();
    }

    @Override
    public String activarVariabilidadCapital(VariabilidadCapitalDTO variabilidadCapitalDto) {
        variabilidadCapitalRules.activarEstado(variabilidadCapitalDto);
        variabilidadCapitalDao.save(VariabilidadCapitalDTOMapper.transformDTOToEntity(variabilidadCapitalDto));
        return variabilidadCapitalDto.getCodVariabilidadCapital();
    }

    @Override
    public String suspenderVariabilidadCapital(VariabilidadCapitalDTO variabilidadCapitalDto) {
        variabilidadCapitalRules.suspenderEstado(variabilidadCapitalDto);
        variabilidadCapitalDao.save(VariabilidadCapitalDTOMapper.transformDTOToEntity(variabilidadCapitalDto));
        return variabilidadCapitalDto.getCodVariabilidadCapital();
    }

    @Override
    public String cancelarVariabilidadCapital(VariabilidadCapitalDTO variabilidadCapitalDto) {
        variabilidadCapitalRules.cancelarEstado(variabilidadCapitalDto);
        variabilidadCapitalDao.save(VariabilidadCapitalDTOMapper.transformDTOToEntity(variabilidadCapitalDto));
        return variabilidadCapitalDto.getCodVariabilidadCapital();
    }


}
