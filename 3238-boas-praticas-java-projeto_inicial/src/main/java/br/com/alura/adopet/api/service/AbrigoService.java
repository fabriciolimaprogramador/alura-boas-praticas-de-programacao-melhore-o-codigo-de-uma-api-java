package br.com.alura.adopet.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.alura.adopet.api.dto.AbrigoResponseDto;
import br.com.alura.adopet.api.dto.CadastrarAbrigoDto;
import br.com.alura.adopet.api.dto.PetResponseDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class AbrigoService {

	@Autowired
	private AbrigoRepository repository;

	public List<AbrigoResponseDto> listar() {
		List<Abrigo> abrigos = repository.findAll();
		List<AbrigoResponseDto> lista = new ArrayList<>();
		for (Abrigo abrigo : abrigos) {
			lista.add(new AbrigoResponseDto(abrigo.getNome(), abrigo.getTelefone(), abrigo.getEmail()));
		}
		return lista;
	}

	@Transactional
	public void cadastrar(CadastrarAbrigoDto dto) {
		boolean nomeJaCadastrado = repository.existsByNome(dto.getNome());
		boolean telefoneJaCadastrado = repository.existsByTelefone(dto.getTelefone());
		boolean emailJaCadastrado = repository.existsByEmail(dto.getEmail());

		if (nomeJaCadastrado || telefoneJaCadastrado || emailJaCadastrado) {
			throw new ValidacaoException("Dados já cadastrados para outro abrigo!");
		}

		Abrigo abrigo = new Abrigo();
		abrigo.setNome(dto.getNome());
		abrigo.setTelefone(dto.getTelefone());
		abrigo.setEmail(dto.getEmail());

		repository.save(abrigo);

	}

	public List<PetResponseDto> listarPets(String idOuNome) {

		List<PetResponseDto> lista = new ArrayList<>();

		boolean pesquisarPorId = true;
		Long id = 0L;
		try {
			id = Long.parseLong(idOuNome);
		} catch (NumberFormatException e) {
			pesquisarPorId = false;
		}

		List<Pet> pets = null;
		if (pesquisarPorId) {
			pets = repository.getReferenceById(id).getPets();
		} else {
			pets = repository.findByNome(idOuNome).getPets();
		}
		for (Pet pet : pets) {
			lista.add(new PetResponseDto(pet.getId(), pet.getTipo(), pet.getNome(), pet.getRaca(), pet.getIdade(),
					pet.getCor(), pet.getPeso(), pet.getAdotado()));
		}

		return lista;
	}

	public void cadastrarPet(String idOuNome, Pet pet) {

	}

}