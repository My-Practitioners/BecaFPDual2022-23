package org.drdel.beca.prjfinal.micro.operaciones.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "t_operaciones_contratacion")
public class OperacionesContratacion implements Serializable {

    @Id
    @Column(name = "id_operaciones_contratacion")
    private int idOperacionesContratacion;

    @Column(name = "descripcion")
    @NotBlank
    private String descripcion;

    public int getIdOperacionesContratacion() {
        return idOperacionesContratacion;
    }

    public void setIdOperacionesContratacion(int idOperacionesContratacion) {
        this.idOperacionesContratacion = idOperacionesContratacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
