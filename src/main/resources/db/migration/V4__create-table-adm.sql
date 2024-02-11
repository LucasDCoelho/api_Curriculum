create table adm (
                     id bigint not null auto_increment,
                     nome varchar(100) not null,
                     cpf varchar(11) not null unique,
                     dataDeNascimento date not null,
                     email varchar(100) not null unique,
                     telefone varchar(20) not null,
                     funcao varchar(100) not null,
                     ativo tinyint default 1,

                     primary key(id)
);