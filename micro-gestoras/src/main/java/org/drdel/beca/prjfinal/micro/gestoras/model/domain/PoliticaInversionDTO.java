package org.drdel.beca.prjfinal.micro.gestoras.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class PoliticaInversionDTO implements Serializable {

    @JsonProperty("codPinversion")
    private String codPinversion;

    @JsonProperty("idEstadoPoliticaInversion")
    private int idEstadoPoliticaInversion;

    @JsonProperty("descripcion")
    private String descripcion;

    @JsonProperty("audCreaDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Size(max = 10)
    private Date audCreaDate;

    @JsonProperty("audModDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Size(max = 20)
    private Date audModDate;

    @JsonProperty("audCreaProc")
    @Size(max = 20)
    private String audCreaProc;


    @JsonProperty("audModProc")
    @Size(max = 20)
    private String audModProc;

    @JsonProperty("audCreaUsu")
    @Size(max = 20)
    private String audCreaUsu;

    @JsonProperty("audModUsu")
    @Size(max = 20)
    private String audModUsu;


    public PoliticaInversionDTO(String codPinversion, int idEstadoPoliticaInversion, String descripcion) {
        this.codPinversion = codPinversion;
        this.idEstadoPoliticaInversion = idEstadoPoliticaInversion;
        this.descripcion = descripcion;
    }

    public PoliticaInversionDTO(PoliticaInversionDTOBuilder builder) {
        this.codPinversion=builder.codPinversion;
        this.idEstadoPoliticaInversion=builder.idEstadoPoliticaInversion;
        this.descripcion=builder.descripcion;
        this.audCreaDate=builder.audCreaDate;
        this.audModDate=builder.audModDate;
        this.audCreaProc=builder.audCreaProc;
        this.audModProc=builder.audModProc;
        this.audCreaUsu=builder.audCreaUsu;
        this.audModUsu=builder.audModUsu;
    }

    public String getCodPinversion() {
        return codPinversion;
    }

    public void setCodPinversion(String codPinversion) {
        this.codPinversion = codPinversion;
    }

    public int getIdEstadoPoliticaInversion() {return idEstadoPoliticaInversion;}

    public void setIdEstadoPoliticaInversion(int idEstadoPoliticaInversion) {this.idEstadoPoliticaInversion = idEstadoPoliticaInversion;}

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


    //method
    public String toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("codPinversion" ,codPinversion);
        jsonObject.put("idEstadoPoliticaInversion" ,idEstadoPoliticaInversion);
        jsonObject.put("descripcion" ,descripcion);
        jsonObject.put("audCreaDate" , audCreaDate);
        jsonObject.put("audModDate" , audModDate);
        jsonObject.put("audCreaProc" , audCreaProc);
        jsonObject.put("audModProc" , audModProc);
        jsonObject.put("audCreaUsu" , audCreaUsu);
        jsonObject.put("audModUsu" , audModUsu);

        return jsonObject.toString();
    }

    public static class PoliticaInversionDTOBuilder {
        private String codPinversion;
        private int idEstadoPoliticaInversion;
        private String descripcion;
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


        public PoliticaInversionDTO.PoliticaInversionDTOBuilder codPinversion(String codPinversion) {
            this.codPinversion = codPinversion;
            return this;
        }

        public PoliticaInversionDTO.PoliticaInversionDTOBuilder idEstadoPoliticaInversion(int idEstadoPoliticaInversion) {
            this.idEstadoPoliticaInversion = idEstadoPoliticaInversion;
            return this;
        }

        public PoliticaInversionDTO.PoliticaInversionDTOBuilder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public PoliticaInversionDTO.PoliticaInversionDTOBuilder audCreaDate(Date audCreaDate) {
            this.audCreaDate = audCreaDate;
            return this;
        }

        public PoliticaInversionDTO.PoliticaInversionDTOBuilder audModDate(Date audModDate) {
            this.audModDate = audModDate;
            return this;
        }

        public PoliticaInversionDTO.PoliticaInversionDTOBuilder audCreaProc(String audCreaProc) {
            this.audCreaProc = audCreaProc;
            return this;
        }

        public PoliticaInversionDTO.PoliticaInversionDTOBuilder audModProc(String audModProc) {
            this.audModProc = audModProc;
            return this;
        }

        public PoliticaInversionDTO.PoliticaInversionDTOBuilder audCreaUsu(String audCreaUsu) {
            this.audCreaUsu = audCreaUsu;
            return this;
        }

        public PoliticaInversionDTO.PoliticaInversionDTOBuilder audModUsu(String audModUsu) {
            this.audModUsu = audModUsu;
            return this;
        }

        public PoliticaInversionDTO build() {return new PoliticaInversionDTO(this);}

    }

}
