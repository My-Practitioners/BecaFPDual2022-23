package org.drdel.beca.prjfinal.micro.operaciones.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "t_operaciones_contratacion")
public class OperacionContratacion implements Serializable {

    @Id
    @Column(name = "id_operacion_contratacion")
    private int idOperacionContratacion;

    @Column(name = "descripcion")
    @NotBlank
    private String descripcion;

    public int getIdOperacionContratacion() {
        return idOperacionContratacion;
    }

    public void setIdOperacionContratacion(int idOperacionContratacion) {
        this.idOperacionContratacion = idOperacionContratacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
