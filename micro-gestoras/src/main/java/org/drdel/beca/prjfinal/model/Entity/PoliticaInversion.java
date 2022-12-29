package org.drdel.beca.prjfinal.model.Entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "T_politicaInversion")
public class PoliticaInversion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codPinversion;

    private String descripcion;


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


    //GETER-SETTER

    public String getCodPinversion() {
        return codPinversion;
    }

    public void setCodPinversion(String codPinversion) {
        this.codPinversion = codPinversion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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


    //METHODS
    @PrePersist
    public void prePersist(){
        aud_mod_date=new Date();
    }
}

