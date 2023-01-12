package org.drdel.beca.prjfinal.micro.operaciones.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.json.JSONObject;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class FondosClienteDTO{

    private long idFondosCliente;

    @NotNull
    private String codIsin;

    @NotNull
    private long idClientes;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Size(max = 10)
    private Date fechaContratacion;

    public FondosClienteDTO(long idFondosCliente, String codIsin, long idClientes, Date fechaContratacion) {
        this.idFondosCliente = idFondosCliente;
        this.codIsin = codIsin;
        this.idClientes = idClientes;
        this.fechaContratacion = fechaContratacion;
    }

    public long getIdFondosCliente() {
        return idFondosCliente;
    }

    public void setIdFondosCliente(long idFondosCliente) {
        this.idFondosCliente = idFondosCliente;
    }

    public String getCodIsin() {
        return codIsin;
    }

    public void setCodIsin(String codIsin) {
        this.codIsin = codIsin;
    }

    public long getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(long idClientes) {
        this.idClientes = idClientes;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("idFondosCliente", idFondosCliente);
        jsonObject.put("codIsin", codIsin);
        jsonObject.put("idClientes", idClientes);
        jsonObject.put("fechaContratacion", fechaContratacion);

        return jsonObject.toString();
    }
}
