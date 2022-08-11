package com.gft.palavra.dto.palavra;

import java.util.List;

public class ConsultaPalavraDTO {
	
	private Long id;
	private String palavra;
	private int caracteres;

	private List<String> nomesEtiqueta;
	
	public ConsultaPalavraDTO() {
	}

	public ConsultaPalavraDTO(Long id, String palavra, int caracteres, List<String> nomesEtiqueta) {
		this.id = id;
		this.palavra = palavra;
		this.caracteres = caracteres;
		this.nomesEtiqueta = nomesEtiqueta;
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

	public List<String> getNomesEtiqueta() {
		return nomesEtiqueta;
	}

	public void setNomesEtiqueta(List<String> nomesEtiqueta) {
		this.nomesEtiqueta = nomesEtiqueta;
	}
}
