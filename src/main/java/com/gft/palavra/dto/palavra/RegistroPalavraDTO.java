package com.gft.palavra.dto.palavra;

import java.util.List;

public class RegistroPalavraDTO {
	
	private String palavra;

	private List<Long> etiquetasId;
	
	public RegistroPalavraDTO() {
		
	}

	public RegistroPalavraDTO(String palavra, List<Long> etiquetasId) {
		this.palavra = palavra;
		this.etiquetasId = etiquetasId;
	}

	public String getPalavra() {
		return palavra;
	}
	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public List<Long> getEtiquetasId() {
		return etiquetasId;
	}

	public void setEtiquetasId(List<Long> etiquetasId) {
		this.etiquetasId = etiquetasId;
	}
}
