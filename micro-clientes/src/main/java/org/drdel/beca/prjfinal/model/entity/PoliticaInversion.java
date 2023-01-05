package org.drdel.beca.prjfinal.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_politica_inversion")
public class PoliticaInversion implements Serializable {

    @Id
    @Column(name = "cod_p_inversion")
    private String codPinversion;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "aud_crea_date")
    @Size(max = 10)
    private Date audCreaDate;

    @Column(name = "aud_mod_date")
    @Size(max = 20)
    @Temporal(TemporalType.DATE)
    private Date audModDate;

    @Column(name = "aud_crea_proc")
    @Size(max = 20)
    private String audCreaProc;

    @Column(name = "aud_mod_proc")
    @Size(max = 20)
    private String audModProc;

    @Column(name = "aud_crea_usu")
    @Size(max = 20)
    private String audCreaUsu;

    @Column(name = "aud_mod_usu")
    @Size(max = 20)
    private String audModUsu;



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


    @PrePersist
    public void prePersist(){
        audModDate =new Date();
    }
}
