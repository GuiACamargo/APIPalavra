package com.gft.palavra.config;

import com.gft.palavra.entities.Etiqueta;
import com.gft.palavra.repositories.EtiquetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gft.palavra.entities.Palavra;
import com.gft.palavra.entities.Perfil;
import com.gft.palavra.entities.Usuario;
import com.gft.palavra.repositories.PalavraRepository;
import com.gft.palavra.repositories.PerfilRepository;
import com.gft.palavra.repositories.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class StartCommand implements CommandLineRunner {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	PerfilRepository perfilRepository;
	
	@Autowired
	PalavraRepository palavraRepository;

	@Autowired
	EtiquetaRepository etiquetaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Etiqueta etiqueta = new Etiqueta();
		etiqueta.setEtiqueta("Matéria Prima");

		Palavra palavra = new Palavra(null, "Pedra", 5, null);
		
		if(etiquetaRepository.findByEtiqueta("Matéria Prima").isEmpty()) {
			etiquetaRepository.save(etiqueta);
		}
		
		if (palavraRepository.findByPalavra("Pedra").isEmpty()) {
			List<Etiqueta> etiquetas = new ArrayList<>();
			etiquetas.add(etiquetaRepository.findByEtiqueta("Matéria Prima").get());
			palavra.setEtiquetas(etiquetas);
			palavraRepository.save(palavra);
		}

		Perfil p1 = new Perfil(null, "admin");
		Perfil p2 = new Perfil(null, "user");
		
		if (perfilRepository.findByNome("admin").isEmpty()) {
			perfilRepository.save(p1);
		}
		if (perfilRepository.findByNome("user").isEmpty()) {
			perfilRepository.save(p2);
		}
		
		Usuario u1 = new Usuario(null, "admin@gft.com", new BCryptPasswordEncoder().encode("1234"), p1);
		Usuario u2 = new Usuario(null, "usuario@gft.com", new BCryptPasswordEncoder().encode("1234"), p2);
		
		if (usuarioRepository.findByEmail("admin@gft.com").isEmpty()) {
			usuarioRepository.save(u1);
		}
		if (usuarioRepository.findByEmail("usuario@gft.com").isEmpty()) {
			usuarioRepository.save(u2);
		}
		
	}
}
