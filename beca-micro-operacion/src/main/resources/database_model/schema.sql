-- ESTADOSCONTRATACION
drop table if exists t_estados_contratacion;
create table t_estados_contratacion (
id_estado_contratacion bigint,
descripcion varchar(255));

-- FONDOSCLIENTE
drop table if exists t_fondos_cliente;
create table t_fondos_cliente (
id_fondo_cliente bigint generated by default as identity,
cod_isin varchar(255) not null,
id_cliente bigint,
fecha_contratacion date not null);

-- FONDOSCLIENTEHISTORY
drop table if exists t_fondos_cliente_history;
create table t_fondos_cliente_history (
id_fondo_cliente bigint generated by default as identity,
id_estado_contratacion bigint,
fecha_cambio_estado timestamp,
id_operacion_contratacion bigint,
importe double);


-- OPERACIONESCONTRATACION
drop table if exists t_operaciones_contratacion;
create table t_operaciones_contratacion (
id_operacion_contratacion bigint,
descripcion varchar(255));