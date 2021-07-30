package com.zup.academy.mauricio.proposta.aviso;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServlet;
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
import com.zup.academy.mauricio.proposta.integracao.AvisoFeign;
import com.zup.academy.mauricio.proposta.integracao.BloqueiaCartaoFeign;

import feign.FeignException;

@RestController
@RequestMapping("/aviso")
public class AvisoController {

	
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private AvisoFeign avisoFeign;
	
	@Autowired
	private BloqueiaCartaoFeign cartaoFeign;
	
	@PostMapping("{id}")
	@Transactional
	public ResponseEntity<?> cria(@Valid @PathVariable("id")Long id,AvisoRequest request,
									HttpServlet requestServlet,@RequestHeader("user-agent")String userAgent){
		Cartao cartao = Optional.ofNullable(manager.find(Cartao.class,id))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id não encontrado"));
		
		try {
			 avisoFeign.aviso(cartao.getId(), request);
			 CartaoResponse response = cartaoFeign.busca(cartao.getId());
			 
			 Aviso aviso = (Aviso) response.getAvisos();
			 aviso.setInformacoesDeRequest(userAgent, userAgent, cartao);
			 cartao.addAviso(aviso);
			 manager.merge(cartao);
			 
			 
		}
		catch(FeignException e) {
			System.out.println("Deu ruim");
			return ResponseEntity.unprocessableEntity().build();
			
		}
				return ResponseEntity.ok(cartao);
	}
	
	
	
}
