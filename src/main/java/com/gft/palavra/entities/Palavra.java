package com.gft.palavra.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_palavra")
public class Palavra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String palavra;
	private int caracteres;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable( name = "tb_palavra_etiqueta_juncao",
			joinColumns = {@JoinColumn(name = "palavra_id")},
			inverseJoinColumns = {@JoinColumn(name = "etiqueta_id")}
	)
	private List<Etiqueta> etiquetas;

	public Palavra(Long id, String palavra, int caracteres, List<Etiqueta> etiquetas) {
		this.id = id;
		this.palavra = palavra;
		this.caracteres = caracteres;
		this.etiquetas = etiquetas;
	}

	public Palavra() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPalavra() {
		return palavra;
	}
	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	public int getCaracteres() {
		return caracteres;
	}
	public void setCaracteres(int caracteres) {
		this.caracteres = caracteres;
	}

	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}
}
