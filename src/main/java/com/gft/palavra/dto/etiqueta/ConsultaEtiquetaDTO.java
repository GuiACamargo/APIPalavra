package com.gft.palavra.dto.etiqueta;

import java.util.List;

public class ConsultaEtiquetaDTO {

    private Long id;

    private String etiqueta;

    private List<String> nomesPalavra;

    public ConsultaEtiquetaDTO(Long id, String etiqueta, List<String> nomesPalavra) {
        this.id = id;
        this.etiqueta = etiqueta;
        this.nomesPalavra = nomesPalavra;
    }

    public ConsultaEtiquetaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public List<String> getNomesPalavra() {
        return nomesPalavra;
    }

    public void setNomesPalavra(List<String> nomesPalavra) {
        this.nomesPalavra = nomesPalavra;
    }
}
