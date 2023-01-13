package org.drdel.beca.prjfinal.micro.gestoras.model.dtomapper;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.FondoInversionDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.entity.FondoInversion;

import java.util.ArrayList;
import java.util.List;

public class FondoInversionDTOMapper {
    public static FondoInversionDTO transformEntityToDTO(FondoInversion entity) {

        return new FondoInversionDTO(
                entity.getCodIsin(),
                entity.getCodEuropeo(),
                entity.getCodLei(),
                entity.getNombreFondo(),
                entity.getIdGestora(),
                entity.getIdDireccion(),
                entity.getCodPInversion(),
                entity.getCodVariabilidadCapital(),
                entity.getSubFondo(),
                entity.getCodSupervisor()
                );
    }

    public static List<FondoInversionDTO> transformEntityListToDTOList(Iterable<FondoInversion> entityIterable) {
        List<FondoInversionDTO> dtoList =  new ArrayList<>();
        entityIterable.forEach(pr ->
                dtoList.add(transformEntityToDTO(pr)));
        return dtoList;
    }

    public static FondoInversion transformDTOToEntity(FondoInversionDTO dto) {
        var entity = new FondoInversion();
        entity.setCodIsin(dto.getCodIsin());
        entity.setCodEuropeo(dto.getCodEuropeo());
        entity.setCodLei(dto.getCodLei());
        entity.setNombreFondo(dto.getNombreFondo());
        entity.setIdGestora(dto.getIdGestora());
        entity.setIdDireccion(dto.getIdDireccion());
        entity.setCodPInversion(dto.getCodPInversion());
        entity.setCodVariabilidadCapital(dto.getCodVariabilidadCapital());
        entity.setSubFondo(dto.getSubFondo());
        entity.setCodSupervisor(dto.getCodSupervisor());
        entity.setAudCreaDate(dto.getAudCreaDate());
        entity.setAudModDate(dto.getAudModDate());
        entity.setAudCreaProc(dto.getAudCreaProc());
        entity.setAudModProc(dto.getAudModProc());
        entity.setAudCreaUsu(dto.getAudCreaUsu());
        entity.setAudModUsu(dto.getAudModUsu());
        return entity;
    }
}
