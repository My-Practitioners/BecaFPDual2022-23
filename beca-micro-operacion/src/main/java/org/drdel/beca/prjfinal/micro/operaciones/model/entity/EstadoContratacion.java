package org.drdel.beca.prjfinal.micro.operaciones.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "t_estados_contratacion")
public class EstadoContratacion implements Serializable {

    @Id
    @Column(name = "id_estado_contratacion")
    private int idEstadoContratacion;

    @Column(name = "descripcion")
    @NotBlank
    private String descripcion;

    public int getIdEstadoContratacion() {
        return idEstadoContratacion;
    }

    public void setIdEstadoContratacion(int idEstadoContratacion) {
        this.idEstadoContratacion = idEstadoContratacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
