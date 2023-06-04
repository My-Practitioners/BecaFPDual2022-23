package org.drdel.beca.prjfinal.micro.operaciones.model.domain;

import org.json.JSONObject;

public class OperacionContratacionDTO {

    private int idOperacionContratacion;

    private String descripcion;

    public OperacionContratacionDTO(int idOperacionContratacion, String descripcion) {
        this.idOperacionContratacion = idOperacionContratacion;
        this.descripcion = descripcion;
    }

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

    public String toJSON(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("idOperacionContratacion", getIdOperacionContratacion());
        jsonObject.put("descripcion",getDescripcion());
        return jsonObject.toString();

    }
}
