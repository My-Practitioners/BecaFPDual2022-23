package org.drdel.beca.prjfinal.micro.clientes.model.dao;

import org.drdel.beca.prjfinal.micro.clientes.model.entity.VariabilidadCapital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVariabilidadCapitalDao extends JpaRepository<VariabilidadCapital,String> {

    List<VariabilidadCapital> findByDescripcion(String descripcion);
}
