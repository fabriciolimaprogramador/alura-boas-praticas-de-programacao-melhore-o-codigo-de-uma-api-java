package br.com.alura.adopet.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.adopet.api.dto.PetsDisponiveisDto;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.PetRepository;

@Service
public class PetService {

	@Autowired
	private PetRepository repository;

	public List<PetsDisponiveisDto> listarTodosDisponiveis() {
		List<Pet> pets = repository.findByAdotado(false);
		List<PetsDisponiveisDto> disponiveis = new ArrayList<>();
		for (Pet pet : pets) {
			PetsDisponiveisDto petDisponivel = new PetsDisponiveisDto(
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

}
