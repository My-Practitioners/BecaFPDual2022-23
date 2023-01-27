package org.drdel.beca.prjfinal.micro.operaciones.model.dao;

import org.drdel.beca.prjfinal.micro.operaciones.model.entity.FondoCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFondosClienteDao extends JpaRepository<FondoCliente, Long> {
}