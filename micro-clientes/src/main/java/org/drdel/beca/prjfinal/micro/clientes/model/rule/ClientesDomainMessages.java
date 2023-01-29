package org.drdel.beca.prjfinal.micro.clientes.model.rule;

public class ClientesDomainMessages {
    private ClientesDomainMessages(){}
    public static final String MSG_CLIENTES0001_CAMBIAR_ESTADO_ACTIVAR_NO = "No es posible activar el cliente desde el estado %s";
    public static final String MSG_CLIENTES0002_CAMBIAR_ESTADO_SUSPENDER_NO = "No es posible suspender el cliente desde el estado %s";
    public static final String MSG_CLIENTES0003_CAMBIAR_ESTADO_CANCELAR_NO = "No es posible cancelar el cliente desde el estado %s";
    public static final String MSG_CLIENTES0004_ESTADO_CREACION_DRAFT = "El estado de creación de un cliente debe ser DRAFT en vez de %s";
    public static final String MSG_CLIENTES0005_ESTADO_BORRAR_DRAFT = "Para borrar un cliente el estado debe ser DRAFT en vez de %s";
    public static final String MSG_CLIENTES0006_ESTADO_INVALIDO = "Cambio a estado inválido %s";

}
