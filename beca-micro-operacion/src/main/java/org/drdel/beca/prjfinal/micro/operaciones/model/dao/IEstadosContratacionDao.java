package org.drdel.beca.prjfinal.micro.operaciones.model.dao;

import org.drdel.beca.prjfinal.micro.operaciones.model.entity.EstadosContratacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstadosContratacionDao extends JpaRepository<EstadosContratacion, String> {
}