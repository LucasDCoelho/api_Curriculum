CREATE TABLE competencia (
                             id bigint NOT NULL AUTO_INCREMENT,
                             candidato_id bigint NOT NULL,
                             descricao varchar(255) NOT NULL,
                             proficiencia varchar(100) NOT NULL,
                             PRIMARY KEY(id),
                             FOREIGN KEY(candidato_id) REFERENCES candidato(id)
);