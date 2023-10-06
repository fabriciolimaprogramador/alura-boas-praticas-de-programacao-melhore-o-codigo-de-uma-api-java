package br.com.alura.adopet.api.dto;

import br.com.alura.adopet.api.model.TipoPet;

public class PetRequestDto {

	private Long id;
	private TipoPet tipo;
	private String nome;
	private String raca;
	private Integer idade;
	private String cor;
	private Float peso;
	private Boolean adotado;

	public PetRequestDto(Long id, TipoPet tipo, String nome, String raca, Integer idade, String cor, Float peso,
			Boolean adotado) {
		this.id = id;
		this.tipo = tipo;
		this.nome = nome;
		this.raca = raca;
		this.idade = idade;
		this.cor = cor;
		this.peso = peso;
		this.adotado = adotado;
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

	public String getCor() {
		return cor;
	}

	public Float getPeso() {
		return peso;
	}

	public Boolean getAdotado() {
		return adotado;
	}

}
