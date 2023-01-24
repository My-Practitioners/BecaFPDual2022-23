-- DATOS MAESTROS
drop table if exists t_variabilidad_capital;
create table t_variabilidad_capital (cod_variabilidad_capital varchar(255) not null, id_estado_variabilidad_capital bigint, aud_crea_date timestamp, aud_crea_proc varchar(255), aud_crea_usu varchar(255), aud_mod_date date, aud_mod_proc varchar(255), aud_mod_usu varchar(255), descripcion varchar(255), primary key (cod_variabilidad_capital));

drop table if exists t_politica_inversion;
create table t_politica_inversion (cod_pinversion varchar(255) not null, id_estado_politica_inversion bigint, aud_crea_date timestamp, aud_crea_proc varchar(255), aud_crea_usu varchar(255), aud_mod_date date, aud_mod_proc varchar(255), aud_mod_usu varchar(255), descripcion varchar(255), primary key (cod_pinversion));

-- GESTORAS
drop table if exists t_gestora_fondos;
create table t_gestora_fondos (id_gestora bigint generated by default as identity, id_estado_gestora bigint, aud_crea_date timestamp, aud_crea_proc varchar(255), aud_crea_usu varchar(255), aud_mod_date date, aud_mod_proc varchar(255), aud_mod_usu varchar(255), nombre varchar(255), primary key (id_gestora));

drop table if exists t_direccion_gestoras;
create table t_direccion_gestoras (id_direccion bigint generated by default as identity, id_estado_direccion_gestora bigint, aud_crea_date timestamp, aud_crea_proc varchar(255), aud_crea_usu varchar(255), aud_mod_date date, aud_mod_proc varchar(255), aud_mod_usu varchar(255), direccion varchar(255), id_gestora bigint, primary key (id_direccion));

-- FONDOS
drop table if exists t_fondos_inversion;
create table t_fondos_inversion (cod_isin varchar(255) not null, id_estado_fondo_inversion bigint, cod_europeo varchar(255), cod_lei varchar(255), nombre_fondo varchar(255), id_gestora bigint, id_direccion bigint, cod_pinversion varchar(255), cod_variabilidadcapital varchar(255), subfondo varchar(255), cod_supervisor varchar(255), AUD_CREA_DATE timestamp, AUD_MOD_DATE date, AUD_CREA_PROC varchar(255), AUD_MOD_PROC varchar(255), AUD_CREA_USU varchar(255), AUD_MOD_USU varchar(255), primary key (cod_isin));

