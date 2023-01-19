package org.drdel.beca.prjfinal.micro.gestoras.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.json.JSONObject;

import javax.validation.constraints.Size;
import java.util.Date;

public class DireccionGestoraDTO {

    private Long idDireccion;

    private Long idGestora;

    private Long idEstadoDireccionGestora;

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


    public DireccionGestoraDTO(Long idDireccion, Long idGestora,Long idEstadoDireccionGestora, String direccion) {
        this.idDireccion=idDireccion;
        this.idGestora=idGestora;
        this.idEstadoDireccionGestora=idEstadoDireccionGestora;
        this.direccion=direccion;
    }

    public DireccionGestoraDTO(DireccionGestoraDTOBuilder builder) {
        this.idDireccion= builder.idDireccion;
        this.idGestora= builder.idGestora;
        this.idEstadoDireccionGestora=builder.idEstadoDireccionGestora;
        this.direccion= builder.direccion;
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

    public Long getIdEstadoDireccionGestora() {
        return idEstadoDireccionGestora;
    }

    public void setIdEstadoDireccionGestora(Long idEstadoDireccionGestora) {
        this.idEstadoDireccionGestora = idEstadoDireccionGestora;
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
        jsonObject.put("idEstadoDireccionGestora",getIdEstadoDireccionGestora());
        jsonObject.put("direccion" ,getDireccion());
        jsonObject.put("audCreaDate" , getAudCreaDate());
        jsonObject.put("audModDate" , getAudModDate());
        jsonObject.put("audCreaProc" , getAudCreaProc());
        jsonObject.put("audModProc" , getAudModProc());
        jsonObject.put("audCreaUsu" , getAudCreaUsu());
        jsonObject.put("audModUsu" , getAudModUsu());

        return jsonObject.toString();
    }


    public static class DireccionGestoraDTOBuilder {

        private Long idDireccion;

        private Long idGestora;

        private Long idEstadoDireccionGestora;

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

        public DireccionGestoraDTOBuilder (Long idDireccion, Long idGestora,Long idEstadoDireccionGestora, String direccion){
            this.idDireccion=idDireccion;
            this.idGestora=idGestora;
            this.idEstadoDireccionGestora=idEstadoDireccionGestora;
            this.direccion=direccion;
        }
        public DireccionGestoraDTOBuilder audCreaDate(Date audCreaDate){
            this.audCreaDate=audCreaDate;
            return this;
        }
        public DireccionGestoraDTOBuilder audModDate(Date audModDate){
            this.audModDate=audModDate;
            return this;
        }
        public DireccionGestoraDTOBuilder audCreaProc(String audCreaProc){
            this.audCreaProc=audCreaProc;
            return this;
        }
        public DireccionGestoraDTOBuilder audModProc(String audModProc){
            this.audModProc=audModProc;
            return this;
        }
        public DireccionGestoraDTOBuilder audCreaUsu(String audCreaUsu){
            this.audCreaUsu=audCreaUsu;
            return this;
        }
        public DireccionGestoraDTOBuilder audModUsu(String audModUsu){
            this.audModUsu=audModUsu;
            return this;
        }
        public DireccionGestoraDTO build(){
            return new DireccionGestoraDTO(this);
        }
    }
}
