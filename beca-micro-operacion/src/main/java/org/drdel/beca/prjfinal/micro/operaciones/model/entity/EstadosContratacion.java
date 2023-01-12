package org.drdel.beca.prjfinal.micro.operaciones.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "t_estados_contratacion")
public class EstadosContratacion implements Serializable {

    @Id
    @Column(name = "cod_estados_contratacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codEstadosContratacion;

    @Column(name = "descripcion")
    @NotBlank
    private String descripcion;

    public String getCodEstadosContratacion() {
        return codEstadosContratacion;
    }

    public void setCodEstadosContratacion(String codEstadosContratacion) {
        this.codEstadosContratacion = codEstadosContratacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
