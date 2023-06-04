package org.drdel.beca.prjfinal.micro.operaciones.model.rules;

import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondoClienteHistoryDTO;
import org.drdel.beca.prjfinal.micro.operaciones.model.exception.FondoClienteHistoryException;
import org.drdel.beca.prjfinal.micro.operaciones.model.service.FondoClienteHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContratacionRules {


    public FondoClienteHistoryDTO checkToActiveFondoCliente(FondoClienteHistoryDTO dto){
        if (dto.getIdEstadoContratacion()!=1 || dto.getIdOperacionContratacion()!=4){
            return dto;
        }else {
            try {
                return FondoClienteHistoryException.activarFondoCliente();
            } catch (FondoClienteHistoryException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    public FondoClienteHistoryDTO checkToCancelFondoCliente(FondoClienteHistoryDTO dto){
        if (dto.getIdEstadoContratacion() != 2 || dto.getIdOperacionContratacion() != 5){
            return dto;
        }else {
            try {
                return FondoClienteHistoryException.cancelarFondoCliente();
            } catch (FondoClienteHistoryException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }


    public FondoClienteHistoryDTO checkToSuspendFondoCliente(FondoClienteHistoryDTO dto){
        if (dto.getIdEstadoContratacion() != 3 || dto.getIdOperacionContratacion() != 3){
            return dto;
        }else {
            try {
                return FondoClienteHistoryException.suspenderFondoCliente();
            } catch (FondoClienteHistoryException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }
    public FondoClienteHistoryDTO checkToModifyContratacion(FondoClienteHistoryDTO dto){

        if (dto.getIdEstadoContratacion()==1 || dto.getIdOperacionContratacion()==2){
            return dto;
        }else {
            try {
                return FondoClienteHistoryException.modificarImporte();
            }catch (FondoClienteHistoryException e){
                throw new IllegalArgumentException();
            }
        }
    }
}
