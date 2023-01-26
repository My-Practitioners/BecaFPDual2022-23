package org.drdel.beca.prjfinal.micro.operaciones.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "t_estados_contratacion")
public class EstadosContratacion implements Serializable {

    @Id
    @Column(name = "id_estados_contratacion")
    private int idEstadosContratacion;

    @Column(name = "descripcion")
    @NotBlank
    private String descripcion;

    public int getIdEstadosContratacion() {
        return idEstadosContratacion;
    }

    public void setIdEstadosContratacion(int idEstadosContratacion) {
        this.idEstadosContratacion = idEstadosContratacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
