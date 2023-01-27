package org.drdel.beca.prjfinal.micro.operaciones.model.dtomapper;

import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondoClienteHistoryDTO;
import org.drdel.beca.prjfinal.micro.operaciones.model.entity.FondoClienteHistory;

import java.util.ArrayList;
import java.util.List;

public class FondoClienteHistoryDTOMapper {

    private FondoClienteHistoryDTOMapper(){}

    public static FondoClienteHistoryDTO transformEntityToDTO(FondoClienteHistory entity){
        return new FondoClienteHistoryDTO(
                entity.getIdFondoCliente(),
                entity.getIdEstadoContratacion(),
                entity.getFechaCambioEstado(),
                entity.getImporte(),
                entity.getIdOperacionContratacion());
    }

    public static List<FondoClienteHistoryDTO> transformEntityToDTOList(Iterable<FondoClienteHistory> entityIterable){
        List<FondoClienteHistoryDTO>dtoList=new ArrayList<>();
        entityIterable.forEach(pr -> dtoList.add(transformEntityToDTO(pr)));
        return dtoList;
    }

    public static FondoClienteHistory transformDTOToEntity(FondoClienteHistoryDTO dto){
        var entity= new FondoClienteHistory();
        entity.setIdFondoCliente(dto.getIdFondoCliente());
        entity.setIdEstadoContratacion(dto.getIdEstadoContratacion());
        entity.setFechaCambioEstado(dto.getFechaCambioEstado());
        entity.setImporte(dto.getImporte());
        entity.setIdOperacionContratacion(dto.getIdOperacionContratacion());
        return entity;
    }
}
