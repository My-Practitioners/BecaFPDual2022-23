package org.drdel.beca.prjfinal.micro.gestoras.model.dtomapper;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.DireccionGestoraDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.entity.DireccionGestora;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DireccionGestoraDTOMapper {
    private DireccionGestoraDTOMapper(){}

    public static DireccionGestoraDTO transformEntityToDTO(DireccionGestora entity){
        DireccionGestoraDTO.DireccionGestoraDTOBuilder direccionGestoraDTOBuilder=new DireccionGestoraDTO.DireccionGestoraDTOBuilder();
        direccionGestoraDTOBuilder.idDireccion(entity.getIdDireccion());
        direccionGestoraDTOBuilder.idEstadoDireccionGestora(entity.getIdEstadoDireccionGestora());
        direccionGestoraDTOBuilder.idGestora(entity.getIdGestora());
        direccionGestoraDTOBuilder.direccion(entity.getDireccion());
        direccionGestoraDTOBuilder.audCreaDate(entity.getAudCreaDate());
        direccionGestoraDTOBuilder.audModDate(entity.getAudModDate());
        direccionGestoraDTOBuilder.audCreaProc(entity.getAudCreaProc());
        direccionGestoraDTOBuilder.audModProc(entity.getAudModProc());
        direccionGestoraDTOBuilder.audCreaUsu(entity.getAudCreaUsu());
        direccionGestoraDTOBuilder.audModUsu(entity.getAudModUsu());

        var direccionGestora=direccionGestoraDTOBuilder.build();
        return direccionGestora;
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
        entity.setIdEstadoDireccionGestora(dto.getIdEstadoDireccionGestora());
        entity.setIdGestora(dto.getIdGestora());
        entity.setDireccion(dto.getDireccion());
        entity.setAudCreaDate(dto.getAudCreaDate());
        entity.setAudModDate(new Date());
        entity.setAudCreaProc(dto.getAudCreaProc());
        entity.setAudModProc(dto.getAudModProc());
        entity.setAudCreaUsu(dto.getAudCreaUsu());
        entity.setAudModUsu(dto.getAudModUsu());
        return entity;
    }
}
