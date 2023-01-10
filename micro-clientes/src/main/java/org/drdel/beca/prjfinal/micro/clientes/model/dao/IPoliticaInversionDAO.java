package org.drdel.beca.prjfinal.micro.clientes.model.dao;

import org.drdel.beca.prjfinal.micro.clientes.model.entity.PoliticaInversion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPoliticaInversionDAO extends JpaRepository<PoliticaInversion,String> {
    public List<PoliticaInversion> findByDescripcion(String descripcion);
}
