package org.drdel.beca.prjfinal.micro.gestoras.model.dtomapper;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.GestoraDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.domain.PoliticaInversionDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.entity.PoliticaInversion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PoliticaInversionDTOMapper {

    private PoliticaInversionDTOMapper(){}

    public static PoliticaInversionDTO transformEntityToDTO(PoliticaInversion entity) {

        PoliticaInversionDTO.PoliticaInversionDTOBuilder politicaInversionDTOBuilder=new PoliticaInversionDTO.PoliticaInversionDTOBuilder();
        politicaInversionDTOBuilder.codPinversion(entity.getCodPinversion());
        politicaInversionDTOBuilder.idEstadoPoliticaInversion(entity.getIdEstadoPoliticaInversion());
        politicaInversionDTOBuilder.descripcion(entity.getDescripcion());
        politicaInversionDTOBuilder.audCreaDate(entity.getAudCreaDate());
        politicaInversionDTOBuilder.audModDate(entity.getAudModDate());
        politicaInversionDTOBuilder.audCreaProc(entity.getAudCreaProc());
        politicaInversionDTOBuilder.audModProc(entity.getAudModProc());
        politicaInversionDTOBuilder.audCreaUsu(entity.getAudCreaUsu());
        politicaInversionDTOBuilder.audModUsu(entity.getAudModUsu());

        var politicaInversion=politicaInversionDTOBuilder.build();
        return politicaInversion;
    }

    public static List<PoliticaInversionDTO> transformEntityListToDTOList(Iterable<PoliticaInversion> entityIterable) {
        List<PoliticaInversionDTO> dtoList =  new ArrayList<>();
        entityIterable.forEach(pr ->
                dtoList.add(transformEntityToDTO(pr)));
        return dtoList;
    }

    public static PoliticaInversion transformDTOToEntity(PoliticaInversionDTO dto) {
        var entity = new PoliticaInversion();
        entity.setCodPinversion(dto.getCodPinversion());
        entity.setIdEstadoPoliticaInversion(dto.getIdEstadoPoliticaInversion());
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
