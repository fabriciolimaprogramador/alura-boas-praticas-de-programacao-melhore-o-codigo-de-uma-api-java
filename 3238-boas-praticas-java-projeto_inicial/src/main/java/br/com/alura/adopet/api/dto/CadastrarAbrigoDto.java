package br.com.alura.adopet.api.dto;

import jakarta.validation.constraints.NotBlank;

public class CadastrarAbrigoDto {

	@NotBlank
	private String nome;
	@NotBlank
	private String telefone;
	@NotBlank
	private String email;

	public CadastrarAbrigoDto(String nome, String telefone, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

}
