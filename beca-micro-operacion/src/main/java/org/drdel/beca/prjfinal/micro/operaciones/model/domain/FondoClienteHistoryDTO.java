package org.drdel.beca.prjfinal.micro.operaciones.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.json.JSONObject;

import javax.validation.constraints.Size;
import java.util.Date;

public class FondoClienteHistoryDTO {

    private Long idFondoClienteHistory;

    private long idFondoCliente;

    private int idEstadoContratacion;

    private double importe;

    private int idOperacionContratacion;

    public FondoClienteHistoryDTO(Long idFondoClienteHistory, long idFondoCliente, int idEstadoContratacion, double importe, int idOperacionContratacion) {
        this.idFondoClienteHistory = idFondoClienteHistory;
        this.idFondoCliente = idFondoCliente;
        this.idEstadoContratacion = idEstadoContratacion;
        this.importe = importe;
        this.idOperacionContratacion = idOperacionContratacion;
    }

    public FondoClienteHistoryDTO() {

    }

    public Long getIdFondoClienteHistory() {
        return idFondoClienteHistory;
    }

    public void setIdFondoClienteHistory(Long idFondoClienteHistory) {
        this.idFondoClienteHistory = idFondoClienteHistory;
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
        jsonObject.put("importe",getImporte());
        jsonObject.put("idOperacionContratacion", getIdOperacionContratacion());
        return jsonObject.toString();
    }
}