package org.drdel.beca.prjfinal.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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




    //CONSTRUCTOR


    public GestoraDTO() {
    }

    public GestoraDTO(long idGestora, String nombre, Date audCreaDate, Date audModDate, String audCreaProc, String audModProc, String audCreaUsu, String audModUsu) {
        this.idGestora = idGestora;
        this.nombre = nombre;
        this.audCreaDate = audCreaDate;
        this.audModDate = audModDate;
        this.audCreaProc = audCreaProc;
        this.audModProc = audModProc;
        this.audCreaUsu = audCreaUsu;
        this.audModUsu = audModUsu;
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
        jsonObject.put("id_Gestora",idGestora);
        jsonObject.put("nombre",nombre);
        jsonObject.put("AUD_CREA_DATE", audCreaDate);
        jsonObject.put("AUD_MOD_DATE", audModDate);
        jsonObject.put("AUD_CREA_PROC", audCreaProc);
        jsonObject.put("AUD_MOD_PROC", audModProc);
        jsonObject.put("AUD_CREA_USU", audCreaUsu);
        jsonObject.put("AUD_MOD_USU", audModUsu);

        return jsonObject.toString();

    }
}
