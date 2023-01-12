package org.drdel.beca.prjfinal.micro.operaciones.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.json.JSONObject;

import javax.validation.constraints.Size;
import java.util.Date;

public class FondosClienteHistoryDTO {

    private long idFondosCliente;

    private String estadosContratacion;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Size(max = 10)
    private Date fechaCambioEstado;

    private double importe;

    private String operacionesContratacion;

    public FondosClienteHistoryDTO(long idFondosCliente, String estadosContratacion, Date fechaCambioEstado, double importe, String operacionesContratacion) {
        this.idFondosCliente = idFondosCliente;
        this.estadosContratacion = estadosContratacion;
        this.fechaCambioEstado = fechaCambioEstado;
        this.importe = importe;
        this.operacionesContratacion = operacionesContratacion;
    }

    public long getIdFondosCliente() {
        return idFondosCliente;
    }

    public void setIdFondosCliente(long idFondosCliente) {
        this.idFondosCliente = idFondosCliente;
    }

    public String getEstadosContratacion() {
        return estadosContratacion;
    }

    public void setEstadosContratacion(String estadosContratacion) {
        this.estadosContratacion = estadosContratacion;
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

    public String getOperacionesContratacion() {
        return operacionesContratacion;
    }

    public void setOperacionesContratacion(String operacionesContratacion) {
        this.operacionesContratacion = operacionesContratacion;
    }

    public String toJSON(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("idFondosCliente",getIdFondosCliente());
        jsonObject.put("estadosContratacion",getEstadosContratacion());
        jsonObject.put("cambioEstado", getFechaCambioEstado());
        jsonObject.put("importe",getImporte());
        jsonObject.put("operacionesContratacion",getOperacionesContratacion());
        return jsonObject.toString();
    }
}