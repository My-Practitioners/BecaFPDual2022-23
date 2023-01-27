package org.drdel.beca.prjfinal.micro.operaciones.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.json.JSONObject;

import javax.validation.constraints.Size;
import java.util.Date;

public class FondoClienteHistoryDTO {

    private long idFondoCliente;

    private int idEstadoContratacion;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Size(max = 10)
    private Date fechaCambioEstado;

    private double importe;

    private int idOperacionContratacion;

    public FondoClienteHistoryDTO(long idFondoCliente, int idEstadoContratacion, Date fechaCambioEstado, double importe, int idOperacionContratacion) {
        this.idFondoCliente = idFondoCliente;
        this.idEstadoContratacion = idEstadoContratacion;
        this.fechaCambioEstado = fechaCambioEstado;
        this.importe = importe;
        this.idOperacionContratacion = idOperacionContratacion;
    }

    public long getIdFondoCliente() {
        return idFondoCliente;
    }

    public void setIdFondoCliente(long idFondoCliente) {
        this.idFondoCliente = idFondoCliente;
    }

    public int getIdEstadoContratacion() {
        return idEstadoContratacion;
    }

    public void setIdEstadoContratacion(int idEstadoContratacion) {
        this.idEstadoContratacion = idEstadoContratacion;
    }

    public Date getFechaCambioEstado() {
        return fechaCambioEstado;
    }

    public void setFechaCambioEstado(Date fechaCambioEstado) {
        this.fechaCambioEstado = fechaCambioEstado;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getIdOperacionContratacion() {
        return idOperacionContratacion;
    }

    public void setIdOperacionContratacion(int idOperacionContratacion) {
        this.idOperacionContratacion = idOperacionContratacion;
    }

    public String toJSON(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("idFondoCliente", getIdFondoCliente());
        jsonObject.put("idEstadoContratacion", getIdEstadoContratacion());
        jsonObject.put("cambioEstado", getFechaCambioEstado());
        jsonObject.put("importe",getImporte());
        jsonObject.put("idOperacionContratacion", getIdOperacionContratacion());
        return jsonObject.toString();
    }
}