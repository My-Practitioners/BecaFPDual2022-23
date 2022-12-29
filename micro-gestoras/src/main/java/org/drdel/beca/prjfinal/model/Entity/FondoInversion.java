package org.drdel.beca.prjfinal.model.Entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "T_fondosInversion")
public class FondoInversion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    @Size(max = 10)
    private Date aud_crea_date;


    @Size(max = 20)
    @Temporal(TemporalType.DATE)
    private Date aud_mod_date;

    @Size(max = 20)
    private String aud_crea_proc;

    @Size(max = 20)
    private String aud_mod_proc;

    @Size(max = 20)
    private String aud_crea_usu;

    @Size(max = 20)
    private String aud_mod_usu;




    //getter-setter

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


    //methods
    @PrePersist
    public void prePersist(){
        aud_mod_date=new Date();
    }
}
