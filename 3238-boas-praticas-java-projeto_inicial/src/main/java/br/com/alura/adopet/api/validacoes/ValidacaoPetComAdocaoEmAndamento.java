package br.com.alura.adopet.api.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;

@Component
public class ValidacaoPetComAdocaoEmAndamento implements ValidacaoSolicitacaoAdocao {

	@Autowired
	private AdocaoRepository adocaoRepository;
	
//	@Autowired
//	private PetRepository petRepository;

	public void validar(SolicitacaoAdocaoDto dto) {
//		List<Adocao> adocoes = adocaoRepository.findAll();
		boolean petTemAdocaoEmAdamento = adocaoRepository.existsByPedIdAndStatus(dto.getIdPet(), StatusAdocao.AGUARDANDO_AVALIACAO);
//		Pet pet = petRepository.getReferenceById(dto.getIdPet());
//		for (Adocao a : adocoes) {
			if (petTemAdocaoEmAdamento) {
				throw new ValidacaoException("Pet já está aguardando avaliação para ser adotado!");
			}
//		}
	}

}
