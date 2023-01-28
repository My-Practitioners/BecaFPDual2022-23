package org.drdel.beca.prjfinal.micro.clientes.model.service;

import org.drdel.beca.prjfinal.micro.clientes.model.rule.EstadosRules;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CheckStatusTest {

    @Test
    @DisplayName("Test check status")
    void checkStatusTestActivar(){
        assertTrue(EstadosRules.checkStatus(0,1));
    }

    @Test
    @DisplayName("Test check status")
    void checkStatusTestCancelar(){
        assertTrue(EstadosRules.checkStatus(1,3));
    }

}
