package com.gft.palavra.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.palavra.dto.usuario.ConsultaUsuarioDTO;
import com.gft.palavra.dto.usuario.RegistroUsuarioDTO;
import com.gft.palavra.dto.usuario.UsuarioMapper;
import com.gft.palavra.entities.Usuario;
import com.gft.palavra.service.UsuarioService;

@RestController
@RequestMapping("v1/usuarios")
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	@PreAuthorize("hasAnyAuthority('admin', 'user')")
	public ResponseEntity<Page<ConsultaUsuarioDTO>> buscarTodosOsUsuarios(@PageableDefault Pageable pageable) {
		return ResponseEntity.ok(usuarioService.listarTodosOsUsuarios(pageable).map(UsuarioMapper::fromEntity));
	}

	@PostMapping
	@PreAuthorize("hasAuthority('admin')")
	public ResponseEntity<ConsultaUsuarioDTO> salvarUsuario(@RequestBody RegistroUsuarioDTO dto) {
		Usuario usuario = usuarioService.salvarUsuario(UsuarioMapper.fromDTO(dto));
		
		return ResponseEntity.ok(UsuarioMapper.fromEntity(usuario));
	}
	
	@GetMapping("{id}")
	@PreAuthorize("hasAnyAuthority('admin', 'user')")
	public ResponseEntity<ConsultaUsuarioDTO> buscarUsuario(@PathVariable Long id) {
		Usuario usuario = usuarioService.buscarUsuarioPorId(id);
		
		return ResponseEntity.ok(UsuarioMapper.fromEntity(usuario));
	}
	
	@PutMapping("{id}")
	@PreAuthorize("hasAuthority('admin')")
	public ResponseEntity<ConsultaUsuarioDTO> alterarUsuario(@RequestBody RegistroUsuarioDTO dto, @PathVariable Long id) {
		try {
			Usuario usuario = usuarioService.atualizarUsuario(UsuarioMapper.fromDTO(dto), id);
			
			return ResponseEntity.ok(UsuarioMapper.fromEntity(usuario));
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("{id}")
	@PreAuthorize("hasAuthority('admin')")
	public ResponseEntity<ConsultaUsuarioDTO> excluirUsuario(@PathVariable Long id) {
		try {
			usuarioService.excluirUsuario(id);
			
			return ResponseEntity.ok().build();
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	
//GET DA SENHA ENCRIPTADA, NO CASO 1234	
//	public static void main(String args[]) {
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		
//		System.out.println(bCryptPasswordEncoder.encode("1234"));
//	}

}
