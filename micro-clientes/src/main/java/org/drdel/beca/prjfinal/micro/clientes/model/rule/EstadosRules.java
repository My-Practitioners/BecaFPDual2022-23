package org.drdel.beca.prjfinal.micro.clientes.model.rule;

import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
public class EstadosRules {

    private EstadosRules(){}
    private static final Map<Integer, Set<Integer>> TRANSICIONES = new HashMap<>();

    static {
        Set<Integer> auxOperative = new HashSet<>();
        auxOperative.add(ClienteEstadoEnum.OPERATIVE.getEstadoEnum());
        TRANSICIONES.put(ClienteEstadoEnum.DRAFT.getEstadoEnum(),auxOperative);
        TRANSICIONES.put(ClienteEstadoEnum.OPERATIVE.getEstadoEnum(),
                new HashSet<>(Arrays.asList(ClienteEstadoEnum.SUSPENDED.getEstadoEnum(),
                        ClienteEstadoEnum.CANCELED.getEstadoEnum())));
        TRANSICIONES.put(ClienteEstadoEnum.SUSPENDED.getEstadoEnum(),auxOperative);
        TRANSICIONES.put(ClienteEstadoEnum.CANCELED.getEstadoEnum(),null);
    }

    public static boolean checkStatus(Integer initialStatus, Integer finalStatus) {
        for (Integer i : TRANSICIONES.keySet()) {
            if (initialStatus.equals(i) ){
                Set<Integer> target = TRANSICIONES.get(initialStatus);
                if (target==null) {
                    if (finalStatus == null)
                        return true;
                } else
                    return target.contains(finalStatus);
            }
        }
        return false;
    }

}
