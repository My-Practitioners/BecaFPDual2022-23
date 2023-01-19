package org.drdel.beca.prjfinal.micro.gestoras.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_gestora_fondos")
public class Gestora implements Serializable {

    @Id
    @Column(name = "id_gestora")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGestora;

    @Column(name = "id_estado_gestora")
    private Long idEstadoGestora;

    @Column(name = "nombre")
    @NotBlank
    private String nombre;

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



    public long getIdGestora() {
        return idGestora;
    }

    public void setIdGestora(long idGestora) {
        this.idGestora = idGestora;
    }

    public Long getIdEstadoGestora() {
        return idEstadoGestora;
    }

    public void setIdEstadoGestora(Long idEstadoGestora) {
        this.idEstadoGestora = idEstadoGestora;
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


    //methods

    @PrePersist
    public void prePersist(){
        audModDate =new Date();
    }
}
