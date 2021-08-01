package com.zup.academy.mauricio.proposta.carteira;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.zup.academy.mauricio.proposta.cartao.Cartao;
import com.zup.academy.mauricio.proposta.cartao.CartaoResponse;
import com.zup.academy.mauricio.proposta.integracao.BloqueiaCartaoFeign;
import com.zup.academy.mauricio.proposta.integracao.CarteiraFeign;

import feign.FeignException;

@RestController
@RequestMapping("/carteira")
public class CarteiraController {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private CarteiraFeign carteiraFeign;

	@Autowired
	BloqueiaCartaoFeign cartaoFeign;

	private TipoCarteira tipoCarteira;

	@PostMapping("{id}")
	public ResponseEntity<?> criar(@Valid @PathVariable("id") Long id, CarteiraDigitalRequest request,HttpServletRequest http,
			@RequestHeader("user-agent")String agent, UriComponentsBuilder builder){
		
		Cartao cartao = Optional.ofNullable(manager.find(Cartao.class,id))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possível encontrar o Id"));
		
			try {
				carteiraFeign.carteira(cartao.getId(), request);
				
				CartaoResponse response = cartaoFeign.busca(cartao.getId());
				
				CarteiraDigital carteira = (CarteiraDigital) response.getCarteiras();
				
				if(carteira.getEmissor().isEmpty()) {
					return ResponseEntity.unprocessableEntity().build();
				}
				carteira.setInformacoes(http.getRemoteAddr(), agent, cartao);
				cartao.adiciona(tipoCarteira, carteira);
				manager.merge(cartao);
				return ResponseEntity.created(builder.path("/carteiras/{id}").buildAndExpand(carteira.getId()).toUri()).build();			}
				catch(FeignException e) {
					return ResponseEntity.badRequest().build();
				}
	
	}
}
