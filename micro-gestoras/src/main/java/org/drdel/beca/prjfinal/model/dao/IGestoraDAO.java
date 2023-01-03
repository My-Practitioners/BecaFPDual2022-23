package org.drdel.beca.prjfinal.model.dao;

import org.drdel.beca.prjfinal.model.entity.Gestora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IGestoraDAO extends CrudRepository<Gestora,Long> {
    public List<Gestora> findByNombre(String nombreGestora);
}
