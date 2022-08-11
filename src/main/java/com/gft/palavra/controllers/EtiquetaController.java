package com.gft.palavra.controllers;

import com.gft.palavra.dto.etiqueta.ConsultaEtiquetaDTO;
import com.gft.palavra.dto.etiqueta.EtiquetaMapper;
import com.gft.palavra.dto.etiqueta.RegistroEtiquetaDTO;
import com.gft.palavra.service.EtiquetaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/etiquetas")
public class EtiquetaController {

    private final EtiquetaService etiquetaService;

    public EtiquetaController(EtiquetaService etiquetaService) {
        this.etiquetaService = etiquetaService;
    }

    @GetMapping
	@PreAuthorize("hasAnyAuthority('admin', 'user')")
    public ResponseEntity<Page<ConsultaEtiquetaDTO>> buscarTodasAsEtiquetas(@PageableDefault Pageable pageable){
        return ResponseEntity.ok(etiquetaService.listarTodasAsEtiquetas(pageable).map(EtiquetaMapper::fromEntity));
    }

    @GetMapping("{id}")
	@PreAuthorize("hasAnyAuthority('admin', 'user')")
    public ResponseEntity<ConsultaEtiquetaDTO> buscarEtiqueta(@PathVariable Long id){
        return ResponseEntity.ok(EtiquetaMapper.fromEntity(etiquetaService.buscarEtiquetaPorId(id)));
    }

    @PostMapping
	@PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<ConsultaEtiquetaDTO> salvarEtiqueta(@RequestBody RegistroEtiquetaDTO dto){
        return ResponseEntity.ok(EtiquetaMapper.fromEntity(etiquetaService.salvarEtiqueta(EtiquetaMapper.fromDTO(dto))));
    }

    @PutMapping("{id}")
	@PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<ConsultaEtiquetaDTO> alterarEtiqueta(@PathVariable Long id, @RequestBody RegistroEtiquetaDTO dto){
        try {
            return ResponseEntity.ok(EtiquetaMapper.fromEntity(etiquetaService.atualizarEtiqueta(EtiquetaMapper.fromDTO(dto), id)));
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
	@PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<ConsultaEtiquetaDTO> excluirEtiqueta(@PathVariable Long id){
        try {
            etiquetaService.excluirEtiqueta(id);

            return ResponseEntity.ok().build();
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("buscarEtiquetaPorPalavra")
    public ResponseEntity<Page<ConsultaEtiquetaDTO>> buscarEtiquetaPorPalavra(@RequestParam String palavra, @PageableDefault Pageable pageable){
        return ResponseEntity.ok(etiquetaService.buscarEtiquetaPorPalavra(palavra, pageable).map(EtiquetaMapper::fromEntity));
    }
}
