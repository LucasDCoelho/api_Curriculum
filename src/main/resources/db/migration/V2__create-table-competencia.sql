CREATE TABLE competencia (
                             id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                             descricao VARCHAR(255) NOT NULL,
                             proficiencia VARCHAR(100) NOT NULL,
                             candidato_id BIGINT,
                             FOREIGN KEY (candidato_id) REFERENCES candidato (id)
);
