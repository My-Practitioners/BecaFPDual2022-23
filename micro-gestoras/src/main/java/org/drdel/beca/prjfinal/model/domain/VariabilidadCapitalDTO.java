
package org.drdel.beca.prjfinal.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.drdel.beca.prjfinal.model.entity.VariabilidadCapital;
import org.json.JSONObject;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

    public class VariabilidadCapitalDTO implements Serializable {

        private String codVariabilidadCapital;

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

        public VariabilidadCapitalDTO() {
        }

        public VariabilidadCapitalDTO(String codVariabilidadCapital, String descripcion) {
            this.codVariabilidadCapital = codVariabilidadCapital;
            this.descripcion = descripcion;
        }

        public VariabilidadCapitalDTO(VariabilidadCapitalDTOBuilder builder) {
            this.codVariabilidadCapital=builder.codVariabilidadCapital;
            this.descripcion=builder.descripcion;
            builder.audCreaDate(audCreaDate);
            builder.audModDate(audModDate);
            builder.audCreaProc(audCreaProc);
            builder.audModProc(audModProc);
            builder.audCreaUsu(audCreaUsu);
            builder.audModUsu(audModUsu);
        }

        public String getCodVariabilidadCapital() {
            return codVariabilidadCapital;
        }

        public void setCodVariabilidadCapital(String codVariabilidadCapital) {
            this.codVariabilidadCapital = codVariabilidadCapital;
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




    public String toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("codVariabilidadCapital" ,codVariabilidadCapital);
        jsonObject.put("descripcion" ,descripcion);
        jsonObject.put("audCreaDate" , audCreaDate);
        jsonObject.put("audModDate" , audModDate);
        jsonObject.put("audCreaProc" , audCreaProc);
        jsonObject.put("audModProc" , audModProc);
        jsonObject.put("audCreaUsu" , audCreaUsu);
        jsonObject.put("audModUsu" , audModUsu);

        return jsonObject.toString();
    }

    public class VariabilidadCapitalDTOBuilder{

            private String codVariabilidadCapital;
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

            public VariabilidadCapitalDTOBuilder(String codVariabilidadCapital, String descripcion) {
                this.codVariabilidadCapital = codVariabilidadCapital;
                this.descripcion = descripcion;
            }

            public VariabilidadCapitalDTO.VariabilidadCapitalDTOBuilder audCreaDate(Date audCreaDate) {
                this.audCreaDate = audCreaDate;
                return this;
            }

            public VariabilidadCapitalDTO.VariabilidadCapitalDTOBuilder audModDate(Date audModDate) {
                this.audModDate = audModDate;
                return this;
            }

            public VariabilidadCapitalDTO.VariabilidadCapitalDTOBuilder audCreaProc(String audCreaProc) {
                this.audCreaProc = audCreaProc;
                return this;
            }

            public VariabilidadCapitalDTO.VariabilidadCapitalDTOBuilder audModProc(String audModProc) {
                this.audModProc = audModProc;
                return this;
            }

            public VariabilidadCapitalDTO.VariabilidadCapitalDTOBuilder audCreaUsu(String audCreaUsu) {
                this.audCreaUsu = audCreaUsu;
                return this;
            }

            public VariabilidadCapitalDTO.VariabilidadCapitalDTOBuilder audModUsu(String audModUsu) {
                this.audModUsu = audModUsu;
                return this;
            }

            public VariabilidadCapitalDTO build() {return new VariabilidadCapitalDTO(this);}

        }
    }

