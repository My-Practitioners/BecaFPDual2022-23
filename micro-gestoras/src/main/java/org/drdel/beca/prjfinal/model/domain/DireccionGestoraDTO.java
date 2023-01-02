package org.drdel.beca.prjfinal.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.drdel.beca.prjfinal.model.domain.builder.DireccionGestoraDTOBuilder;
import org.json.JSONObject;

import javax.validation.constraints.Size;
import java.util.Date;

public class DireccionGestoraDTO {

    private Long idDireccion;

    private Long idGestora;

    private String direccion;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Size(max = 10)
    private Date audCreaDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Size(max = 20)
    private Date audModDate;

    @Size(max = 20)
    private String audCreaProc;


    @Size(max = 20)
    private String audModProc;

    @Size(max = 20)
    private String audCreaUsu;

    @Size(max = 20)
    private String audModUsu;


    public DireccionGestoraDTO() {
    }

    public DireccionGestoraDTO(Long idDireccion, Long idGestora, String direccion, DireccionGestoraDTOBuilder builder) {
        this.idDireccion = idDireccion;
        this.idGestora = idGestora;
        this.direccion = direccion;
        builder.audCreaDate(audCreaDate);
        builder.audModDate(audModDate);
        builder.audCreaProc(audCreaProc);
        builder.audModProc(audModProc);
        builder.audCreaUsu(audCreaUsu);
        builder.audModUsu(audModUsu);
    }


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

    public String toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("idDireccion" ,getIdDireccion());
        jsonObject.put("idGestora" ,getIdGestora());
        jsonObject.put("direccion" ,getDireccion());
        jsonObject.put("audCreaDate" , getAudCreaDate());
        jsonObject.put("audModDate" , getAudModDate());
        jsonObject.put("audCreaProc" , getAudCreaProc());
        jsonObject.put("audModProc" , getAudModProc());
        jsonObject.put("audCreaUsu" , getAudCreaUsu());
        jsonObject.put("audModUsu" , getAudModUsu());

        return jsonObject.toString();

    }
}
