package com.gft.palavra.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.palavra.entities.Etiqueta;
import com.gft.palavra.exception.EntityNotFoundException;
import com.gft.palavra.repositories.EtiquetaRepository;

@Service
public class EtiquetaService {

    private final EtiquetaRepository etiquetaRepository;

    public EtiquetaService(EtiquetaRepository etiquetaRepository) {
        this.etiquetaRepository = etiquetaRepository;
    }

    public Etiqueta salvarEtiqueta(Etiqueta etiqueta){
        return etiquetaRepository.save(etiqueta);
    }

    public Page<Etiqueta> listarTodasAsEtiquetas(Pageable pageable){
        return etiquetaRepository.findAll(pageable);
    }

    public Etiqueta buscarEtiquetaPorId(Long id){
        return etiquetaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Etiqueta não encontrada"));
    }

    public Etiqueta atualizarEtiqueta(Etiqueta etiqueta, Long id){
        Etiqueta etiquetaOriginal = buscarEtiquetaPorId(id);

        etiqueta.setId(etiquetaOriginal.getId());

        return salvarEtiqueta(etiqueta);
    }

    public void excluirEtiqueta(Long id) {
        Etiqueta etiqueta = buscarEtiquetaPorId(id);

        etiquetaRepository.delete(etiqueta);
    }

    public Page<Etiqueta> buscarEtiquetaPorPalavra(String palavra, Pageable pageable){
        return etiquetaRepository.findByPalavrasPalavraContains(palavra, pageable);
    }
}
