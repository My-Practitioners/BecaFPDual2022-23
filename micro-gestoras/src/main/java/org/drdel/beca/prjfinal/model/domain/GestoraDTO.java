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
    private Date aud_crea_date;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Size(max = 20)
    private Date aud_mod_date;

    @Size(max = 20)
    private String aud_crea_proc;


    @Size(max = 20)
    private String aud_mod_proc;

    @Size(max = 20)
    private String aud_crea_usu;

    @Size(max = 20)
    private String aud_mod_usu;




    //CONSTRUCTOR


    public GestoraDTO() {
    }

    public GestoraDTO(long idGestora, String nombre, Date aud_crea_date, Date aud_mod_date, String aud_crea_proc, String aud_mod_proc, String aud_crea_usu, String aud_mod_usu) {
        this.idGestora = idGestora;
        this.nombre = nombre;
        this.aud_crea_date = aud_crea_date;
        this.aud_mod_date = aud_mod_date;
        this.aud_crea_proc = aud_crea_proc;
        this.aud_mod_proc = aud_mod_proc;
        this.aud_crea_usu = aud_crea_usu;
        this.aud_mod_usu = aud_mod_usu;
    }


    //GET-SET


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

    public Date getAud_crea_date() {
        return aud_crea_date;
    }

    public void setAud_crea_date(Date aud_crea_date) {
        this.aud_crea_date = aud_crea_date;
    }

    public Date getAud_mod_date() {
        return aud_mod_date;
    }

    public void setAud_mod_date(Date aud_mod_date) {
        this.aud_mod_date = aud_mod_date;
    }

    public String getAud_crea_proc() {
        return aud_crea_proc;
    }

    public void setAud_crea_proc(String aud_crea_proc) {
        this.aud_crea_proc = aud_crea_proc;
    }

    public String getAud_mod_proc() {
        return aud_mod_proc;
    }

    public void setAud_mod_proc(String aud_mod_proc) {
        this.aud_mod_proc = aud_mod_proc;
    }

    public String getAud_crea_usu() {
        return aud_crea_usu;
    }

    public void setAud_crea_usu(String aud_crea_usu) {
        this.aud_crea_usu = aud_crea_usu;
    }

    public String getAud_mod_usu() {
        return aud_mod_usu;
    }

    public void setAud_mod_usu(String aud_mod_usu) {
        this.aud_mod_usu = aud_mod_usu;
    }



    public String toJSON() {

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("id_Gestora",idGestora);
        jsonObject.put("nombre",nombre);
        jsonObject.put("AUD_CREA_DATE",aud_crea_date);
        jsonObject.put("AUD_MOD_DATE",aud_mod_date);
        jsonObject.put("AUD_CREA_PROC",aud_crea_proc);
        jsonObject.put("AUD_MOD_PROC",aud_mod_proc);
        jsonObject.put("AUD_CREA_USU",aud_crea_usu);
        jsonObject.put("AUD_MOD_USU",aud_mod_usu);

        return jsonObject.toString();
        /*return "{\n  \"entity\" : {\n    " +
                "\"id_Gestora\" :"+ idGestora +",\n" +
                "    \"nombre\" :"+ nombre +",\n   " +
                "\"AUD_CREA_DATE\" :"+ aud_crea_date +",\n    " +
                "\"AUD_MOD_DATE\" :"+ aud_mod_date +",\n    " +
                "\"AUD_CREA_PROC\" :"+ aud_crea_proc +",\n   " +
                "\"AUD_MOD_PROC\" :"+ aud_mod_proc +",\n    " +
                "\"AUD_CREA_USU\" :"+ aud_crea_usu +",\n    " +
                "\"AUD_MOD_USU\" :"+ aud_mod_usu +"    }\n}";*/


    }
}
