package com.zup.academy.mauricio.proposta.criaproposta;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.zup.academy.mauricio.proposta.validador.DocumentosIguaisValidador;


@RestController
@RequestMapping("/proposta")
public class PropostaController {

	@Autowired
	private PropostaRepository repository;
	
	@Autowired
	private DocumentosIguaisValidador documentosIguaisValidador;
	
	@PostMapping
	@Transactional
	public  ResponseEntity<?>cria(@Valid @RequestBody PropostaRequest request, UriComponentsBuilder builder){
//		Optional<Proposta> existe = repository.findByDocumento(request.getDocumento());
//		if(existe.isPresent()) {
//		System.out.println("Proposta com esse documento já foi criada!");
//			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
//		}
		
		if(!documentosIguaisValidador.isValid(request)) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		Proposta proposta = request.toModel();
		repository.save(proposta);
		URI uri =  builder.path("/proposta/{id}").build(proposta.getId());
		return ResponseEntity.created(uri).build();
		
	}
	
}
