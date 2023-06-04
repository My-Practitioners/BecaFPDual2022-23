package org.drdel.beca.prjfinal.micro.gestoras.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

import javax.validation.constraints.Size;
import java.util.Date;

public class DireccionGestoraDTO {
    @JsonProperty("idDireccion")
    private Long idDireccion;

    @JsonProperty("idEstadoDireccionGestora")
    private int idEstadoDireccionGestora;

    @JsonProperty("idGestora")
    private Long idGestora;


    @JsonProperty("direccion")
    private String direccion;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Size(max = 10)
    private Date audCreaDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
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


    public DireccionGestoraDTO(Long idDireccion,int idEstadoDireccionGestora, Long idGestora, String direccion) {
        this.idDireccion=idDireccion;
        this.idEstadoDireccionGestora=idEstadoDireccionGestora;
        this.idGestora=idGestora;
        this.direccion=direccion;
    }

    public DireccionGestoraDTO(DireccionGestoraDTOBuilder builder) {
        this.idDireccion= builder.idDireccion;
        this.idEstadoDireccionGestora=builder.idEstadoDireccionGestora;
        this.idGestora= builder.idGestora;
        this.direccion= builder.direccion;
        this.audCreaDate=builder.audCreaDate;
        this.audModDate=builder.audModDate;
        this.audCreaProc=builder.audCreaProc;
        this.audModProc=builder.audModProc;
        this.audCreaUsu=builder.audCreaUsu;
        this.audModUsu=builder.audModUsu;
    }


    public Long getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Long idDireccion) {
        this.idDireccion = idDireccion;
    }

    public int getIdEstadoDireccionGestora() {
        return idEstadoDireccionGestora;
    }

    public void setIdEstadoDireccionGestora(int idEstadoDireccionGestora) {
        this.idEstadoDireccionGestora = idEstadoDireccionGestora;
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
        jsonObject.put("idEstadoDireccionGestora",getIdEstadoDireccionGestora());
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


    public static class DireccionGestoraDTOBuilder {

        private Long idDireccion;

        private int idEstadoDireccionGestora;

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

        public DireccionGestoraDTOBuilder idDireccion(Long idDireccion){
            this.idDireccion=idDireccion;
            return this;
        }
        public DireccionGestoraDTOBuilder idEstadoDireccionGestora(int idEstadoDireccionGestora){
            this.idEstadoDireccionGestora=idEstadoDireccionGestora;
            return this;
        }
        public DireccionGestoraDTOBuilder idGestora(Long idGestora){
            this.idGestora=idGestora;
            return this;
        }
        public DireccionGestoraDTOBuilder direccion(String direccion){
            this.direccion=direccion;
            return this;
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
