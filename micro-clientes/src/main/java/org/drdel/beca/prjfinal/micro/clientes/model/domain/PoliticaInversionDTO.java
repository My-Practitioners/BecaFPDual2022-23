package org.drdel.beca.prjfinal.micro.clientes.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.json.JSONObject;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class PoliticaInversionDTO implements Serializable {

    private String codPinversion;

    private String descripcion;

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


    public PoliticaInversionDTO(String codPinversion, String descripcion) {
        this.codPinversion = codPinversion;
        this.descripcion = descripcion;
    }

    public PoliticaInversionDTO(PoliticaInversionDTOBuilder builder) {
        this.codPinversion=builder.codPinversion;
        this.descripcion=builder.descripcion;
        builder.audCreaDate(audCreaDate);
        builder.audModDate(audModDate);
        builder.audCreaProc(audCreaProc);
        builder.audModProc(audModProc);
        builder.audCreaUsu(audCreaUsu);
        builder.audModUsu(audModUsu);
    }

    public String getCodPinversion() {
        return codPinversion;
    }

    public void setCodPinversion(String codPinversion) {
        this.codPinversion = codPinversion;
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


    //method
    public String toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("codPinversion" ,codPinversion);
        jsonObject.put("descripcion" ,descripcion);
        jsonObject.put("audCreaDate" , audCreaDate);
        jsonObject.put("audModDate" , audModDate);
        jsonObject.put("audCreaProc" , audCreaProc);
        jsonObject.put("audModProc" , audModProc);
        jsonObject.put("audCreaUsu" , audCreaUsu);
        jsonObject.put("audModUsu" , audModUsu);

        return jsonObject.toString();
    }

    public class PoliticaInversionDTOBuilder {
        private String codPinversion;
        private String descripcion;
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

        public PoliticaInversionDTOBuilder(String codPinversion, String descripcion) {
            this.codPinversion = codPinversion;
            this.descripcion = descripcion;
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
