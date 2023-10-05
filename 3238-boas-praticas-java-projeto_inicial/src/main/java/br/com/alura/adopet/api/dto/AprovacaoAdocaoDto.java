package br.com.alura.adopet.api.dto;

import jakarta.validation.constraints.NotNull;

public class AprovacaoAdocaoDto {
	
	@NotNull
	private Long idAdocao;

	public AprovacaoAdocaoDto(Long idAdocao) {
		this.idAdocao = idAdocao;
	}

	public Long getIdAdocao() {
		return idAdocao;
	}
	
	

}
