package org.drdel.beca.prjfinal.model.dao;

import org.drdel.beca.prjfinal.model.entity.FondoInversion;
import org.drdel.beca.prjfinal.model.entity.PoliticaInversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IFondoInversionDAO extends CrudRepository<FondoInversion,String> {

    public List<FondoInversion> findByNombreFondo(String nombreFondo);

    /*public List<FondoInversion> findByClienteId(Long clienteId);*/

}
