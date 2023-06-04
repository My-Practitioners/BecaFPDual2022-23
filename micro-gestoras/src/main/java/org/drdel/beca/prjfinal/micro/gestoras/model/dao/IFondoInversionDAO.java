package org.drdel.beca.prjfinal.micro.gestoras.model.dao;

import org.drdel.beca.prjfinal.micro.gestoras.model.entity.FondoInversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IFondoInversionDAO extends JpaRepository<FondoInversion,String> {
    List<FondoInversion> findByNombreFondo(String nombreFondo);
}
