package org.drdel.beca.prjfinal.micro.operaciones.model.dao;

import org.drdel.beca.prjfinal.micro.operaciones.model.domain.OperacionesContratacionDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOperacionesContratacionDao extends JpaRepository<OperacionesContratacionDTO,Long> {
}
