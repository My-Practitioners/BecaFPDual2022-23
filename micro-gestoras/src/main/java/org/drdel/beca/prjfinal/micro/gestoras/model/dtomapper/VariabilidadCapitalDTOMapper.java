package org.drdel.beca.prjfinal.micro.gestoras.model.dtomapper;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.VariabilidadCapitalDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.entity.VariabilidadCapital;

import java.util.ArrayList;
import java.util.List;

public class VariabilidadCapitalDTOMapper {

    private VariabilidadCapitalDTOMapper() {}

    public static VariabilidadCapitalDTO transformEntityToDTO(VariabilidadCapital entity) {

        return new VariabilidadCapitalDTO(entity.getCodVariabilidadCapital(),
                entity.getDescripcion());
    }

    public static List<VariabilidadCapitalDTO> transformEntityListToDTOList(Iterable<VariabilidadCapital> entityIterable) {
        List<VariabilidadCapitalDTO> dtoList =  new ArrayList<>();
        entityIterable.forEach(pr ->
                dtoList.add(transformEntityToDTO(pr)));
        return dtoList;
    }

    public static VariabilidadCapital transformDTOToEntity(VariabilidadCapitalDTO dto) {

        var entity = new VariabilidadCapital();

        entity.setCodVariabilidadCapital(dto.getCodVariabilidadCapital());
        entity.setDescripcion(dto.getDescripcion());
        entity.setAudCreaDate(dto.getAudCreaDate());
        entity.setAudModDate(dto.getAudModDate());
        entity.setAudCreaProc(dto.getAudCreaProc());
        entity.setAudModProc(dto.getAudModProc());
        entity.setAudCreaUsu(dto.getAudCreaUsu());
        entity.setAudModUsu(dto.getAudModUsu());
        return entity;

    }


}
