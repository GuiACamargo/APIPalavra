package com.gft.palavra.dto.usuario;

public class ConsultaUsuarioDTO {

	private String email;
	private String nomePerfil;
	
	public ConsultaUsuarioDTO(String email, String nomePerfil) {
		this.email = email;
		this.nomePerfil = nomePerfil;
	}

	public ConsultaUsuarioDTO() {

	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomePerfil() {
		return nomePerfil;
	}
	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}
	
}
