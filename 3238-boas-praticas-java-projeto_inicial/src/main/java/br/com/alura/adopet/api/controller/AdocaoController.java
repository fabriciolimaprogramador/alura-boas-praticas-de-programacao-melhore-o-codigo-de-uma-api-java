package br.com.alura.adopet.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.service.AdocaoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/adocoes")
public class AdocaoController {
	
	@Autowired
	private AdocaoService adocaoService;

    @PostMapping
    public ResponseEntity<String> solicitar(@RequestBody @Valid Adocao adocao) {
    	try {
    		this.adocaoService.solicitar(adocao);
    		return ResponseEntity.ok("Adoção solicitado com sucesso!");
		} catch (ValidacaoException e) {
    		return ResponseEntity.badRequest().body(e.getMessage());
		}
    }

    @PutMapping("/aprovar")
    public ResponseEntity<String> aprovar(@RequestBody @Valid Adocao adocao) {
    	this.adocaoService.aprovar(adocao);
    	return ResponseEntity.ok().build();
    }

    @PutMapping("/reprovar")
    public ResponseEntity<String> reprovar(@RequestBody @Valid Adocao adocao) {
    	this.adocaoService.reprovar(adocao);
    	return ResponseEntity.ok().build();
    }

}
