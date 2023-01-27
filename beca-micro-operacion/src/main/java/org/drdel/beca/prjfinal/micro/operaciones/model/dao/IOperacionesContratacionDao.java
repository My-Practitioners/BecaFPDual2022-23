package org.drdel.beca.prjfinal.micro.operaciones.model.dao;

import org.drdel.beca.prjfinal.micro.operaciones.model.entity.OperacionContratacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOperacionesContratacionDao extends JpaRepository<OperacionContratacion,Long> {
}
