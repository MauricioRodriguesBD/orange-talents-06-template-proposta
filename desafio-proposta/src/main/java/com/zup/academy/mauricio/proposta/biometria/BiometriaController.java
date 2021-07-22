package com.zup.academy.mauricio.proposta.biometria;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.zup.academy.mauricio.proposta.cartao.Cartao;

@RestController
@RequestMapping("/biometria")
public class BiometriaController {

	@Autowired
	private BiometriaRepository repository;

	@PersistenceContext
	private EntityManager manager;

	@PostMapping("/{id}")
	@Transactional
	public ResponseEntity<?> cria(@PathVariable("id") Long id, @Valid @RequestBody BiometriaRequest request,
			UriComponentsBuilder builder) {

		Cartao cartao = manager.find(Cartao.class, id);
		Biometria biometria = request.toModel(cartao);
//		biometria.encodaFinger(request.getFingerPrint());

		repository.save(biometria);

		URI uri = builder.path("cartao/{id}/biometria/{id}").build(biometria.getId());
		return ResponseEntity.created(uri).build();

	}
}
