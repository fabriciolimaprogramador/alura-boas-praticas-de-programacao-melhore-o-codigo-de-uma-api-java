package br.com.alura.adopet.api.dto;

import br.com.alura.adopet.api.model.TipoPet;

public class CadastroPetDto {

	private TipoPet tipo;
	private String nome;
	private String raca;
	private Integer idade;
	private String cor;
	private Float peso;

	public CadastroPetDto(TipoPet tipo, String nome, String raca, Integer indade, String cor, Float peso) {
		this.tipo = tipo;
		this.nome = nome;
		this.raca = raca;
		this.idade = indade;
		this.cor = cor;
		this.peso = peso;
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

}
