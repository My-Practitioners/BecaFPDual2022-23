package org.drdel.beca.prjfinal.micro.gestoras.model.dao;

import org.drdel.beca.prjfinal.micro.gestoras.model.entity.DireccionGestora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IDireccionGestoraDAO extends JpaRepository<DireccionGestora,Long> {

    List<DireccionGestora> findByDireccion(String direccionGestora);
}
