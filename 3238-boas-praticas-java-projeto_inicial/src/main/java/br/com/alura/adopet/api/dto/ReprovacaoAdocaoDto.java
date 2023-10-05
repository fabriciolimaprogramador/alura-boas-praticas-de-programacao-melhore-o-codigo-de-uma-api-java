package br.com.alura.adopet.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ReprovacaoAdocaoDto {

	@NotNull
	private Long idAdocao;
	@NotBlank
	private String justificativa;

	public ReprovacaoAdocaoDto(Long idAdocao, String justificativa) {
		this.idAdocao = idAdocao;
		this.justificativa = justificativa;
	}

	public Long getIdAdocao() {
		return idAdocao;
	}

	public String getJustificativa() {
		return justificativa;
	}

}
