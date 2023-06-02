DROP SCHEMA IF EXISTS public CASCADE;
CREATE SCHEMA IF NOT EXISTS public;
SET search_path TO public;

DROP TABLE IF EXISTS regiao CASCADE;
CREATE TABLE IF NOT EXISTS regiao (
    id BIGINT PRIMARY KEY,
    nome TEXT NOT NULL
);


DROP TABLE IF EXISTS estado CASCADE;
CREATE TABLE IF NOT EXISTS estado (
    id BIGINT PRIMARY KEY,
    id_regiao BIGINT NOT NULL REFERENCES regiao (id),
    nome TEXT NOT NULL,
    sigla CHAR(2) NOT NULL UNIQUE
);


DROP TABLE IF EXISTS municipio CASCADE;
CREATE TABLE IF NOT EXISTS municipio(
    id BIGINT PRIMARY KEY,
    id_estado BIGINT NOT NULL REFERENCES estado(id),
    nome TEXT NOT NULL
);


DROP TABLE IF EXISTS unidade_basica CASCADE;
CREATE TABLE IF NOT EXISTS unidade_basica(
    id BIGINT PRIMARY KEY,
    id_municipio BIGINT NOT NULL REFERENCES municipio(id),
    nome_fantasia TEXT,
    bairro TEXT,
    logradouro TEXT 
);


DROP TABLE IF EXISTS recebimento_vacina CASCADE;
CREATE TABLE IF NOT EXISTS recebimento_vacina(
    id UUID PRIMARY KEY,
    id_unidade_basica BIGINT NOT NULL REFERENCES unidade_basica(id),
    datahora_recebimento TIMESTAMP NOT NULL,
    quantidade BIGINT NOT NULL
);


DROP TABLE IF EXISTS aplicacao_vacina CASCADE;
CREATE TABLE IF NOT EXISTS aplicacao_vacina(
    id UUID PRIMARY KEY,
    data_nascimento TIMESTAMP NOT NULL,
    sexo CHAR(1) NOT NULL,
    id_unidade_basica BIGINT NOT NULL REFERENCES unidade_basica(id),
    datahora_aplicacao TIMESTAMP NOT NULL
);