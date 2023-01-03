package org.drdel.beca.prjfinal.model.dao;

import org.drdel.beca.prjfinal.model.entity.DireccionGestora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDireccionGestoraDAO extends JpaRepository<DireccionGestora,Long> {
    public List<DireccionGestora> findByDireccion(String direccionGestora);
}
