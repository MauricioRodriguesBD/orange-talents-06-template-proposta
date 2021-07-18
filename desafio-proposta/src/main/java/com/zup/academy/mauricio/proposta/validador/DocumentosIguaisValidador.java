package com.zup.academy.mauricio.proposta.validador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zup.academy.mauricio.proposta.criaproposta.Proposta;
import com.zup.academy.mauricio.proposta.criaproposta.PropostaRepository;
import com.zup.academy.mauricio.proposta.criaproposta.PropostaRequest;

@Component
public class DocumentosIguaisValidador {

	
		@Autowired
		private PropostaRepository repository;
		
		public boolean isValid(PropostaRequest request) {
			Optional<Proposta> procura = repository.findByDocumento(request.getDocumento());
			if(procura.isPresent()) {
				return false;
			}
			return true;
		}
}
