package org.drdel.beca.prjfinal.micro.operaciones.model.dao;

import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondosClienteDTO;
import org.drdel.beca.prjfinal.micro.operaciones.model.domain.FondosClienteHistoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFondosClienteHistoryDao extends JpaRepository<FondosClienteHistoryDTO,Long> {
}
