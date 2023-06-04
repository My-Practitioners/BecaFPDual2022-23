package org.drdel.beca.prjfinal.micro.clientes.model.rule;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckStatusTest {

    @Test
    @DisplayName("Test check all possible status transitions")
    void checkStatusTestPossibleTransitions(){
        assertTrue(EstadosRules.checkStatus(ClienteEstadoEnum.DRAFT.getEstadoEnum(), ClienteEstadoEnum.OPERATIVE.getEstadoEnum()));
        assertTrue(EstadosRules.checkStatus(ClienteEstadoEnum.OPERATIVE.getEstadoEnum(), ClienteEstadoEnum.SUSPENDED.getEstadoEnum()));
        assertTrue(EstadosRules.checkStatus(ClienteEstadoEnum.OPERATIVE.getEstadoEnum(), ClienteEstadoEnum.CANCELED.getEstadoEnum()));
        assertTrue(EstadosRules.checkStatus(ClienteEstadoEnum.SUSPENDED.getEstadoEnum(), ClienteEstadoEnum.OPERATIVE.getEstadoEnum()));
        assertTrue(EstadosRules.checkStatus(ClienteEstadoEnum.SUSPENDED.getEstadoEnum(), ClienteEstadoEnum.CANCELED.getEstadoEnum()));
    }

    @Test
    @DisplayName("Test check possible status transitions not allowed")
    void checkStatusTestNotPossibleTransitions(){
        assertFalse(EstadosRules.checkStatus(ClienteEstadoEnum.DRAFT.getEstadoEnum(), ClienteEstadoEnum.SUSPENDED.getEstadoEnum()));
        assertFalse(EstadosRules.checkStatus(ClienteEstadoEnum.DRAFT.getEstadoEnum(), ClienteEstadoEnum.CANCELED.getEstadoEnum()));
        assertFalse(EstadosRules.checkStatus(ClienteEstadoEnum.OPERATIVE.getEstadoEnum(), ClienteEstadoEnum.DRAFT.getEstadoEnum()));
        assertFalse(EstadosRules.checkStatus(ClienteEstadoEnum.CANCELED.getEstadoEnum(), ClienteEstadoEnum.DRAFT.getEstadoEnum()));
        assertFalse(EstadosRules.checkStatus(ClienteEstadoEnum.CANCELED.getEstadoEnum(), ClienteEstadoEnum.OPERATIVE.getEstadoEnum()));
        assertFalse(EstadosRules.checkStatus(ClienteEstadoEnum.CANCELED.getEstadoEnum(), ClienteEstadoEnum.SUSPENDED.getEstadoEnum()));
        assertFalse(EstadosRules.checkStatus(ClienteEstadoEnum.SUSPENDED.getEstadoEnum(), ClienteEstadoEnum.DRAFT.getEstadoEnum()));
    }

}
