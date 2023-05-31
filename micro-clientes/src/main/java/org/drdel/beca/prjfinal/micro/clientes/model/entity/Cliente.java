package org.drdel.beca.prjfinal.micro.clientes.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_clientes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_estado_cliente")
    @NotNull
    private int idEstadoCliente;

    @Column(name = "nombre")
    @NotEmpty
    @NotNull
    @NotBlank
    private String nombre;

    @Column(name = "apellido")
    @NotEmpty
    @NotNull
    @NotBlank
    private String apellido;

    @Column(name = "email")
    @NotEmpty
    @NotNull
    @NotBlank
    @Email
    private String email;


    @NotNull
    @Column(name = "born_at")
    @Temporal(TemporalType.DATE)
    private Date bornAt;

    @NotNull
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @Column(name = "foto",nullable = true )
    private String foto;

    @PrePersist
    public void prePersist() {
        createAt =  new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdEstadoCliente() {return idEstadoCliente;}

    public void setIdEstadoCliente(int idEstadoCliente) {
        this.idEstadoCliente = idEstadoCliente;
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
