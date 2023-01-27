package org.drdel.beca.prjfinal.micro.operaciones.model.domain;

import org.json.JSONObject;

import javax.validation.constraints.NotBlank;

public class EstadoContratacionDTO {

    private int idEstadoContratacion;

    @NotBlank
    private String descripcion;

    public EstadoContratacionDTO(int idEstadoContratacion, String descripcion) {
        this.idEstadoContratacion = idEstadoContratacion;
        this.descripcion = descripcion;
    }

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

    public String toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("idEstadoContratacion", idEstadoContratacion);
        jsonObject.put("descripcion", descripcion);

        return jsonObject.toString();
    }
}