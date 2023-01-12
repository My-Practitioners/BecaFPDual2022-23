package org.drdel.beca.prjfinal.micro.operaciones.model.domain;

import org.json.JSONObject;

public class OperacionesContratacionDTO {

    private String codOperacionesContratacion;

    private String descripcion;

    public OperacionesContratacionDTO(String codOperacionesContratacion, String descripcion) {
        this.codOperacionesContratacion = codOperacionesContratacion;
        this.descripcion = descripcion;
    }

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

    public String toJSON(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("codOperacionesContratacion",getCodOperacionesContratacion());
        jsonObject.put("descripcion",getDescripcion());
        return jsonObject.toString();

    }
}
