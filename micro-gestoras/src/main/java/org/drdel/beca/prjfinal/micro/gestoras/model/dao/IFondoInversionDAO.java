package org.drdel.beca.prjfinal.micro.gestoras.model.dao;

import org.drdel.beca.prjfinal.micro.gestoras.model.entity.FondoInversion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFondoInversionDAO extends JpaRepository<FondoInversion,String> {
    List<FondoInversion> findByNombreFondo(String nombreFondo);
}
