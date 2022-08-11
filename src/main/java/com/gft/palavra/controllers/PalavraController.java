package com.gft.palavra.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.gft.palavra.dto.palavra.ConsultaPalavraDTO;
import com.gft.palavra.dto.palavra.PalavraMapper;
import com.gft.palavra.dto.palavra.RegistroPalavraDTO;
import com.gft.palavra.entities.Palavra;
import com.gft.palavra.service.PalavraService;

@RestController
@RequestMapping("v1/palavras")
public class PalavraController {
	
	private final PalavraService palavraService;

	public PalavraController(PalavraService palavraService) {
		this.palavraService = palavraService;
	}
	
	@GetMapping
	@PreAuthorize("hasAnyAuthority('admin', 'user')")
	public ResponseEntity<Page<ConsultaPalavraDTO>> buscarTodasAsPalavras(@PageableDefault Pageable pageable) {
		
		return ResponseEntity.ok(palavraService.listarTodasAsPalavras(pageable).map(PalavraMapper::fromEntity));
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('admin')")
	public ResponseEntity<ConsultaPalavraDTO> salvarPalavra(@RequestBody RegistroPalavraDTO dto) {
		Palavra palavra = palavraService.criaPalavraComAsEtiquetas(dto);
		
		return ResponseEntity.ok(PalavraMapper.fromEntity(palavraService.salvarPalavra(palavra)));
	}
	
	@GetMapping("{id}")
	@PreAuthorize("hasAnyAuthority('admin', 'user')")
	public ResponseEntity<ConsultaPalavraDTO> buscarPalavra(@PathVariable Long id) {
		
		Palavra palavra = palavraService.buscarPalavra(id);
		
		return ResponseEntity.ok(PalavraMapper.fromEntity(palavra));
	}
	
	@PutMapping("{id}")
	@PreAuthorize("hasAuthority('admin')")
	public ResponseEntity<ConsultaPalavraDTO> alteraPalavra(@RequestBody RegistroPalavraDTO dto, @PathVariable Long id) {
		try {
			Palavra palavra = palavraService.atualizarPalavra(dto, id);
			
			return ResponseEntity.ok(PalavraMapper.fromEntity(palavra));
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("{id}")
	@PreAuthorize("hasAuthority('admin')")
	public ResponseEntity<ConsultaPalavraDTO> excluirPalavra(@PathVariable Long id) {
		try {
			palavraService.excluirPalavra(id);
			
			return ResponseEntity.ok().build();
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("buscarPorEtiqueta")
	@PreAuthorize("hasAnyAuthority('admin', 'user')")
	public ResponseEntity<Page<ConsultaPalavraDTO>> buscarPalavraPorEtiqueta(@RequestParam String etiqueta, @PageableDefault Pageable pageable) {
		return ResponseEntity.ok(palavraService.buscarPalavraPorEtiqueta(etiqueta, pageable).map(PalavraMapper::fromEntity));
	}

}
