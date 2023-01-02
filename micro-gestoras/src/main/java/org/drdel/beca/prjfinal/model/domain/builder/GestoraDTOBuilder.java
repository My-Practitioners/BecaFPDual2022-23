package org.drdel.beca.prjfinal.model.domain.builder;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.drdel.beca.prjfinal.model.domain.GestoraDTO;

import javax.validation.constraints.Size;
import java.util.Date;

public class GestoraDTOBuilder {
    private long idGestora;
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


    public GestoraDTOBuilder (long idGestora, String nombre){
        this.idGestora=idGestora;
        this.nombre=nombre;
    }
    public GestoraDTOBuilder audCreaDate(Date audCreaDate){
        this.audCreaDate=audCreaDate;
        return this;
    }
    public GestoraDTOBuilder audModDate(Date audModDate){
        this.audModDate=audModDate;
        return this;
    }
    public GestoraDTOBuilder audCreaProc(String audCreaProc){
        this.audCreaProc=audCreaProc;
        return this;
    }
    public GestoraDTOBuilder audModProc(String audModProc){
        this.audModProc=audModProc;
        return this;
    }
    public GestoraDTOBuilder audCreaUsu(String audCreaUsu){
        this.audCreaUsu=audCreaUsu;
        return this;
    }
    public GestoraDTOBuilder audModUsu(String audModUsu){
        this.audModUsu=audModUsu;
        return this;
    }
    public GestoraDTO build(){
        GestoraDTO gestoradto=new GestoraDTO();

        gestoradto.setIdGestora(this.idGestora);
        gestoradto.setNombre(this.nombre);
        gestoradto.setAudCreaDate(this.audCreaDate);
        gestoradto.setAudModDate(this.audModDate);
        gestoradto.setAudCreaProc(this.audCreaProc);
        gestoradto.setAudModProc(this.audModProc);
        gestoradto.setAudCreaUsu(this.audCreaUsu);
        gestoradto.setAudModUsu(this.audModUsu);
        return gestoradto;
    }
}
