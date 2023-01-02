package org.drdel.beca.prjfinal.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.drdel.beca.prjfinal.model.domain.builder.GestoraDTOBuilder;
import org.json.JSONObject;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;


public class GestoraDTO {

    private long idGestora;

    @NotBlank
    private String nombre;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Size(max = 10)
    private Date audCreaDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Size(max = 20)
    private Date audModDate;

    @Size(max = 20)
    private String audCreaProc;


    @Size(max = 20)
    private String audModProc;

    @Size(max = 20)
    private String audCreaUsu;

    @Size(max = 20)
    private String audModUsu;



    public GestoraDTO() {
    }

    public GestoraDTO(long idGestora, String nombre, GestoraDTOBuilder builder) {
        this.idGestora=idGestora;
        this.nombre=nombre;
        builder.audCreaDate(audCreaDate);
        builder.audModDate(audModDate);
        builder.audCreaProc(audCreaProc);
        builder.audModProc(audModProc);
        builder.audCreaUsu(audCreaUsu);
        builder.audModUsu(audModUsu);
    }



    public long getIdGestora() {
        return idGestora;
    }

    public void setIdGestora(long idGestora) {
        this.idGestora = idGestora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getAudCreaDate() {
        return audCreaDate;
    }

    public void setAudCreaDate(Date audCreaDate) {
        this.audCreaDate = audCreaDate;
    }

    public Date getAudModDate() {
        return audModDate;
    }

    public void setAudModDate(Date audModDate) {
        this.audModDate = audModDate;
    }

    public String getAudCreaProc() {
        return audCreaProc;
    }

    public void setAudCreaProc(String audCreaProc) {
        this.audCreaProc = audCreaProc;
    }

    public String getAudModProc() {
        return audModProc;
    }

    public void setAudModProc(String audModProc) {
        this.audModProc = audModProc;
    }

    public String getAudCreaUsu() {
        return audCreaUsu;
    }

    public void setAudCreaUsu(String audCreaUsu) {
        this.audCreaUsu = audCreaUsu;
    }

    public String getAudModUsu() {
        return audModUsu;
    }

    public void setAudModUsu(String audModUsu) {
        this.audModUsu = audModUsu;
    }


    public String toJSON() {

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("idGestora",idGestora);
        jsonObject.put("nombre",nombre);
        jsonObject.put("audCreaDate", audCreaDate);
        jsonObject.put("audModDate", audModDate);
        jsonObject.put("audCreaProc", audCreaProc);
        jsonObject.put("audModProc", audModProc);
        jsonObject.put("audCreaUsu", audCreaUsu);
        jsonObject.put("audModUsu", audModUsu);

        return jsonObject.toString();

    }
}
