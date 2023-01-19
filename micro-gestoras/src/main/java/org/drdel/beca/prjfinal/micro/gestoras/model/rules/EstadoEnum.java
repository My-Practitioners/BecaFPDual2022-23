package org.drdel.beca.prjfinal.micro.gestoras.model.rules;

public enum EstadoEnum {
    OPERATIVE(1), SUSPENDED(2), CANCELED(3), DRAFT(4);
    private final int estadoEnum;
    EstadoEnum(int estadoEnum) {
        this.estadoEnum = estadoEnum;
    }

    public int getEstadoEnum() {
        return estadoEnum;
    }
}
