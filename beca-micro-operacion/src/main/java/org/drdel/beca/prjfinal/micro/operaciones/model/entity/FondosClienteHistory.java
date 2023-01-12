package org.drdel.beca.prjfinal.micro.operaciones.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "t_fondos_cliente_history")
public class FondosClienteHistory {

    @Id
    @Column(name = "id_fondos_cliente")
    //seria generatedvalue??
    private Long idFondosCliente;

    @Column(name = "estados_contratacion")
    @NotNull
    private String estadosContratacion;

    @Column(name = "fecha_cambio_estado")
    @NotNull
    private Date fechaCambioEstado;

    @Column(name = "importe")
    private double importe;

    @Column(name = "operaciones_contratacion")
    private String operacionesContratacion;

    public Long getIdFondosCliente() {
        return idFondosCliente;
    }

    public void setIdFondosCliente(Long idFondosCliente) {
        this.idFondosCliente = idFondosCliente;
    }

    public String getEstadosContratacion() {
        return estadosContratacion;
    }

    public void setEstadosContratacion(String estadosContratacion) {
        this.estadosContratacion = estadosContratacion;
    }

    public Date getFechaCambioEstado() {
        return fechaCambioEstado;
    }

    public void setFechaCambioEstado(Date fechaCambioEstado) {
        this.fechaCambioEstado = fechaCambioEstado;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getOperacionesContratacion() {
        return operacionesContratacion;
    }

    public void setOperacionesContratacion(String operacionesContratacion) {
        this.operacionesContratacion = operacionesContratacion;
    }
}
