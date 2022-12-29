package org.drdel.beca.prjfinal.model.service;

import org.drdel.beca.prjfinal.model.domain.GestoraDTO;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class GestoraServiceImpl implements IGestoraService{

    private final List<GestoraDTO> listaGestoras;

    //Constructor
    public GestoraServiceImpl (){
        this.listaGestoras= Arrays.asList(
                new GestoraDTO(1,"Primera Gestora", new Date(2022,12,19),new Date(System.currentTimeMillis()),"Migracion","Migracion","User_1","User_1"),
                new GestoraDTO(2,"Segunda Gestora", new Date(2022,12,19),new Date(System.currentTimeMillis()),"Migracion","Migracion","User_2","User_2"),
                new GestoraDTO(3,"Tercera Gestora", new Date(2022,12,19),new Date(System.currentTimeMillis()),"Migracion","Migracion","User_3","User_3"),
                new GestoraDTO(4,"Cuarta Gestora", new Date(2022,12,19),new Date(System.currentTimeMillis()),"Migracion","Migracion","User_4","User_4"),
                new GestoraDTO(5,"Quinta Gestora", new Date(2022,12,19),new Date(System.currentTimeMillis()),"Migracion","Migracion","User_5","User_5")

        );
    }



    @Override
    public Long crearGestora(GestoraDTO gestora) {

        GestoraDTO g = new GestoraDTO();

        g.setNombre(g.getNombre());

        return null;
    }

    @Override

    public GestoraDTO obtenerGestora(Long id) {
        Optional<GestoraDTO> selectedGestora = this.listaGestoras.stream()
                .filter(s -> id.equals(s.getIdGestora()))
                .findFirst();
        return selectedGestora.isPresent() ? selectedGestora.get() : null;
    }

    @Override
    public List<GestoraDTO> obtenerTodasGestoras() {
        return listaGestoras;
    }

}
