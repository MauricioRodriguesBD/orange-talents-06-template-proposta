package com.zup.academy.mauricio.proposta.outros;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zup.academy.mauricio.proposta.cartao.CartaoResponse;
import com.zup.academy.mauricio.proposta.criaproposta.Proposta;
import com.zup.academy.mauricio.proposta.criaproposta.PropostaRepository;
import com.zup.academy.mauricio.proposta.criaproposta.status.StatusAvaliacao;
import com.zup.academy.mauricio.proposta.integracao.CartaoClienteFeign;

@Component
public class AssociarCartaoComProposta {

	@Autowired
	private PropostaRepository repository;
	
	@Autowired
	private CartaoClienteFeign associa;
	
	@Scheduled(fixedDelayString = "${periodicidade.executa-operacao}")
	@Transactional
	public void associaCartoesComProposta() {
		
		List<Proposta> propostasAceitas = repository.findByStatusAvaliacao(StatusAvaliacao.ELEGIVEL);
		
		while(propostasAceitas.size()>0) {
			Proposta proposta = propostasAceitas.get(0);
			CartaoResponse response = associa.associarCartaoComProposta(proposta.toCartaoRequest());
		}
		
	}
}
