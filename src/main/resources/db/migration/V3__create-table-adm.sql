CREATE TABLE adm (
                     id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                     nome VARCHAR(255) NOT NULL,
                     cpf VARCHAR(11) NOT NULL UNIQUE,
                     dataDeNascimento DATE NOT NULL,
                     email VARCHAR(100) NOT NULL UNIQUE,
                     telefone VARCHAR(20) NOT NULL,
                     funcao VARCHAR(255) NOT NULL,
                     ativo BOOLEAN DEFAULT TRUE
);