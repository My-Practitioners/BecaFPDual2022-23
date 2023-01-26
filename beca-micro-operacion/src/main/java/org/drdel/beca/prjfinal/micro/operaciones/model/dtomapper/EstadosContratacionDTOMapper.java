package org.drdel.beca.prjfinal.micro.operaciones.model.dtomapper;

import org.drdel.beca.prjfinal.micro.operaciones.model.domain.EstadosContratacionDTO;
import org.drdel.beca.prjfinal.micro.operaciones.model.entity.EstadosContratacion;

import java.util.ArrayList;
import java.util.List;

public class EstadosContratacionDTOMapper {

    private EstadosContratacionDTOMapper(){}

    public static EstadosContratacionDTO transformEntityToDTO(EstadosContratacion entity){
        return new EstadosContratacionDTO(entity.getIdEstadosContratacion(),
                entity.getDescripcion());
    }

    public static List<EstadosContratacionDTO> transformEntityListToDTOList(Iterable<EstadosContratacion> entityIterable){
        List<EstadosContratacionDTO> dtoList = new ArrayList<>();
        entityIterable.forEach(pr ->
                dtoList.add(transformEntityToDTO(pr)));
        return dtoList;
    }

    public static EstadosContratacion transformDTOToEntity(EstadosContratacionDTO dto){
        var entity = new EstadosContratacion();
        entity.setIdEstadosContratacion(dto.getIdEstadosContratacion());
        entity.setDescripcion((dto.getDescripcion()));
        return entity;
    }
}
