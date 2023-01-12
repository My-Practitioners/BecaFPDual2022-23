package org.drdel.beca.prjfinal.micro.operaciones.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "t_fondos_cliente")
public class FondosCliente {

    @Id
    @Column(name = "id_fondos_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFondosCliente;

    @Column(name = "cod_isin")
    @NotNull
    private String codIsin;

    @Column(name = "id_clientes")
    @NotNull
    private long idClientes;

    @Column(name = "fecha_contratacion")
    @NotNull
    private Date fechaContratacion;

    public long getIdFondosCliente() {
        return idFondosCliente;
    }

    public void setIdFondosCliente(long idFondosCliente) {
        this.idFondosCliente = idFondosCliente;
    }

    public String getCodIsin() {
        return codIsin;
    }

    public void setCodIsin(String codIsin) {
        this.codIsin = codIsin;
    }

    public long getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(long idClientes) {
        this.idClientes = idClientes;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

}
