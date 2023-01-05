package org.drdel.beca.prjfinal.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * SaveGestoraRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-21T12:19:29.084Z[GMT]")


public class SaveGestoraRequest   {
  @JsonProperty("entity")
  private BasicGestoraRequest entity = null;

  public SaveGestoraRequest entity(BasicGestoraRequest entity) {
    this.entity = entity;
    return this;
  }

  /**
   * Get entity
   * @return entity
   **/
  @Schema(description = "")
  
    @Valid
    public BasicGestoraRequest getEntity() {
    return entity;
  }

  public void setEntity(BasicGestoraRequest entity) {
    this.entity = entity;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SaveGestoraRequest saveGestoraRequest = (SaveGestoraRequest) o;
    return Objects.equals(this.entity, saveGestoraRequest.entity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SaveGestoraRequest {\n");
    
    sb.append("    entity: ").append(toIndentedString(entity)).append("\n");
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
