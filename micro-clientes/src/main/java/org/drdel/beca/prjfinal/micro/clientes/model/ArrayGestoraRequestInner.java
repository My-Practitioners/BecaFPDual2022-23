package org.drdel.beca.prjfinal.micro.clientes.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

/**
 * ArrayGestoraRequestInner
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-21T12:19:29.084Z[GMT]")


public class ArrayGestoraRequestInner   {
  @JsonProperty("id_gestora")
  private Integer idGestora = null;

  @JsonProperty("nombre")
  private String nombre = null;

  public ArrayGestoraRequestInner idGestora(Integer idGestora) {
    this.idGestora = idGestora;
    return this;
  }

  /**
   * ID de la gestora
   * @return idGestora
   **/
  @Schema(description = "ID de la gestora")
  
    public Integer getIdGestora() {
    return idGestora;
  }

  public void setIdGestora(Integer idGestora) {
    this.idGestora = idGestora;
  }

  public ArrayGestoraRequestInner nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Nombre de la gestora
   * @return nombre
   **/
  @Schema(description = "Nombre de la gestora")
  
    public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArrayGestoraRequestInner arrayGestoraRequestInner = (ArrayGestoraRequestInner) o;
    return Objects.equals(this.idGestora, arrayGestoraRequestInner.idGestora) &&
        Objects.equals(this.nombre, arrayGestoraRequestInner.nombre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idGestora, nombre);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArrayGestoraRequestInner {\n");
    
    sb.append("    idGestora: ").append(toIndentedString(idGestora)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
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
