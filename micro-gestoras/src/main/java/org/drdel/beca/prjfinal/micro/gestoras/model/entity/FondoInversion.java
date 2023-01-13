package org.drdel.beca.prjfinal.micro.gestoras.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_fondos_inversion")
public class FondoInversion implements Serializable {

    @Id
    @Column(name = "cod_isin")
    private String codIsin;

    @Column(name = "cod_europeo")
    private String codEuropeo;

    @Column(name = "cod_lei")
    private String codLei;

    @Column(name = "nombre_fondo")
    private String nombreFondo;

    @Column(name = "id_gestora")
    private Long idGestora;

    @Column(name = "id_direccion")
    private Long idDireccion;

    @Column(name = "cod_p_inversion")
    private String codPInversion;

    @Column(name = "cod_variabilidad_capital")
    private String codVariabilidadCapital;

    @Column(name = "sub_fondo")
    private String subFondo;

    @Column(name = "cod_supervisor")
    private String codSupervisor;

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


    //methods
    @PrePersist
    public void prePersist(){
        audModDate =new Date();
    }
}
