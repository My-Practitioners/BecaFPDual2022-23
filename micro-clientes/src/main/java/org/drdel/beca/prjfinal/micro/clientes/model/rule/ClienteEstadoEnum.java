package org.drdel.beca.prjfinal.micro.clientes.model.rule;

public enum ClienteEstadoEnum {
    OPERATIVE(1), SUSPENDED(2), CANCELED(3), DRAFT(4);
    private final int estadoEnum;

    ClienteEstadoEnum(int estadoEnum) {
        this.estadoEnum= estadoEnum;
    }
    public int getEstadoEnum() {
        return estadoEnum ;
    }

}