package org.drdel.beca.prjfinal.micro.operaciones.model.dtomapper;

import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondoClienteDTO;
import org.drdel.beca.prjfinal.micro.operaciones.model.entity.FondoCliente;

import java.util.ArrayList;
import java.util.List;

public class FondoClienteDTOMapper {

    private FondoClienteDTOMapper(){}

    public static FondoClienteDTO transformEntityToDTO(FondoCliente entity){
        return new FondoClienteDTO(entity.getIdFondosCliente(),
                entity.getCodIsin(),
                entity.getIdCliente(),
                entity.getFechaContratacion());
    }

    public static List<FondoClienteDTO> transformEntityListToDTOList(Iterable<FondoCliente> entityIterable){
        List<FondoClienteDTO> dtoList = new ArrayList<>();
        entityIterable.forEach(pr ->
                dtoList.add(transformEntityToDTO(pr)));
        return dtoList;
    }

    public static FondoCliente transformDTOToEntity(FondoClienteDTO dto){
        var entity = new FondoCliente();
        entity.setIdFondosCliente(dto.getIdFondoCliente());
        entity.setCodIsin(dto.getCodIsin());
        entity.setIdCliente(dto.getIdCliente());
        entity.setFechaContratacion(dto.getFechaContratacion());
        return entity;
    }
}
