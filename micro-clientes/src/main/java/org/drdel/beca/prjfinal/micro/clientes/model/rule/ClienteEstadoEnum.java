package org.drdel.beca.prjfinal.micro.clientes.model.rule;

public enum ClienteEstadoEnum {
    DRAFT(0),OPERATIVE(1), SUSPENDED(2), CANCELED(3);
    private final Integer estadoEnum;

    ClienteEstadoEnum(Integer estadoEnum) {
        this.estadoEnum= estadoEnum;
    }
    public Integer getEstadoEnum() {
        return estadoEnum ;
    }

}