create table perfil
(
    id    bigint  not null auto_increment,
    nome varchar(100) not null,

    primary key (id)
);

INSERT INTO perfil (nome) VALUES('GERENTE');
INSERT INTO perfil (nome) VALUES('OPERADOR');