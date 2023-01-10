package org.drdel.beca.prjfinal.micro.clientes.model.dtomapper;

import org.drdel.beca.prjfinal.micro.clientes.model.domain.GestoraDTO;
import org.drdel.beca.prjfinal.micro.clientes.model.entity.Gestora;

import java.util.ArrayList;
import java.util.List;

public class GestoraDTOMapper {

    private GestoraDTOMapper(){}

    public static GestoraDTO transofrmEntityToDTO(Gestora entity){
        return new GestoraDTO(entity.getIdGestora(),
                entity.getNombre());
    }

    public static List<GestoraDTO> transformEntityListToDTOList(Iterable<Gestora> entityIterable){
        List<GestoraDTO> dtoList=new ArrayList<>();
        entityIterable.forEach(pr ->
                dtoList.add(transofrmEntityToDTO(pr)));
        return dtoList;
    }

    public static Gestora transformDTOToEntity(GestoraDTO dto){
        var entity=new Gestora();
        entity.setIdGestora(dto.getIdGestora());
        entity.setNombre(dto.getNombre());
        entity.setAudCreaDate(dto.getAudCreaDate());
        entity.setAudModDate(dto.getAudModDate());
        entity.setAudCreaProc(dto.getAudCreaProc());
        entity.setAudModProc(dto.getAudModProc());
        entity.setAudCreaUsu(dto.getAudCreaUsu());
        entity.setAudModUsu(dto.getAudModUsu());
        return entity;
    }
}
