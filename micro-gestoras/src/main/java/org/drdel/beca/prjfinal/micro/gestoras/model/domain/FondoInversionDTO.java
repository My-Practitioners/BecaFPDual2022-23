package org.drdel.beca.prjfinal.micro.gestoras.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

import javax.validation.constraints.Size;
import java.util.Date;

public class FondoInversionDTO {

    @JsonProperty("codIsin")
    private String codIsin;

    @JsonProperty("idEstadoFondoInversion")
    private int idEstadoFondoInversion;

    @JsonProperty("codEuropeo")
    private String codEuropeo;

    @JsonProperty("codLei")
    private String codLei;

    @JsonProperty("nombreFondo")
    private String nombreFondo;

    @JsonProperty("idGestora")
    private Long idGestora;

    @JsonProperty("idDireccion")
    private Long idDireccion;

    @JsonProperty("codPInversion")
    private String codPInversion;

    @JsonProperty("codVariabilidadCapital")
    private String codVariabilidadCapital;

    @JsonProperty("subFondo")
    private String subFondo;

    @JsonProperty("codSupervisor")
    private String codSupervisor;

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

    public FondoInversionDTO(String codIsin, int idEstadoFondoInversion, String codEuropeo, String codLei, String nombreFondo, Long idGestora, Long idDireccion, String codPInversion, String codVariabilidadCapital, String subFondo, String codSupervisor) {
        this.codIsin = codIsin;
        this.idEstadoFondoInversion = idEstadoFondoInversion;
        this.codEuropeo = codEuropeo;
        this.codLei = codLei;
        this.nombreFondo = nombreFondo;
        this.idGestora = idGestora;
        this.idDireccion = idDireccion;
        this.codPInversion = codPInversion;
        this.codVariabilidadCapital = codVariabilidadCapital;
        this.subFondo = subFondo;
        this.codSupervisor = codSupervisor;
    }

    public FondoInversionDTO(FondoInversionDTOBuilder builder) {
        this.codIsin = builder.codIsin;
        this.idEstadoFondoInversion = builder.idEstadoFondoInversion;
        this.codEuropeo = builder.codEuropeo;
        this.codLei = builder.codLei;
        this.nombreFondo = builder.nombreFondo;
        this.subFondo = builder.subFondo;
        this.codSupervisor = builder.codSupervisor;
        this.idGestora = builder.idGestora;
        this.idDireccion = builder.idDireccion;
        this.codPInversion = builder.codPInversion;
        this.codVariabilidadCapital = builder.codVariabilidadCapital;
        this.audCreaDate=builder.audCreaDate;
        this.audModDate=builder.audModDate;
        this.audCreaProc=builder.audCreaProc;
        this.audModProc=builder.audModProc;
        this.audCreaUsu=builder.audCreaUsu;
        this.audModUsu=builder.audModUsu;
    }


    public String getCodIsin() {
        return codIsin;
    }

    public void setCodIsin(String codIsin) {
        this.codIsin = codIsin;
    }

    public int getIdEstadoFondoInversion() {return idEstadoFondoInversion;}

    public void setIdEstadoFondoInversion(int idEstadoFondoInversion) {this.idEstadoFondoInversion = idEstadoFondoInversion;}

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

    public void setCodVariabilidadCapital(String codVariabilidadCapital) {this.codVariabilidadCapital = codVariabilidadCapital;}

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

    public String toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("codIsin" ,codIsin);
        jsonObject.put("idEstadoFondoInversion" ,idEstadoFondoInversion);
        jsonObject.put("codEuropeo" ,codEuropeo);
        jsonObject.put("nombreFondo" ,nombreFondo);
        jsonObject.put("idGestora" ,idGestora);
        jsonObject.put("codPInversion" ,codPInversion);
        jsonObject.put("codVariabilidadCapital" ,codVariabilidadCapital);
        jsonObject.put("subFondo" ,subFondo);
        jsonObject.put("codSupervisor" ,codSupervisor);
        jsonObject.put("audCreaDate" , audCreaDate);
        jsonObject.put("audModDate" , audModDate);
        jsonObject.put("audCreaProc" , audCreaProc);
        jsonObject.put("audModProc" , audModProc);
        jsonObject.put("audCreaUsu" , audCreaUsu);
        jsonObject.put("audModUsu" , audModUsu);

        return jsonObject.toString();
    }

    public static class FondoInversionDTOBuilder {

        private String codIsin;

        private int idEstadoFondoInversion;

        private String codEuropeo;

        private String codLei;

        private String nombreFondo;

        private Long idGestora;

        private Long idDireccion;

        private String codPInversion;

        private String codVariabilidadCapital;

        private String subFondo;

        private String codSupervisor;
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

        public FondoInversionDTO.FondoInversionDTOBuilder codIsin(String codIsin) {
            this.codIsin = codIsin;
            return this;
        }

        public FondoInversionDTO.FondoInversionDTOBuilder idEstadoFondoInversion(int idEstadoFondoInversion) {
            this.idEstadoFondoInversion = idEstadoFondoInversion;
            return this;
        }

        public FondoInversionDTO.FondoInversionDTOBuilder codEuropeo(String codEuropeo) {
            this.codEuropeo = codEuropeo;
            return this;
        }

        public FondoInversionDTO.FondoInversionDTOBuilder codLei(String codLei) {
            this.codLei = codLei;
            return this;
        }

        public FondoInversionDTO.FondoInversionDTOBuilder nombreFondo(String nombreFondo) {
            this.nombreFondo = nombreFondo;
            return this;
        }

        public FondoInversionDTO.FondoInversionDTOBuilder idGestora(Long idGestora) {
            this.idGestora = idGestora;
            return this;
        }

        public FondoInversionDTO.FondoInversionDTOBuilder idDireccion(Long idDireccion) {
            this.idDireccion = idDireccion;
            return this;
        }

        public FondoInversionDTO.FondoInversionDTOBuilder codPInversion(String codPInversion) {
            this.codPInversion = codPInversion;
            return this;
        }

        public FondoInversionDTO.FondoInversionDTOBuilder codVariabilidadCapital(String codVariabilidadCapital) {
            this.codVariabilidadCapital = codVariabilidadCapital;
            return this;
        }

        public FondoInversionDTO.FondoInversionDTOBuilder subFondo(String subFondo) {
            this.subFondo = subFondo;
            return this;
        }

        public FondoInversionDTO.FondoInversionDTOBuilder codSupervisor(String codSupervisor) {
            this.codSupervisor = codSupervisor;
            return this;
        }

        public FondoInversionDTO.FondoInversionDTOBuilder audCreaDate(Date audCreaDate) {
            this.audCreaDate = audCreaDate;
            return this;
        }

        public FondoInversionDTO.FondoInversionDTOBuilder audModDate(Date audModDate) {
            this.audModDate = audModDate;
            return this;
        }

        public FondoInversionDTO.FondoInversionDTOBuilder audCreaProc(String audCreaProc) {
            this.audCreaProc = audCreaProc;
            return this;
        }

        public FondoInversionDTO.FondoInversionDTOBuilder audModProc(String audModProc) {
            this.audModProc = audModProc;
            return this;
        }

        public FondoInversionDTO.FondoInversionDTOBuilder audCreaUsu(String audCreaUsu) {
            this.audCreaUsu = audCreaUsu;
            return this;
        }

        public FondoInversionDTO.FondoInversionDTOBuilder audModUsu(String audModUsu) {
            this.audModUsu = audModUsu;
            return this;
        }

        public FondoInversionDTO build() {return new FondoInversionDTO(this);}

    }
}
