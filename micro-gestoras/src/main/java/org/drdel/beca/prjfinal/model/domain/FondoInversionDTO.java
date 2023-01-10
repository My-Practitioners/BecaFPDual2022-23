package org.drdel.beca.prjfinal.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.json.JSONObject;

import javax.validation.constraints.Size;
import java.util.Date;

public class FondoInversionDTO {

    private String codIsin;

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

    public FondoInversionDTO(String codIsin, String codEuropeo, String codLei, String nombreFondo, Long idGestora, Long idDireccion, String codPInversion, String codVariabilidadCapital, String subFondo, String codSupervisor) {
        this.codIsin = codIsin;
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
        this.codIsin = codIsin;
        this.codEuropeo = codEuropeo;
        this.codLei = codLei;
        this.nombreFondo = nombreFondo;
        this.subFondo = subFondo;
        this.codSupervisor = codSupervisor;
        this.idGestora = idGestora;
        this.idDireccion = idDireccion;
        this.codPInversion = codPInversion;
        this.codVariabilidadCapital = codVariabilidadCapital;
        builder.audCreaDate(audCreaDate);
        builder.audModDate(audModDate);
        builder.audCreaProc(audCreaProc);
        builder.audModProc(audModProc);
        builder.audCreaUsu(audCreaUsu);
        builder.audModUsu(audModUsu);
    }


    public String getCodIsin() {
        return codIsin;
    }

    public void setCodIsin(String codIsin) {
        this.codIsin = codIsin;
    }

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

    public void setCodVariabilidadCapital(String codVariabilidadCapital) {
        this.codVariabilidadCapital = codVariabilidadCapital;
    }

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

    public class FondoInversionDTOBuilder {

        private String codIsin;

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

        public FondoInversionDTOBuilder(String codIsin, String codEuropeo, String codLei, String nombreFondo, Long idGestora, Long idDireccion, String codPInversion, String codVariabilidadCapital, String subFondo, String codSupervisor) {
            this.codIsin = codIsin;
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
