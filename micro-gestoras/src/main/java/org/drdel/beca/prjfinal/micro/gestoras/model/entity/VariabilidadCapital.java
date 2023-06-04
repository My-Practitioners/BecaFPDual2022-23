package org.drdel.beca.prjfinal.micro.gestoras.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_variabilidad_capital")
public class VariabilidadCapital implements Serializable {

    @Id
    @Column(name="cod_variabilidad_capital")
    private String codVariabilidadCapital;

    @Column(name="descripcion")
    private String descripcion;

    @Size(max = 10)
    @Column(name="aud_crea_date")
    private Date audCreaDate;

    @Size(max = 20)
    @Temporal(TemporalType.DATE)
    @Column(name="aud_mod_date")
    private Date audModDate;

    @Size(max = 20)
    @Column(name="aud_crea_proc")
    private String audCreaProc;

    @Size(max = 20)
    @Column(name="aud_mod_proc")
    private String audModProc;

    @Size(max = 20)
    @Column(name="aud_crea_usu")
    private String audCreaUsu;

    @Size(max = 20)
    @Column(name="aud_mod_usu")
    private String audModUsu;


    public String getCodVariabilidadCapital() {
        return codVariabilidadCapital;
    }

    public void setCodVariabilidadCapital(String codVariabilidadCapital) {
        this.codVariabilidadCapital = codVariabilidadCapital;
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

    //se usa para registrar campos que se actualizan,en este caso registra la ultima hora de modificacion
    @PrePersist
    public void prePersist(){
        audModDate =new Date();
    }
}
