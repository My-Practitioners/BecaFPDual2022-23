package org.drdel.beca.prjfinal.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.json.JSONObject;

import javax.validation.constraints.Size;
import java.util.Date;

public class FondoInversionDTO {

    private String codIsin;

    private String codEuropeo;

    private String codLei;

    private String nombreFondo;

    private Long idGestora;

    private Long idDireccion;

    private String codPInversion;

    private String codVariabilidadCapital;

    private String subFondo;

    private String codSupervisor;

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

    public FondoInversionDTO() {
    }

    public FondoInversionDTO(String codIsin, String codEuropeo, String codLei, String nombreFondo, Long idGestora, Long idDireccion, String codPInversion, String codVariabilidadCapital, String subFondo, String codSupervisor, Date aud_crea_date, Date aud_mod_date, String aud_crea_proc, String aud_mod_proc, String aud_crea_usu, String aud_mod_usu) {
        this.codIsin = codIsin;
        this.codEuropeo = codEuropeo;
        this.codLei = codLei;
        this.nombreFondo = nombreFondo;
        this.idGestora = idGestora;
        this.idDireccion = idDireccion;
        this.codPInversion = codPInversion;
        this.codVariabilidadCapital = codVariabilidadCapital;
        this.subFondo = subFondo;
        this.codSupervisor = codSupervisor;
        this.aud_crea_date = aud_crea_date;
        this.aud_mod_date = aud_mod_date;
        this.aud_crea_proc = aud_crea_proc;
        this.aud_mod_proc = aud_mod_proc;
        this.aud_crea_usu = aud_crea_usu;
        this.aud_mod_usu = aud_mod_usu;
    }


    //SET-GET


    public String getCodIsin() {
        return codIsin;
    }

    public void setCodIsin(String codIsin) {
        this.codIsin = codIsin;
    }

    public String getCodEuropeo() {
        return codEuropeo;
    }

    public void setCodEuropeo(String codEuropeo) {
        this.codEuropeo = codEuropeo;
    }

    public String getCodLei() {
        return codLei;
    }

    public void setCodLei(String codLei) {
        this.codLei = codLei;
    }

    public String getNombreFondo() {
        return nombreFondo;
    }

    public void setNombreFondo(String nombreFondo) {
        this.nombreFondo = nombreFondo;
    }

    public Long getIdGestora() {
        return idGestora;
    }

    public void setIdGestora(Long idGestora) {
        this.idGestora = idGestora;
    }

    public Long getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Long idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCodPInversion() {
        return codPInversion;
    }

    public void setCodPInversion(String codPInversion) {
        this.codPInversion = codPInversion;
    }

    public String getCodVariabilidadCapital() {
        return codVariabilidadCapital;
    }

    public void setCodVariabilidadCapital(String codVariabilidadCapital) {
        this.codVariabilidadCapital = codVariabilidadCapital;
    }

    public String getSubFondo() {
        return subFondo;
    }

    public void setSubFondo(String subFondo) {
        this.subFondo = subFondo;
    }

    public String getCodSupervisor() {
        return codSupervisor;
    }

    public void setCodSupervisor(String codSupervisor) {
        this.codSupervisor = codSupervisor;
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

    public String toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("codIsin" ,codIsin);
        jsonObject.put("codEuropeo" ,codEuropeo);
        jsonObject.put("nombreFondo" ,nombreFondo);
        jsonObject.put("idGestora" ,idGestora);
        jsonObject.put("codPInversion" ,codPInversion);
        jsonObject.put("codVariabilidadCapital" ,codVariabilidadCapital);
        jsonObject.put("subFondo" ,subFondo);
        jsonObject.put("codSupervisor" ,codSupervisor);
        jsonObject.put("aud_crea_date" ,aud_crea_date);
        jsonObject.put("aud_mod_date" ,aud_mod_date);
        jsonObject.put("aud_crea_proc" ,aud_crea_proc);
        jsonObject.put("aud_mod_proc" ,aud_mod_proc);
        jsonObject.put("aud_crea_usu" ,aud_crea_usu);
        jsonObject.put("aud_mod_usu" ,aud_mod_usu);

        return jsonObject.toString();
    }

}
