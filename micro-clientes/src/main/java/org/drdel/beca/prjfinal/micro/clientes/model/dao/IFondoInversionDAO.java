package org.drdel.beca.prjfinal.micro.clientes.model.dao;

import org.drdel.beca.prjfinal.micro.clientes.model.entity.FondoInversion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IFondoInversionDAO extends CrudRepository<FondoInversion,String> {

    public List<FondoInversion> findByNombreFondo(String nombreFondo);

    /*public List<FondoInversion> findByClienteId(Long clienteId);*/

}
