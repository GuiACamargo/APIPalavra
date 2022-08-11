package com.gft.palavra.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gft.palavra.entities.Usuario;
import com.gft.palavra.repositories.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{

	private final UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public Page<Usuario> listarTodosOsUsuarios (Pageable pageable) {
		return usuarioRepository.findAll(pageable);
	}
	
	public Usuario buscarUsuarioPorEmail(String email) {
		Optional<Usuario> optional = usuarioRepository.findByEmail(email);
		
		if(optional.isEmpty()) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		
		return optional.get();
	}
	
	public Usuario atualizarUsuario(Usuario usuario, Long id) {
		Usuario usuarioOriginal = buscarUsuarioPorId(id);
		
		usuario.setId(usuarioOriginal.getId());
		
		return salvarUsuario(usuario);
	}
	
	public void excluirUsuario(Long id) {
		Usuario usuario = buscarUsuarioPorId(id);
		usuarioRepository.delete(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return buscarUsuarioPorEmail(username);
	}

	public Usuario buscarUsuarioPorId(Long idUsuario) {
		Optional<Usuario> optional = usuarioRepository.findById(idUsuario);
		
		if(optional.isEmpty()) {
			throw new RuntimeException("Usuário não encontrado");
		}
		
		return optional.get();
	}
	
	public Usuario salvarUsuario(Usuario usuario) {
		
		return usuarioRepository.save(usuario);
		
	}
	
}
