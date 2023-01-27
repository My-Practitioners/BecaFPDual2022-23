package org.drdel.beca.prjfinal.micro.operaciones.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "t_fondos_cliente_history")
public class FondoClienteHistory {

    @Id
    @Column(name = "id_fondo_cliente")
    //seria generatedvalue??
    private Long idFondoCliente;

    @Column(name = "id_estado_contratacion")
    @NotNull
    private int idEstadoContratacion;

    @Column(name = "fecha_cambio_estado")
    @NotNull
    private Date fechaCambioEstado;

    @Column(name = "importe")
    private double importe;

    @Column(name = "id_operacion_contratacion")
    private int idOperacionContratacion;

    public Long getIdFondoCliente() {
        return idFondoCliente;
    }

    public void setIdFondoCliente(Long idFondoCliente) {
        this.idFondoCliente = idFondoCliente;
    }

    public int getIdEstadoContratacion() {
        return idEstadoContratacion;
    }

    public void setIdEstadoContratacion(int idEstadoContratacion) {
        this.idEstadoContratacion = idEstadoContratacion;
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

    public int getIdOperacionContratacion() {
        return idOperacionContratacion;
    }

    public void setIdOperacionContratacion(int idOperacionContratacion) {
        this.idOperacionContratacion = idOperacionContratacion;
    }
}
