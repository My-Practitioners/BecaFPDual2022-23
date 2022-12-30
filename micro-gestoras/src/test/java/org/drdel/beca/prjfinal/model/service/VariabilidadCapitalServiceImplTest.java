package org.drdel.beca.prjfinal.model.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class VariabilidadCapitalServiceImplTest {

    @Autowired
    private VariabilidadCapitalServiceImpl variabilidadCapitalService;

    @Test
    void testobtenerVariabilidadCapital() {
        // Call the service method
        var varCap = variabilidadCapitalService.obtenerVariabilidadCapital("capf");
        assertNotNull(varCap);
        assertEquals("capital fijo", varCap.getDescripcion());

    }

}
