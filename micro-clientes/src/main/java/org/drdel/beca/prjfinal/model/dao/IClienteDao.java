package org.drdel.beca.prjfinal.model.dao;

import org.drdel.beca.prjfinal.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClienteDao  extends JpaRepository<Cliente, Long> {
    public List<Cliente> findByApellido(String apellido);

}
