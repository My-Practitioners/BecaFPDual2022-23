package org.drdel.beca.prjfinal.micro.operaciones.model.dao;

import org.drdel.beca.prjfinal.micro.operaciones.model.entity.FondoClienteHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFondosClienteHistoryDao extends JpaRepository<FondoClienteHistory,Long> {
}
