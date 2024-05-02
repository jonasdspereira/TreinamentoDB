CREATE TABLE bibliotecas (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE livros (
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    ano_de_publicacao INTEGER,
    biblioteca_id BIGINT NOT NULL,
    FOREIGN KEY (biblioteca_id) REFERENCES bibliotecas(id)
);