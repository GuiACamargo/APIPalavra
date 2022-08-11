CREATE TABLE tb_palavra_etiqueta_juncao (
palavra_id BIGINT,
etiqueta_id BIGINT,
CONSTRAINT fk_palavra FOREIGN KEY (palavra_id) REFERENCES tb_palavra (id),
CONSTRAINT fk_etiqueta FOREIGN KEY (etiqueta_id) REFERENCES tb_etiqueta (id),
UNIQUE (palavra_id, etiqueta_id)
);