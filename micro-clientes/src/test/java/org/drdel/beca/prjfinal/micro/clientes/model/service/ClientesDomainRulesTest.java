package org.drdel.beca.prjfinal.micro.clientes.model.service;

import org.drdel.beca.prjfinal.micro.clientes.model.domain.ClienteDTO;
import org.drdel.beca.prjfinal.micro.clientes.model.exception.ClienteException;
import org.drdel.beca.prjfinal.micro.clientes.model.rule.ClientesDomainRules;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class ClientesDomainRulesTest {

    @Autowired
    ClientesDomainRules clientesDomainRules;

    @Test
    @DisplayName("Test checkClientesBR0001")
    void checkClientesBR0001Test() throws ClienteException {
        ClienteDTO dto = new ClienteDTO(400L,0,"Juan","Alvarez","juanalvarez@gmail.com", new Date(110, Calendar.MAY, 15));
        clientesDomainRules.checkClientesBR0001EstadoAActivar(dto);
        assertThat(dto.getIdEstadoCliente()).isEqualTo(1);
    }
}
