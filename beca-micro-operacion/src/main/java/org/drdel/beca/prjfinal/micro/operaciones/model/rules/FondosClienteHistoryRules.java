package org.drdel.beca.prjfinal.micro.operaciones.model.rules;

import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondosClienteHistoryDTO;
import org.drdel.beca.prjfinal.micro.operaciones.model.entity.EstadosContratacion;
import org.springframework.beans.factory.annotation.Autowired;

public class FondosClienteHistoryRules {

    @Autowired
    EstadosContratacion estadosContratacion;
    public FondosClienteHistoryDTO suspenderEstado(FondosClienteHistoryDTO fondosClienteHistoryDTO) {
        boolean operativeToCanceled = false;

        return fondosClienteHistoryDTO;
    }

    public FondosClienteHistoryDTO cancelarEstado(FondosClienteHistoryDTO fondosClienteHistoryDTO) {
        return fondosClienteHistoryDTO;
    }
}
