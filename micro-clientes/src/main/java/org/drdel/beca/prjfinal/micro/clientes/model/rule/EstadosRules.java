package org.drdel.beca.prjfinal.micro.clientes.model.rule;

import java.util.*;


public class EstadosRules {

    private EstadosRules(){}
    private static final Map<Integer, Set<Integer>> TRANSICIONES = new HashMap<>();

    static {
        var auxOperative = new HashSet<Integer>();
        auxOperative.add(ClienteEstadoEnum.OPERATIVE.getEstadoEnum());
        TRANSICIONES.put(ClienteEstadoEnum.DRAFT.getEstadoEnum(), auxOperative);
        TRANSICIONES.put(ClienteEstadoEnum.OPERATIVE.getEstadoEnum(),
                new HashSet<>(Arrays.asList(ClienteEstadoEnum.SUSPENDED.getEstadoEnum(),
                        ClienteEstadoEnum.CANCELED.getEstadoEnum())));
        TRANSICIONES.put(ClienteEstadoEnum.SUSPENDED.getEstadoEnum(),
                new HashSet<>(Arrays.asList(ClienteEstadoEnum.OPERATIVE.getEstadoEnum(),
                        ClienteEstadoEnum.CANCELED.getEstadoEnum())));
        TRANSICIONES.put(ClienteEstadoEnum.CANCELED.getEstadoEnum(),null);
    }

    public static boolean checkStatus(Integer initialStatus, Integer finalStatus) {
        for (Integer i : TRANSICIONES.keySet()) {
            if (initialStatus.equals(i) ){
                var target = TRANSICIONES.get(initialStatus);
                if (target==null) {
                    if (finalStatus == null)
                        return true;
                } else
                    return target.contains(finalStatus);
            }
        }
        return false;
    }

    //TODO codificar checkStatus como checkStatusLambda para usar las capacidades de programación funcional

}
