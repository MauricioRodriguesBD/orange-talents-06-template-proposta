package com.zup.academy.mauricio.proposta.bloqueio;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
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

import com.zup.academy.mauricio.proposta.cartao.Cartao;
import com.zup.academy.mauricio.proposta.cartao.CartaoResponse;
import com.zup.academy.mauricio.proposta.integracao.BloqueiaCartaoFeign;

import feign.FeignException;


@RestController
@RequestMapping("/bloqueio")
public class BloqueioController {

	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private BloqueiaCartaoFeign bloqueia;
	
	@PostMapping("/{id}")
	@Transactional
	public ResponseEntity<?> cria( @Valid @PathVariable("id")Long id,
			HttpServletRequest request,@RequestHeader("user-agent") String userAgent)	{
		Cartao cartao = Optional.ofNullable(manager.find(Cartao.class,id))
				.orElseThrow(() -> new ResponseStatusException
				(HttpStatus.NOT_FOUND,"Não foi possível encontrar esse Id de cartão"));
		try {
			bloqueia.bloqueio(cartao.getId(), new BloqueioRequest("Proposta"));
			CartaoResponse response = bloqueia.busca(cartao.getId());
			Bloqueio bloqueio = response.getUltimoBloqueio();
			bloqueio.setInformacoesDeRequest(request.getRemoteAddr(),userAgent,cartao);
			cartao.addBloqueio(bloqueio);
			manager.merge(cartao);
			
		}
		catch(FeignException e) {
			return ResponseEntity.unprocessableEntity().build();
		}
				return ResponseEntity.ok().build();
		
	
	
	
	
	
	}
}
