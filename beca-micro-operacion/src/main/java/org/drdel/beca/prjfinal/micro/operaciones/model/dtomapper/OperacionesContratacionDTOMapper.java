package org.drdel.beca.prjfinal.micro.operaciones.model.dtomapper;

import org.drdel.beca.prjfinal.micro.operaciones.model.domain.EstadosContratacionDTO;
import org.drdel.beca.prjfinal.micro.operaciones.model.domain.OperacionesContratacionDTO;
import org.drdel.beca.prjfinal.micro.operaciones.model.entity.OperacionesContratacion;

import java.util.ArrayList;
import java.util.List;

public class OperacionesContratacionDTOMapper {

    private OperacionesContratacionDTOMapper(){}

    public static OperacionesContratacionDTO transformEntityToDTO(OperacionesContratacion entity){
        return new OperacionesContratacionDTO(entity.getCodOperacionesContratacion(),entity.getDescripcion());
    }

    public static List<OperacionesContratacionDTO> transformEntityToDTOList(Iterable<OperacionesContratacion> entityIterable){
        List<OperacionesContratacionDTO> dtoList=new ArrayList<>();
        entityIterable.forEach(pr -> dtoList.add(transformEntityToDTO(pr)));
        return dtoList;
    }

    public static OperacionesContratacion transformDTOToEntity(OperacionesContratacionDTO dto){
        var entity=new OperacionesContratacion();
        entity.setCodOperacionesContratacion(dto.getCodOperacionesContratacion());
        entity.setDescripcion(dto.getDescripcion());
        return entity;
    }
}
