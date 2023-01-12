package org.drdel.beca.prjfinal.micro.operaciones.model.domain;

import org.json.JSONObject;

import javax.validation.constraints.NotBlank;

public class EstadosContratacionDTO {

    private String codEstadosContratacion;

    @NotBlank
    private String descripcion;

    public EstadosContratacionDTO(String codEstadosContratacion, String descripcion) {
        this.codEstadosContratacion = codEstadosContratacion;
        this.descripcion = descripcion;
    }

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

    public String toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("codEstadosContratacion", codEstadosContratacion);
        jsonObject.put("descripcion", descripcion);

        return jsonObject.toString();
    }
}