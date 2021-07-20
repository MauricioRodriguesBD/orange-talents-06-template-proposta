package com.zup.academy.mauricio.proposta.integracao;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.zup.academy.mauricio.proposta.criaproposta.StatusPropostaRequest;
import com.zup.academy.mauricio.proposta.criaproposta.StatusPropostaResponse;

@FeignClient(name = "solicitacao", url ="http://localhost:9999/api/solicitacao")
public interface FeignTeste {

	
	@PostMapping
	StatusPropostaResponse cria(@Valid @RequestBody  StatusPropostaRequest request);
}
