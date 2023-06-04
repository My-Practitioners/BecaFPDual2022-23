package org.drdel.beca.prjfinal.micro.operaciones.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.json.JSONObject;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class FondoClienteDTO {

    private long idFondoCliente;

    @NotNull
    private String codIsin;

    @NotNull
    private long idCliente;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Size(max = 10)
    private Date fechaContratacion;


    private Integer importe;

    public FondoClienteDTO() {
    }

    public FondoClienteDTO(long idFondoCliente, String codIsin, long idCliente, Date fechaContratacion, Integer importe) {
        this.idFondoCliente = idFondoCliente;
        this.codIsin = codIsin;
        this.idCliente = idCliente;
        this.fechaContratacion = fechaContratacion;
        this.importe = importe;
    }

    public long getIdFondoCliente() {
        return idFondoCliente;
    }

    public void setIdFondoCliente(long idFondoCliente) {
        this.idFondoCliente = idFondoCliente;
    }

    public String getCodIsin() {
        return codIsin;
    }

    public void setCodIsin(String codIsin) {
        this.codIsin = codIsin;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public Integer getImporte() {
        return importe;
    }

    public void setImporte(Integer importe) {
        this.importe = importe;
    }

    public String toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("idFondoCliente", idFondoCliente);
        jsonObject.put("codIsin", codIsin);
        jsonObject.put("idCliente", idCliente);
        jsonObject.put("fechaContratacion", fechaContratacion);
        jsonObject.put("importe", importe);

        return jsonObject.toString();
    }
}
