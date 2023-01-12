package org.drdel.beca.prjfinal.micro.clientes.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1230791196947869605L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotNull
    @NotBlank
    private String nombre;

    @NotEmpty
    @NotNull
    @NotBlank
    private String apellido;

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

    /*@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Factura> facturas;


    public Cliente() {
        facturas = new ArrayList<>();
    }*/

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

    /*public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public void addFactura(Factura factura) {
        this.facturas.add(factura);
    }*/

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}