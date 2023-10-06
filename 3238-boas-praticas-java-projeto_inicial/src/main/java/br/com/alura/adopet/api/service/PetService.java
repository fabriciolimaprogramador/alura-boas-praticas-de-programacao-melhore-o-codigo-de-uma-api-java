package br.com.alura.adopet.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.adopet.api.dto.PetDto;
import br.com.alura.adopet.api.dto.PetRecordDto;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.PetRepository;

@Service
public class PetService {

	@Autowired
	private PetRepository repository;

	public List<PetDto> buscarPetsDisponiveis() {
		List<Pet> pets = repository.findAllByAdotadoFalse();
		List<PetDto> disponiveis = new ArrayList<>();
		for (Pet pet : pets) {
			PetDto petDisponivel = new PetDto(
					pet.getId(), 
					pet.getTipo(), 
					pet.getNome(),
					pet.getRaca(), 
					pet.getIdade(), 
					pet.getCor(), 
					pet.getPeso(), 
					pet.getAdotado());
			disponiveis.add(petDisponivel);
		}
		return disponiveis;
	}
	
	public List<PetDto> buscarPetsDisponiveisStreamMapClass() {
		return repository.findAllByAdotadoFalse().stream().map(p -> new PetDto()).toList();
	}

	//Usando Record
	public List<PetRecordDto> buscarPetsDisponiveisStreamMapRecord() {
		return repository.findAllByAdotadoFalse().stream().map(PetRecordDto::new).toList();
	}

}
