package org.drdel.beca.prjfinal.micro.operaciones.model.dtomapper;

import org.drdel.beca.prjfinal.micro.operaciones.model.domain.OperacionContratacionDTO;
import org.drdel.beca.prjfinal.micro.operaciones.model.entity.OperacionContratacion;

import java.util.ArrayList;
import java.util.List;

public class OperacionContratacionDTOMapper {

    private OperacionContratacionDTOMapper(){}

    public static OperacionContratacionDTO transformEntityToDTO(OperacionContratacion entity){
        return new OperacionContratacionDTO(entity.getIdOperacionContratacion(),entity.getDescripcion());
    }

    public static List<OperacionContratacionDTO> transformEntityToDTOList(Iterable<OperacionContratacion> entityIterable){
        List<OperacionContratacionDTO> dtoList=new ArrayList<>();
        entityIterable.forEach(pr -> dtoList.add(transformEntityToDTO(pr)));
        return dtoList;
    }

    public static OperacionContratacion transformDTOToEntity(OperacionContratacionDTO dto){
        var entity=new OperacionContratacion();
        entity.setIdOperacionContratacion(dto.getIdOperacionContratacion());
        entity.setDescripcion(dto.getDescripcion());
        return entity;
    }
}
