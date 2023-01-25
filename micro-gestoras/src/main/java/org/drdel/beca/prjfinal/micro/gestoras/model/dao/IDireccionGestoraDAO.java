package org.drdel.beca.prjfinal.micro.gestoras.model.dao;

import org.drdel.beca.prjfinal.micro.gestoras.model.entity.DireccionGestora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDireccionGestoraDAO extends JpaRepository<DireccionGestora,Long> {

    List<DireccionGestora> findByDireccion(String direccionGestora);
}
