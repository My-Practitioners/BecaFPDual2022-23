package org.drdel.beca.prjfinal.micro.operaciones.model.dtomapper;

import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondosClienteDTO;
import org.drdel.beca.prjfinal.micro.operaciones.model.entity.FondosCliente;

import java.util.ArrayList;
import java.util.List;

public class FondosClienteDTOMapper {

    private FondosClienteDTOMapper(){}

    public static FondosClienteDTO transformEntityToDTO(FondosCliente entity){
        return new FondosClienteDTO(entity.getIdFondosCliente(),
                entity.getCodIsin(),
                entity.getIdClientes(),
                entity.getFechaContratacion());
    }

    public static List<FondosClienteDTO> transformEntityListToDTOList(Iterable<FondosCliente> entityIterable){
        List<FondosClienteDTO> dtoList = new ArrayList<>();
        entityIterable.forEach(pr ->
                dtoList.add(transformEntityToDTO(pr)));
        return dtoList;
    }

    public static FondosCliente transformDTOToEntity(FondosClienteDTO dto){
        var entity = new FondosCliente();
        entity.setIdFondosCliente(dto.getIdFondosCliente());
        entity.setCodIsin(dto.getCodIsin());
        entity.setIdClientes(dto.getIdClientes());
        entity.setFechaContratacion(dto.getFechaContratacion());
        return entity;
    }
}
