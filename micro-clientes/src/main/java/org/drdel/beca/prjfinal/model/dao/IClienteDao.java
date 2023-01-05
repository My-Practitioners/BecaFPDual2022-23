package org.drdel.beca.prjfinal.model.dao;

import org.drdel.beca.prjfinal.model.domain.ClienteDTO;
import org.drdel.beca.prjfinal.model.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface IClienteDao  extends JpaRepository<Cliente, Long> {
    public List<Cliente> findByNombre(String nombre);

}
