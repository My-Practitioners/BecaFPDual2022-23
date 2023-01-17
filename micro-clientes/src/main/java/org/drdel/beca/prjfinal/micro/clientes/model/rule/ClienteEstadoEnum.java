package org.drdel.beca.prjfinal.micro.clientes.model.rule;

public enum ClienteEstadoEnum {
    ACTIVAR(1), SUSPENDER(2), CANCELAR(3), DRAFT(4);

    private int estadoEnum;

    ClienteEstadoEnum(int estadoEnum) {
        this.estadoEnum = estadoEnum;
    }

    public int getEstadoEnum() {
        return estadoEnum;
    }
}
