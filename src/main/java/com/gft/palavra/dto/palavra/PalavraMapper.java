package com.gft.palavra.dto.palavra;

import java.util.ArrayList;
import java.util.List;

import com.gft.palavra.entities.Palavra;

public class PalavraMapper {

	public static Palavra fromDTO(RegistroPalavraDTO dto) {

		return new Palavra(null, dto.getPalavra(), dto.getPalavra().length(), null);
	}
	
	public static ConsultaPalavraDTO fromEntity(Palavra palavra) {
		List<String> etiquetasNome = new ArrayList<>();

		if(palavra.getEtiquetas() != null){
			palavra.getEtiquetas().forEach(etiqueta -> {
				String etiquetaNome = etiqueta.getEtiqueta();
				etiquetasNome.add(etiquetaNome);
			});
		}

		return new ConsultaPalavraDTO(palavra.getId(), palavra.getPalavra(), palavra.getPalavra().length(), etiquetasNome);
	}
	
}
