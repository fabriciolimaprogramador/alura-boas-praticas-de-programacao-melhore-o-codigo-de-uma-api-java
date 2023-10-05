package br.com.alura.adopet.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SolicitacaoAdocaoDto {

	@NotNull
	private Long idPet;
	@NotNull
	private Long idTutor;
	@NotBlank
	private String motivo;

	public SolicitacaoAdocaoDto(Long idPet, Long idTutor, String motivo) {
		this.idPet = idPet;
		this.idTutor = idTutor;
		this.motivo = motivo;
	}

	public Long getIdPet() {
		return idPet;
	}

	public Long getIdTutor() {
		return idTutor;
	}

	public String getMotivo() {
		return motivo;
	}

}
