package org.drdel.beca.prjfinal.micro.clientes.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * BasicGestoraRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-21T12:19:29.084Z[GMT]")


public class BasicGestoraRequest   {
  @JsonProperty("id_gestora")
  private Integer idGestora = null;

  @JsonProperty("nombre")
  private String nombre = null;

  @JsonProperty("AUD_CREA_DATE")
  private LocalDate AUD_CREA_DATE = null;

  @JsonProperty("AUD_MOD_DATE")
  private LocalDate AUD_MOD_DATE = null;

  @JsonProperty("AUD_CREA_PROC")
  private String AUD_CREA_PROC = null;

  @JsonProperty("AUD_MOD_PROC")
  private String AUD_MOD_PROC = null;

  @JsonProperty("AUD_CREA_USU")
  private String AUD_CREA_USU = null;

  @JsonProperty("AUD_MOD_USU")
  private String AUD_MOD_USU = null;

  public BasicGestoraRequest idGestora(Integer idGestora) {
    this.idGestora = idGestora;
    return this;
  }

  /**
   * ID de la gestora
   * @return idGestora
   **/
  @Schema(example = "1", description = "ID de la gestora")
  
    public Integer getIdGestora() {
    return idGestora;
  }

  public void setIdGestora(Integer idGestora) {
    this.idGestora = idGestora;
  }

  public BasicGestoraRequest nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Nombre de la gestora
   * @return nombre
   **/
  @Schema(example = "gestora 12", description = "Nombre de la gestora")
  
    public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public BasicGestoraRequest AUD_CREA_DATE(LocalDate AUD_CREA_DATE) {
    this.AUD_CREA_DATE = AUD_CREA_DATE;
    return this;
  }

  /**
   * Creación de la fecha de auditoria
   * @return AUD_CREA_DATE
   **/
  @Schema(description = "Creación de la fecha de auditoria")
  
    @Valid
    public LocalDate getAUDCREADATE() {
    return AUD_CREA_DATE;
  }

  public void setAUDCREADATE(LocalDate AUD_CREA_DATE) {
    this.AUD_CREA_DATE = AUD_CREA_DATE;
  }

  public BasicGestoraRequest AUD_MOD_DATE(LocalDate AUD_MOD_DATE) {
    this.AUD_MOD_DATE = AUD_MOD_DATE;
    return this;
  }

  /**
   * Creacion de la fecha de auditoria
   * @return AUD_MOD_DATE
   **/
  @Schema(description = "Creacion de la fecha de auditoria")
  
    @Valid
    public LocalDate getAUDMODDATE() {
    return AUD_MOD_DATE;
  }

  public void setAUDMODDATE(LocalDate AUD_MOD_DATE) {
    this.AUD_MOD_DATE = AUD_MOD_DATE;
  }

  public BasicGestoraRequest AUD_CREA_PROC(String AUD_CREA_PROC) {
    this.AUD_CREA_PROC = AUD_CREA_PROC;
    return this;
  }

  /**
   * Get AUD_CREA_PROC
   * @return AUD_CREA_PROC
   **/
  @Schema(description = "")
  
    public String getAUDCREAPROC() {
    return AUD_CREA_PROC;
  }

  public void setAUDCREAPROC(String AUD_CREA_PROC) {
    this.AUD_CREA_PROC = AUD_CREA_PROC;
  }

  public BasicGestoraRequest AUD_MOD_PROC(String AUD_MOD_PROC) {
    this.AUD_MOD_PROC = AUD_MOD_PROC;
    return this;
  }

  /**
   * Get AUD_MOD_PROC
   * @return AUD_MOD_PROC
   **/
  @Schema(example = "MIGRACION", description = "")
  
    public String getAUDMODPROC() {
    return AUD_MOD_PROC;
  }

  public void setAUDMODPROC(String AUD_MOD_PROC) {
    this.AUD_MOD_PROC = AUD_MOD_PROC;
  }

  public BasicGestoraRequest AUD_CREA_USU(String AUD_CREA_USU) {
    this.AUD_CREA_USU = AUD_CREA_USU;
    return this;
  }

  /**
   * Get AUD_CREA_USU
   * @return AUD_CREA_USU
   **/
  @Schema(example = "SCRIPT_USER", description = "")
  
    public String getAUDCREAUSU() {
    return AUD_CREA_USU;
  }

  public void setAUDCREAUSU(String AUD_CREA_USU) {
    this.AUD_CREA_USU = AUD_CREA_USU;
  }

  public BasicGestoraRequest AUD_MOD_USU(String AUD_MOD_USU) {
    this.AUD_MOD_USU = AUD_MOD_USU;
    return this;
  }

  /**
   * Get AUD_MOD_USU
   * @return AUD_MOD_USU
   **/
  @Schema(example = "SCRIPT_USER", description = "")
  
    public String getAUDMODUSU() {
    return AUD_MOD_USU;
  }

  public void setAUDMODUSU(String AUD_MOD_USU) {
    this.AUD_MOD_USU = AUD_MOD_USU;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BasicGestoraRequest basicGestoraRequest = (BasicGestoraRequest) o;
    return Objects.equals(this.idGestora, basicGestoraRequest.idGestora) &&
        Objects.equals(this.nombre, basicGestoraRequest.nombre) &&
        Objects.equals(this.AUD_CREA_DATE, basicGestoraRequest.AUD_CREA_DATE) &&
        Objects.equals(this.AUD_MOD_DATE, basicGestoraRequest.AUD_MOD_DATE) &&
        Objects.equals(this.AUD_CREA_PROC, basicGestoraRequest.AUD_CREA_PROC) &&
        Objects.equals(this.AUD_MOD_PROC, basicGestoraRequest.AUD_MOD_PROC) &&
        Objects.equals(this.AUD_CREA_USU, basicGestoraRequest.AUD_CREA_USU) &&
        Objects.equals(this.AUD_MOD_USU, basicGestoraRequest.AUD_MOD_USU);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idGestora, nombre, AUD_CREA_DATE, AUD_MOD_DATE, AUD_CREA_PROC, AUD_MOD_PROC, AUD_CREA_USU, AUD_MOD_USU);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BasicGestoraRequest {\n");
    
    sb.append("    idGestora: ").append(toIndentedString(idGestora)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    AUD_CREA_DATE: ").append(toIndentedString(AUD_CREA_DATE)).append("\n");
    sb.append("    AUD_MOD_DATE: ").append(toIndentedString(AUD_MOD_DATE)).append("\n");
    sb.append("    AUD_CREA_PROC: ").append(toIndentedString(AUD_CREA_PROC)).append("\n");
    sb.append("    AUD_MOD_PROC: ").append(toIndentedString(AUD_MOD_PROC)).append("\n");
    sb.append("    AUD_CREA_USU: ").append(toIndentedString(AUD_CREA_USU)).append("\n");
    sb.append("    AUD_MOD_USU: ").append(toIndentedString(AUD_MOD_USU)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
