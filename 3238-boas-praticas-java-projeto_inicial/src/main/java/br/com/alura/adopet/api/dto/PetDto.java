package br.com.alura.adopet.api.dto;

import br.com.alura.adopet.api.model.TipoPet;

public class PetDto {
	private Long id;
	private TipoPet tipo;
	private String nome;
	private String raca;
	private Integer idade;
	
	public PetDto() {}

	public PetDto(Long id, TipoPet tipo, String nome, String raca, Integer idade, String cor, Float peso,
			Boolean adotado) {
		this.id = id;
		this.tipo = tipo;
		this.nome = nome;
		this.raca = raca;
		this.idade = idade;
	}

	public Long getId() {
		return id;
	}

	public TipoPet getTipo() {
		return tipo;
	}

	public String getNome() {
		return nome;
	}

	public String getRaca() {
		return raca;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTipo(TipoPet tipo) {
		this.tipo = tipo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	


}
