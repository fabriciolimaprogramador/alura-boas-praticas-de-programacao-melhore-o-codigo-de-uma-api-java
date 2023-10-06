package br.com.alura.adopet.api.dto;

public class AbrigoResponseDto {

	private String nome;
	private String telefone;
	private String email;

	public AbrigoResponseDto(String nome, String telefone, String email) {
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
