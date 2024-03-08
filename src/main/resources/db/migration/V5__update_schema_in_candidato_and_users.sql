-- Adiciona a coluna user_id na tabela candidato
ALTER TABLE candidato
    ADD COLUMN user_id BIGINT,
ADD CONSTRAINT fk_user_candidato FOREIGN KEY (user_id) REFERENCES users(id);
