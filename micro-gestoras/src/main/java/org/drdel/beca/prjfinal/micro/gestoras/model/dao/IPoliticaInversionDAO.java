package org.drdel.beca.prjfinal.micro.gestoras.model.dao;

import org.drdel.beca.prjfinal.micro.gestoras.model.entity.PoliticaInversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IPoliticaInversionDAO extends JpaRepository<PoliticaInversion,String> {
    List<PoliticaInversion> findByDescripcion(String descripcion);
}
