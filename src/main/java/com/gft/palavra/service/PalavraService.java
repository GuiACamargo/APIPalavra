package com.gft.palavra.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.palavra.dto.palavra.PalavraMapper;
import com.gft.palavra.dto.palavra.RegistroPalavraDTO;
import com.gft.palavra.entities.Etiqueta;
import com.gft.palavra.entities.Palavra;
import com.gft.palavra.exception.EntityNotFoundException;
import com.gft.palavra.repositories.EtiquetaRepository;
import com.gft.palavra.repositories.PalavraRepository;

@Service
public class PalavraService {
	
	private final PalavraRepository palavraRepository;
	
	private final EtiquetaRepository etiquetaRepository;

	public PalavraService(PalavraRepository palavraRepository, EtiquetaRepository etiquetaRepository) {
		this.palavraRepository = palavraRepository;
		this.etiquetaRepository = etiquetaRepository;
	}

	public Palavra salvarPalavra(Palavra palavra) {
		return palavraRepository.save(palavra);
	}
	
	public Page<Palavra> listarTodasAsPalavras(Pageable pageable) {
		return palavraRepository.findAll(pageable);
	}
	
	public Palavra buscarPalavra(Long id) {
		Optional<Palavra> palavra = palavraRepository.findById(id);
		
		return palavra.orElseThrow(() -> new EntityNotFoundException("Palavra não encontrada"));
	}
	
	public Palavra atualizarPalavra(RegistroPalavraDTO dto, Long id) {
		Palavra palavra = PalavraMapper.fromDTO(dto);
		Palavra palavraOriginal = buscarPalavra(id);
		List<Etiqueta> etiquetas = new ArrayList<>();
		if(dto.getEtiquetasId() != null) {
			dto.getEtiquetasId().forEach(p -> {
				if(etiquetaRepository.findById(p).isPresent()) {
					etiquetas.add(etiquetaRepository.findById(p).get());
				} else {
					Etiqueta etiqueta = new Etiqueta();
					etiqueta.setId(p);
					etiquetas.add(etiqueta);
				}
			});
		}
		palavra.setEtiquetas(etiquetas);
		palavra.setId(palavraOriginal.getId());
		
		return salvarPalavra(palavra);
	}
	
	public void excluirPalavra(Long id) {
		Palavra palavra = buscarPalavra(id);
		
		palavraRepository.delete(palavra);
	}
	
	public Palavra criaPalavraComAsEtiquetas (RegistroPalavraDTO dto) {
		Palavra palavra = PalavraMapper.fromDTO(dto);
		List<Etiqueta> etiquetas = new ArrayList<>();
		if(dto.getEtiquetasId() != null) {
			dto.getEtiquetasId().forEach(p -> {
				if(etiquetaRepository.findById(p).isPresent()) {
					etiquetas.add(etiquetaRepository.findById(p).get());
				} else {
					Etiqueta etiqueta = new Etiqueta();
					etiqueta.setId(p);
					etiquetas.add(etiqueta);
				}
			});
		}
		palavra.setEtiquetas(etiquetas);
		return palavra;
	}

	public Page<Palavra> buscarPalavraPorEtiqueta(String etiqueta, Pageable pageable){

		return palavraRepository.findByEtiquetasEtiquetaContains(etiqueta, pageable);
	}

}
