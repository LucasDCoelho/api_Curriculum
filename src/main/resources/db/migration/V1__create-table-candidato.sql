CREATE TABLE candidato (
                           id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                           nome VARCHAR(255) NOT NULL,
                           cpf VARCHAR(255) NOT NULL UNIQUE,
                           dataDeNascimento DATE NOT NULL,
                           email VARCHAR(100) NOT NULL UNIQUE,
                           telefone VARCHAR(20) NOT NULL,
                           escolaridade VARCHAR(255) NOT NULL,
                           funcao VARCHAR(255) NOT NULL,
                           ativo BOOLEAN DEFAULT TRUE,
                           situacao VARCHAR(255) NOT NULL DEFAULT 'AGUARDANDO' CHECK (situacao IN ('AGUARDANDO', 'REPROVADO', 'APROVADO'))
);