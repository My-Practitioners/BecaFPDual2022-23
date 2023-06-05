package org.drdel.beca.prjfinal.micro.gestoras.model.dao;

import org.drdel.beca.prjfinal.micro.gestoras.model.entity.Gestora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface IGestoraDAO extends JpaRepository<Gestora,Long> {
    List<Gestora> findByNombre(String nombreGestora);
}
