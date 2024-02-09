CREATE TABLE competencia (
                             id BIGINT NOT NULL AUTO_INCREMENT,
                             descricao VARCHAR(255) NOT NULL,
                             proficiencia VARCHAR(100) NOT NULL,
                             candidato_id BIGINT,
                             PRIMARY KEY (id),
                             FOREIGN KEY (candidato_id) REFERENCES candidato (id)
);
