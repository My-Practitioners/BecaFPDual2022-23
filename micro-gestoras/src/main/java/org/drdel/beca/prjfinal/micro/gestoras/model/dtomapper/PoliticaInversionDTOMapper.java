package org.drdel.beca.prjfinal.micro.gestoras.model.dtomapper;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.PoliticaInversionDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.entity.PoliticaInversion;

import java.util.ArrayList;
import java.util.List;

public class PoliticaInversionDTOMapper {

    private PoliticaInversionDTOMapper(){}

    public static PoliticaInversionDTO transformEntityToDTO(PoliticaInversion entity) {

        return new PoliticaInversionDTO(entity.getCodPinversion(),
                entity.getDescripcion());
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
