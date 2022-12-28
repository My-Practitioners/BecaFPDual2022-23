package org.drdel.beca.prjfinal.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String AudModProc;

    @Size(max = 20)
    private String audCreaUsu;

    @Size(max = 20)
    private String audModUsu;


    //CONSTRUCTOR
    public DireccionGestoraDTO() {
    }

    public DireccionGestoraDTO(Long idDireccion, Long idGestora, String direccion, Date AudCreaDate, Date audModDate, String audCreaProc, String AudModProc, String audCreaUsu, String audModUsu) {
        this.idDireccion = idDireccion;
        this.idGestora = idGestora;
        this.direccion = direccion;
        this.audCreaDate = AudCreaDate;
        this.audModDate = audModDate;
        this.audCreaProc = audCreaProc;
        this.AudModProc = AudModProc;
        this.audCreaUsu = audCreaUsu;
        this.audModUsu = audModUsu;
    }


    //SET-GET
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
        return AudModProc;
    }

    public void setAudModProc(String audModProc) {
        this.AudModProc = audModProc;
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
        jsonObject.put("idDireccion" ,idDireccion);
        jsonObject.put("idGestora" ,idGestora);
        jsonObject.put("direccion" ,direccion);
        jsonObject.put("audCreaDate" , audCreaDate);
        jsonObject.put("audModDate" , audModDate);
        jsonObject.put("audCreaProc" , audCreaProc);
        jsonObject.put("audModProc" , AudModProc);
        jsonObject.put("audCreaUsu" , audCreaUsu);
        jsonObject.put("audModUsu" , audModUsu);

        return jsonObject.toString();

    }
}
