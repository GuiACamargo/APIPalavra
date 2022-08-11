package com.gft.palavra.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.palavra.entities.Palavra;

@Repository
public interface PalavraRepository extends JpaRepository<Palavra, Long> {

	Page<Palavra> findAll(Pageable pageable);
	
	Optional<Palavra> findByPalavra (String palavra);

	Page<Palavra> findByEtiquetasEtiquetaContains(String etiqueta, Pageable pageable);

}
