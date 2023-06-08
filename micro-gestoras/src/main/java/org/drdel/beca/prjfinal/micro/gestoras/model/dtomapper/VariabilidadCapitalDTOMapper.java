package org.drdel.beca.prjfinal.micro.gestoras.model.dtomapper;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.GestoraDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.domain.VariabilidadCapitalDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.entity.VariabilidadCapital;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VariabilidadCapitalDTOMapper {

    private VariabilidadCapitalDTOMapper() {}

    public static VariabilidadCapitalDTO transformEntityToDTO(VariabilidadCapital entity) {

        VariabilidadCapitalDTO.VariabilidadCapitalDTOBuilder variabilidadCapitalDTOBuilder=new VariabilidadCapitalDTO.VariabilidadCapitalDTOBuilder();
        variabilidadCapitalDTOBuilder.codVariabilidadCapital(entity.getCodVariabilidadCapital());
        variabilidadCapitalDTOBuilder.idEstadoVariabilidadCapital(entity.getIdEstadoVariabilidadCapital());
        variabilidadCapitalDTOBuilder.descripcion(entity.getDescripcion());
        variabilidadCapitalDTOBuilder.audCreaDate(entity.getAudCreaDate());
        variabilidadCapitalDTOBuilder.audModDate(entity.getAudModDate());
        variabilidadCapitalDTOBuilder.audCreaProc(entity.getAudCreaProc());
        variabilidadCapitalDTOBuilder.audModProc(entity.getAudModProc());
        variabilidadCapitalDTOBuilder.audCreaUsu(entity.getAudCreaUsu());
        variabilidadCapitalDTOBuilder.audModUsu(entity.getAudModUsu());

        var variabilidadCapital=variabilidadCapitalDTOBuilder.build();
        return variabilidadCapital;
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
        entity.setIdEstadoVariabilidadCapital(dto.getIdEstadoVariabilidadCapital());
        entity.setDescripcion(dto.getDescripcion());
        entity.setAudCreaDate(dto.getAudCreaDate());
        entity.setAudModDate(new Date());
        entity.setAudCreaProc(dto.getAudCreaProc());
        entity.setAudModProc(dto.getAudModProc());
        entity.setAudCreaUsu(dto.getAudCreaUsu());
        entity.setAudModUsu(dto.getAudModUsu());
        return entity;

    }


}
