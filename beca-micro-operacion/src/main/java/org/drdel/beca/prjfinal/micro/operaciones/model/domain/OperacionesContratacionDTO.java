package org.drdel.beca.prjfinal.micro.operaciones.model.domain;

import org.json.JSONObject;

public class OperacionesContratacionDTO {

    private int idOperacionesContratacion;

    private String descripcion;

    public OperacionesContratacionDTO(int idOperacionesContratacion, String descripcion) {
        this.idOperacionesContratacion = idOperacionesContratacion;
        this.descripcion = descripcion;
    }

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

    public String toJSON(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("idOperacionesContratacion",getIdOperacionesContratacion());
        jsonObject.put("descripcion",getDescripcion());
        return jsonObject.toString();

    }
}
