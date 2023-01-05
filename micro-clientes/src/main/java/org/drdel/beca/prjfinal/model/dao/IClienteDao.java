package org.drdel.beca.prjfinal.model.dao;

import org.drdel.beca.prjfinal.model.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long> {

    @Query("select c from Cliente c where c.nombre like %?1% and c.apellido like %?2% and c.email like %?3%")
    Page<Cliente> findByNombreAndApellidoAndEmail(Pageable pageable, String nombre, String apellido, String email);

}
