package org.drdel.beca.prjfinal.micro.operaciones.model.dtomapper;

import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondosClienteHistoryDTO;
import org.drdel.beca.prjfinal.micro.operaciones.model.entity.FondosClienteHistory;

import java.util.ArrayList;
import java.util.List;

public class FondosClienteHistoryDTOMapper {

    private FondosClienteHistoryDTOMapper(){}

    public static FondosClienteHistoryDTO transformEntityToDTO(FondosClienteHistory entity){
        return new FondosClienteHistoryDTO(
                entity.getIdFondosCliente(),
                entity.getEstadosContratacion(),
                entity.getFechaCambioEstado(),
                entity.getImporte(),
                entity.getOperacionesContratacion());
    }

    public static List<FondosClienteHistoryDTO> transformEntityToDTOList(Iterable<FondosClienteHistory> entityIterable){
        List<FondosClienteHistoryDTO>dtoList=new ArrayList<>();
        entityIterable.forEach(pr -> dtoList.add(transformEntityToDTO(pr)));
        return dtoList;
    }

    public FondosClienteHistory transformDTOToEntity(FondosClienteHistoryDTO dto){
        var entity= new FondosClienteHistory();
        entity.setIdFondosCliente(dto.getIdFondosCliente());
        entity.setEstadosContratacion(dto.getEstadosContratacion());
        entity.setFechaCambioEstado(dto.getFechaCambioEstado());
        entity.setImporte(dto.getImporte());
        entity.setOperacionesContratacion(dto.getOperacionesContratacion());
        return entity;
    }
}
