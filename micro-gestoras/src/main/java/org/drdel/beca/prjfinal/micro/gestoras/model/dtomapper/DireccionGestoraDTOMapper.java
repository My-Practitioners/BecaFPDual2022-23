package org.drdel.beca.prjfinal.micro.gestoras.model.dtomapper;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.DireccionGestoraDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.entity.DireccionGestora;

import java.util.ArrayList;
import java.util.List;

public class DireccionGestoraDTOMapper {
    private DireccionGestoraDTOMapper(){}

    public static DireccionGestoraDTO transformEntityToDTO(DireccionGestora entity){
        return new DireccionGestoraDTO(entity.getIdDireccion(),
                entity.getIdGestora(),
                entity.getDireccion());
    }

    public static List<DireccionGestoraDTO> transformEntityListToDTOList(Iterable<DireccionGestora> entityIterable){
        List<DireccionGestoraDTO> dtoList=new ArrayList<>();
        entityIterable.forEach(pr ->
                dtoList.add(transformEntityToDTO(pr)));
        return dtoList;
    }

    public static DireccionGestora transformDTOToEntity(DireccionGestoraDTO dto){
        var entity= new DireccionGestora();
        entity.setIdDireccion(dto.getIdDireccion());
        entity.setIdGestora(dto.getIdGestora());
        entity.setDireccion(dto.getDireccion());
        entity.setAudCreaDate(dto.getAudCreaDate());
        entity.setAudModDate(dto.getAudModDate());
        entity.setAudCreaProc(dto.getAudCreaProc());
        entity.setAudModProc(dto.getAudModProc());
        entity.setAudCreaUsu(dto.getAudCreaUsu());
        entity.setAudModUsu(dto.getAudModUsu());
        return entity;
    }
}
