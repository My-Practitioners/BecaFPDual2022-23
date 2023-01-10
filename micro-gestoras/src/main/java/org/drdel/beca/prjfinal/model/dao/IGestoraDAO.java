package org.drdel.beca.prjfinal.model.dao;

import org.drdel.beca.prjfinal.model.entity.Gestora;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface IGestoraDAO extends JpaRepository<Gestora,Long> {
    List<Gestora> findByNombre(String nombreGestora);
}
