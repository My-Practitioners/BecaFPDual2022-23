DROP TABLE IF EXISTS T_VARIABILIDAD_CAPITAL;
create table t_variabilidad_capital (cod_variabilidad_capital varchar(255) not null, aud_crea_date timestamp, aud_crea_proc varchar(255), aud_crea_usu varchar(255), aud_mod_date date, aud_mod_proc varchar(255), aud_mod_usu varchar(255), descripcion varchar(255), primary key (cod_variabilidad_capital));
