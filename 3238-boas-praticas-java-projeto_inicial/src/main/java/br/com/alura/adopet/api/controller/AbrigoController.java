package br.com.alura.adopet.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.adopet.api.dto.AbrigoResponseDto;
import br.com.alura.adopet.api.dto.CadastrarAbrigoDto;
import br.com.alura.adopet.api.dto.PetResponseDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import br.com.alura.adopet.api.service.AbrigoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/abrigos")
public class AbrigoController {

	@Autowired
	private AbrigoRepository repository;

	@Autowired
	private AbrigoService service;

	@GetMapping
	public ResponseEntity<List<AbrigoResponseDto>> listar() {
		return ResponseEntity.ok(service.listar());
	}

	@PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody @Valid CadastrarAbrigoDto dto) {
    	try {
    		service.cadastrar(dto);
    		return ResponseEntity.ok().build();
		} catch (ValidacaoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
    }

	@GetMapping("/{idOuNome}/pets")
	public ResponseEntity<List<PetResponseDto>> listarPets(@PathVariable String idOuNome) {
		return ResponseEntity.ok(service.listarPets(idOuNome));
	}

	@PostMapping("/{idOuNome}/pets")
	@Transactional
	public ResponseEntity<String> cadastrarPet(@PathVariable String idOuNome, @RequestBody @Valid Pet pet) {
		try {
			Long id = Long.parseLong(idOuNome);
			Abrigo abrigo = repository.getReferenceById(id);
			pet.setAbrigo(abrigo);
			pet.setAdotado(false);
			abrigo.getPets().add(pet);
			repository.save(abrigo);
			return ResponseEntity.ok().build();
		} catch (EntityNotFoundException enfe) {
			return ResponseEntity.notFound().build();
		} catch (NumberFormatException nfe) {
			try {
				Abrigo abrigo = repository.findByNome(idOuNome);
				pet.setAbrigo(abrigo);
				pet.setAdotado(false);
				abrigo.getPets().add(pet);
				repository.save(abrigo);
				return ResponseEntity.ok().build();
			} catch (EntityNotFoundException enfe) {
				return ResponseEntity.notFound().build();
			}
		}
	}

}
