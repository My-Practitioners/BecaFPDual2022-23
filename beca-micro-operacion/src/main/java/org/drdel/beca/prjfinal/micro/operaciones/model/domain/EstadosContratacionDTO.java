package org.drdel.beca.prjfinal.micro.operaciones.model.domain;

import org.json.JSONObject;

import javax.validation.constraints.NotBlank;

public class EstadosContratacionDTO {

    private int idEstadosContratacion;

    @NotBlank
    private String descripcion;

    public EstadosContratacionDTO(int idEstadosContratacion, String descripcion) {
        this.idEstadosContratacion = idEstadosContratacion;
        this.descripcion = descripcion;
    }

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

    public String toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("idEstadosContratacion", idEstadosContratacion);
        jsonObject.put("descripcion", descripcion);

        return jsonObject.toString();
    }
}