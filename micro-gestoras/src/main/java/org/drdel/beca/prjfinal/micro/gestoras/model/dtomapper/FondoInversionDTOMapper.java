package org.drdel.beca.prjfinal.micro.gestoras.model.dtomapper;

import org.drdel.beca.prjfinal.micro.gestoras.model.domain.FondoInversionDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.domain.GestoraDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.entity.FondoInversion;

import java.util.ArrayList;
import java.util.List;

public class FondoInversionDTOMapper {
    private FondoInversionDTOMapper(){}
    public static FondoInversionDTO transformEntityToDTO(FondoInversion entity) {

        FondoInversionDTO.FondoInversionDTOBuilder fondoInversionDTOBuilder=new FondoInversionDTO.FondoInversionDTOBuilder();
        fondoInversionDTOBuilder.codIsin(entity.getCodIsin());
        fondoInversionDTOBuilder.idEstadoFondoInversion(entity.getIdEstadoFondoInversion());
        fondoInversionDTOBuilder.codEuropeo(entity.getCodEuropeo());
        fondoInversionDTOBuilder.codLei(entity.getCodLei());
        fondoInversionDTOBuilder.nombreFondo(entity.getNombreFondo());
        fondoInversionDTOBuilder.idGestora(entity.getIdGestora());
        fondoInversionDTOBuilder.idDireccion(entity.getIdDireccion());
        fondoInversionDTOBuilder.codPInversion(entity.getCodPInversion());
        fondoInversionDTOBuilder.codVariabilidadCapital(entity.getCodVariabilidadCapital());
        fondoInversionDTOBuilder.subFondo(entity.getSubFondo());
        fondoInversionDTOBuilder.codSupervisor(entity.getCodSupervisor());
        fondoInversionDTOBuilder.audCreaDate(entity.getAudCreaDate());
        fondoInversionDTOBuilder.audModDate(entity.getAudModDate());
        fondoInversionDTOBuilder.audCreaProc(entity.getAudCreaProc());
        fondoInversionDTOBuilder.audModProc(entity.getAudModProc());
        fondoInversionDTOBuilder.audCreaUsu(entity.getAudCreaUsu());
        fondoInversionDTOBuilder.audModUsu(entity.getAudModUsu());

        var fondoInversion=fondoInversionDTOBuilder.build();
        return fondoInversion;
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
        entity.setIdEstadoFondoInversion(dto.getIdEstadoFondoInversion());
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
