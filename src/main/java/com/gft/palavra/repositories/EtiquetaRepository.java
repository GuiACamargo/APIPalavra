package com.gft.palavra.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.palavra.entities.Etiqueta;

@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {
    Page<Etiqueta> findAll(Pageable pageable);
    
    Optional<Etiqueta> findByEtiqueta(String etiqueta);

    Page<Etiqueta> findByPalavrasPalavraContains(String palavra, Pageable pageable);
}
