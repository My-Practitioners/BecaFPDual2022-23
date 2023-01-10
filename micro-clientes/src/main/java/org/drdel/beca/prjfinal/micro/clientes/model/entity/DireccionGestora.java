package org.drdel.beca.prjfinal.micro.clientes.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_direccion_gestoras")
public class DireccionGestora implements Serializable {

    @Id
    @Column(name = "id_direccion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDireccion;

    @Column(name = "id_gestora")
    private Long idGestora;

    @Column(name = "direccion")
    private String direccion;

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


    public Long getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Long idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Long getIdGestora() {
        return idGestora;
    }

    public void setIdGestora(Long idGestora) {
        this.idGestora = idGestora;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    //method
    @PrePersist
    public void prePersist(){
        audModDate =new Date();
    }
}
