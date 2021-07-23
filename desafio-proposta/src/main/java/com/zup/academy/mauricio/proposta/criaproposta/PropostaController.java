package com.zup.academy.mauricio.proposta.criaproposta;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.zup.academy.mauricio.proposta.criaproposta.status.StatusAvaliacao;
import com.zup.academy.mauricio.proposta.integracao.FeignTeste;
import com.zup.academy.mauricio.proposta.outros.AssociarCartaoComProposta;
import com.zup.academy.mauricio.proposta.validador.DocumentosIguaisValidador;

import feign.FeignException;

@RestController
@RequestMapping("/proposta")
public class PropostaController {

	@Autowired
	private PropostaRepository repository;

	private FeignTeste testeFeign;

	public PropostaController(PropostaRepository repository, FeignTeste teste,
			DocumentosIguaisValidador documentosIguaisValidador) {
		super();
		this.repository = repository;
		this.testeFeign = teste;
		this.documentosIguaisValidador = documentosIguaisValidador;
	}

	@Autowired
	private DocumentosIguaisValidador documentosIguaisValidador;

	private AssociarCartaoComProposta associa;

	@GetMapping("/{id}")
	public ResponseEntity<?> busca(@PathVariable("id") Long id) {
		Optional<Proposta> proposta = repository.findById(id);
		if (proposta.isPresent()) {
			return ResponseEntity.ok(proposta);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> cria(@Valid @RequestBody PropostaRequest request, UriComponentsBuilder builder) {
//		Optional<Proposta> existe = repository.findByDocumento(request.getDocumento());
//		if(existe.isPresent()) {
//		System.out.println("Proposta com esse documento já foi criada!");
//			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
//		}

		if (!documentosIguaisValidador.isValid(request)) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		Proposta proposta = request.toModel();
		repository.save(proposta);

		try {
			StatusPropostaRequest statusRequest = new StatusPropostaRequest(proposta);
			StatusPropostaResponse statusResponse = testeFeign.cria(statusRequest);
			proposta.setStatusAvaliacao(StatusAvaliacao.mapeamento(statusResponse.getRetorno()));
			//Teste de persistência
			proposta.setStatusAvaliacao(StatusAvaliacao.ELEGIVEL);
			repository.save(proposta);

		} catch (FeignException e) {
			URI urie = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(proposta.getId())
					.toUri();
			return ResponseEntity.created(urie).build();
		}
		URI uri = builder.path("/proposta/{id}").build(proposta.getId());
		return ResponseEntity.created(uri).build();

	}

}
