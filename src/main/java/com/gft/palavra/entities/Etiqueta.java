package com.gft.palavra.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_etiqueta")
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String etiqueta;

    @ManyToMany(mappedBy = "etiquetas",cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Palavra> palavras;

    public Etiqueta(Long id, String etiqueta, List<Palavra> palavras) {
        this.id = id;
        this.etiqueta = etiqueta;
        this.palavras = palavras;
    }

    public Etiqueta() {
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

    public List<Palavra> getPalavras() {
        return palavras;
    }

    public void setPalavras(List<Palavra> palavras) {
        this.palavras = palavras;
    }
}
