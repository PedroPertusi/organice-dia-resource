CREATE TABLE dia
(
    id_dia character varying(36) NOT NULL,
    dia_data character varying(256) NOT NULL,
    dia_data_criacao character varying(256) NOT NULL,
    dia_dia_da_semana character varying(256) NOT NULL,
    dia_descricao character varying(256) NOT NULL,
    dia_id_usuario character varying(256) NOT NULL,

    CONSTRAINT dia_pkey PRIMARY KEY (id_dia)
);