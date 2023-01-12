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
    @Column(name = "cod_operaciones_contratacion")
    private String codOperacionesContratacion;

    @Column(name = "descripcion")
    @NotBlank
    private String descripcion;

    public String getCodOperacionesContratacion() {
        return codOperacionesContratacion;
    }

    public void setCodOperacionesContratacion(String codOperacionesContratacion) {
        this.codOperacionesContratacion = codOperacionesContratacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
