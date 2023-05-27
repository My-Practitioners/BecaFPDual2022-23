package org.drdel.beca.prjfinal.micro.gestoras.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;


public class GestoraDTO {
    @JsonProperty("idGestora")
    private Long idGestora;

    @JsonProperty("idEstadoGestora")
    private int idEstadoGestora;

    @NotBlank
    @JsonProperty("nombre")
    private String nombre;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Size(max = 10)
    @JsonProperty("audCreaDate")
    private Date audCreaDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Size(max = 20)
    @JsonProperty("audModDate")
    private Date audModDate;

    @Size(max = 20)
    @JsonProperty("audCreaProc")
    private String audCreaProc;

    @Size(max = 20)
    @JsonProperty("audModProc")
    private String audModProc;

    @Size(max = 20)
    @JsonProperty("audCreaUsu")
    private String audCreaUsu;

    @Size(max = 20)
    @JsonProperty("audModUsu")
    private String audModUsu;

    public GestoraDTO(Long idGestora,int idEstadoGestora, String nombre) {
        this.idGestora=idGestora;
        this.idEstadoGestora=idEstadoGestora;
        this.nombre=nombre;
    }

    public GestoraDTO(GestoraDTOBuilder builder) {
        this.idGestora=builder.idGestora;
        this.idEstadoGestora=builder.idEstadoGestora;
        this.nombre=builder.nombre;
        this.audCreaDate=builder.audCreaDate;
        this.audModDate=builder.audModDate;
        this.audCreaProc=builder.audCreaProc;
        this.audModProc=builder.audModProc;
        this.audCreaUsu=builder.audCreaUsu;
        this.audModUsu=builder.audModUsu;
    }

    public long getIdGestora() {
        return idGestora;
    }

    public void setIdGestora(long idGestora) {
        this.idGestora = idGestora;
    }

    public int getIdEstadoGestora() {
        return idEstadoGestora;
    }

    public void setIdEstadoGestora(int idEstadoGestora) {
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


    @Override
    public String toString() {
        return "GestoraDTO{" +
                "idGestora=" + idGestora +
                ", idEstadoGestora=" + idEstadoGestora +
                ", nombre='" + nombre + '\'' +
                ", audCreaDate=" + audCreaDate +
                ", audModDate=" + audModDate +
                ", audCreaProc='" + audCreaProc + '\'' +
                ", audModProc='" + audModProc + '\'' +
                ", audCreaUsu='" + audCreaUsu + '\'' +
                ", audModUsu='" + audModUsu + '\'' +
                '}';
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
        private int idEstadoGestora;
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

        public GestoraDTOBuilder idGestora(Long idGestora) {
            this.idGestora = idGestora;
            return this;
        }

        public GestoraDTOBuilder idEstadoGestora(int idEstadoGestora) {
            this.idEstadoGestora=idEstadoGestora;
            return this;
        }

        public GestoraDTOBuilder nombre(String nombre) {
            this.nombre = nombre;
            return this;
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
