package org.drdel.beca.prjfinal.micro.operaciones.model.dao;

import org.drdel.beca.prjfinal.micro.operaciones.model.entity.FondosCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFondosClienteDao extends JpaRepository<FondosCliente, Long> {
}