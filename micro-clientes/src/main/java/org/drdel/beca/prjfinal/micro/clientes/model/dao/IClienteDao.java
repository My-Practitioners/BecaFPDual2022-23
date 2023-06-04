package org.drdel.beca.prjfinal.micro.clientes.model.dao;

import org.drdel.beca.prjfinal.micro.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClienteDao  extends JpaRepository<Cliente, Long> {
    public List<Cliente> findByApellido(String apellido);

}
