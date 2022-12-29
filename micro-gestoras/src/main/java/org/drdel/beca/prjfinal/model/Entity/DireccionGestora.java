package org.drdel.beca.prjfinal.model.Entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "T_direccionGestoras")
public class DireccionGestora implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDireccion;

    private Long idGestora;

    private String direccion;


    @Size(max = 10)
    private Date audCreaDate;


    @Size(max = 20)
    @Temporal(TemporalType.DATE)
    private Date audModDate;

    @Size(max = 20)
    private String audCreaProc;


    @Size(max = 20)
    private String audModProc;

    @Size(max = 20)
    private String audCreaUsu;

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
