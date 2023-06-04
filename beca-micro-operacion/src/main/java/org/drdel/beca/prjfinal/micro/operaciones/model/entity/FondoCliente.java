package org.drdel.beca.prjfinal.micro.operaciones.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_fondos_cliente")
public class FondoCliente implements Serializable {

    @Id
    @Column(name = "id_fondo_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFondosCliente;

    @Column(name = "cod_isin")
    @NotNull
    private String codIsin;

    @Column(name = "id_cliente")
    @NotNull
    private long idCliente;

    @Column(name = "fecha_contratacion")
    @NotNull
    private Date fechaContratacion;

    @Column(name = "importe")
    @NotNull
    private Integer importe;

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

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public Integer getImporte() {
        return importe;
    }

    public void setImporte(Integer importe) {
        this.importe = importe;
    }
}
