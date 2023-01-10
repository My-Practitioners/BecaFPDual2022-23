package org.drdel.beca.prjfinal.micro.clientes.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 8058062057701411951L;

    private Long id;

    @NotBlank
    @Size(min=4, max=30)
    private String nombre;

    @NotBlank
    @Size(min=4, max=30)
    private String apellido;

    @NotBlank
    @Size(min=4, max=40)
    @Email
    private String email;

    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date bornAt;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createAt;

    private String foto;

    public ClienteDTO() {
        super();
    }

    public ClienteDTO(Long id, @NotEmpty String nombre, @NotEmpty String apellido, @NotEmpty @Email String email, Date bornAt){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.bornAt = bornAt;
    }

    public ClienteDTO(Long id, @NotEmpty String nombre, @NotEmpty String apellido, @NotEmpty @Email String email,
                      Date bornAt, Date createAt, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.bornAt = bornAt;
        this.createAt = createAt;
        this.foto = foto;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBornAt() {
        return bornAt;
    }

    public void setBornAt(Date bornAt) {
        this.bornAt = bornAt;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

}