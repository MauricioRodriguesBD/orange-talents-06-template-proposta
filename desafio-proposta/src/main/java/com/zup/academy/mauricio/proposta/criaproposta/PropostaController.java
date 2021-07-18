package com.zup.academy.mauricio.proposta.criaproposta;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/proposta")
public class PropostaController {

	@Autowired
	private PropostaRepository repository;
	
	@PostMapping
	@Transactional
	public  ResponseEntity<?>cria(@Valid @RequestBody PropostaRequest request, UriComponentsBuilder builder){
		Proposta proposta = request.toModel();
		repository.save(proposta);
		URI uri =  builder.path("/proposta/{id}").build(proposta.getId());
		return ResponseEntity.created(uri).build();
		
	}
	
}
