package org.drdel.beca.prjfinal.micro.gestoras.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.json.JSONObject;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;


public class GestoraDTO {
    private Long idGestora;

    private Long idEstadoGestora;

    @NotBlank
    private String nombre;

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

    public GestoraDTO(Long idGestora,Long idEstadoGestora, String nombre) {
        this.idGestora=idGestora;
        this.idEstadoGestora=idEstadoGestora;
        this.nombre=nombre;
    }

    public GestoraDTO(GestoraDTOBuilder builder) {
        this.idGestora=builder.idGestora;
        this.idEstadoGestora=builder.idEstadoGestora;
        this.nombre=builder.nombre;
        builder.audCreaDate(audCreaDate);
        builder.audModDate(audModDate);
        builder.audCreaProc(audCreaProc);
        builder.audModProc(audModProc);
        builder.audCreaUsu(audCreaUsu);
        builder.audModUsu(audModUsu);
    }

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


    public String toJSON() {

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("idGestora",idGestora);
        jsonObject.put("idEstadoGestora",idEstadoGestora);
        jsonObject.put("nombre",nombre);
        jsonObject.put("audCreaDate", audCreaDate);
        jsonObject.put("audModDate", audModDate);
        jsonObject.put("audCreaProc", audCreaProc);
        jsonObject.put("audModProc", audModProc);
        jsonObject.put("audCreaUsu", audCreaUsu);
        jsonObject.put("audModUsu", audModUsu);

        return jsonObject.toString();

    }

    public static class GestoraDTOBuilder {
        private Long idGestora;
        private Long idEstadoGestora;
        private String nombre;
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

        public GestoraDTOBuilder(Long idGestora, Long idEstadoGestora, String nombre) {
            this.idGestora = idGestora;
            this.idEstadoGestora=idEstadoGestora;
            this.nombre = nombre;
        }

        public GestoraDTOBuilder audCreaDate(Date audCreaDate) {
            this.audCreaDate = audCreaDate;
            return this;
        }

        public GestoraDTOBuilder audModDate(Date audModDate) {
            this.audModDate = audModDate;
            return this;
        }

        public GestoraDTOBuilder audCreaProc(String audCreaProc) {
            this.audCreaProc = audCreaProc;
            return this;
        }

        public GestoraDTOBuilder audModProc(String audModProc) {
            this.audModProc = audModProc;
            return this;
        }

        public GestoraDTOBuilder audCreaUsu(String audCreaUsu) {
            this.audCreaUsu = audCreaUsu;
            return this;
        }

        public GestoraDTOBuilder audModUsu(String audModUsu) {
            this.audModUsu = audModUsu;
            return this;
        }

        public GestoraDTO build() {
            return new GestoraDTO(this);
        }
    }

}
