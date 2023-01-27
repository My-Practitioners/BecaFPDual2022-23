package org.drdel.beca.prjfinal.micro.operaciones.model.dtomapper;

import org.drdel.beca.prjfinal.micro.operaciones.model.domain.EstadoContratacionDTO;
import org.drdel.beca.prjfinal.micro.operaciones.model.entity.EstadoContratacion;

import java.util.ArrayList;
import java.util.List;

public class EstadoContratacionDTOMapper {

    private EstadoContratacionDTOMapper(){}

    public static EstadoContratacionDTO transformEntityToDTO(EstadoContratacion entity){
        return new EstadoContratacionDTO(entity.getIdEstadoContratacion(),
                entity.getDescripcion());
    }

    public static List<EstadoContratacionDTO> transformEntityListToDTOList(Iterable<EstadoContratacion> entityIterable){
        List<EstadoContratacionDTO> dtoList = new ArrayList<>();
        entityIterable.forEach(pr ->
                dtoList.add(transformEntityToDTO(pr)));
        return dtoList;
    }

    public static EstadoContratacion transformDTOToEntity(EstadoContratacionDTO dto){
        var entity = new EstadoContratacion();
        entity.setIdEstadoContratacion(dto.getIdEstadoContratacion());
        entity.setDescripcion((dto.getDescripcion()));
        return entity;
    }
}
