package org.drdel.beca.prjfinal.model.domain.builder;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.drdel.beca.prjfinal.model.domain.DireccionGestoraDTO;
import org.drdel.beca.prjfinal.model.entity.DireccionGestora;

import javax.validation.constraints.Size;
import java.util.Date;

public class DireccionGestoraDTOBuilder {

    private Long idDireccion;

    private Long idGestora;

    private String direccion;

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

    public DireccionGestoraDTOBuilder (long idDireccion, long idGestora, String direccion){
        this.idDireccion=idDireccion;
        this.idGestora=idGestora;
        this.direccion=direccion;
    }
    public DireccionGestoraDTOBuilder audCreaDate(Date audCreaDate){
        this.audCreaDate=audCreaDate;
        return this;
    }
    public DireccionGestoraDTOBuilder audModDate(Date audModDate){
        this.audModDate=audModDate;
        return this;
    }
    public DireccionGestoraDTOBuilder audCreaProc(String audCreaProc){
        this.audCreaProc=audCreaProc;
        return this;
    }
    public DireccionGestoraDTOBuilder audModProc(String audModProc){
        this.audModProc=audModProc;
        return this;
    }
    public DireccionGestoraDTOBuilder audCreaUsu(String audCreaUsu){
        this.audCreaUsu=audCreaUsu;
        return this;
    }
    public DireccionGestoraDTOBuilder audModUsu(String audModUsu){
        this.audModUsu=audModUsu;
        return this;
    }
    public DireccionGestoraDTO build(){
        DireccionGestoraDTO direccionGestoraDTO=new DireccionGestoraDTO();

        direccionGestoraDTO.setIdDireccion(this.idDireccion);
        direccionGestoraDTO.setIdGestora(this.idGestora);
        direccionGestoraDTO.setDireccion(this.direccion);
        direccionGestoraDTO.setAudCreaDate(this.audCreaDate);
        direccionGestoraDTO.setAudModDate(this.audModDate);
        direccionGestoraDTO.setAudCreaProc(this.audCreaProc);
        direccionGestoraDTO.setAudModProc(this.audModProc);
        direccionGestoraDTO.setAudCreaUsu(this.audCreaUsu);
        direccionGestoraDTO.setAudModUsu(this.audModUsu);
        return direccionGestoraDTO;
    }
}
