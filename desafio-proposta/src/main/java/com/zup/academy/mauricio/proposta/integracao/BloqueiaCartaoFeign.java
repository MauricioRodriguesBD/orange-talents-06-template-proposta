package com.zup.academy.mauricio.proposta.integracao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.zup.academy.mauricio.proposta.bloqueio.BloqueioRequest;
import com.zup.academy.mauricio.proposta.bloqueio.BloqueioResponse;
import com.zup.academy.mauricio.proposta.cartao.CartaoResponse;

@FeignClient(name = "cartoes",
			url = "http://localhost:8888")
public interface BloqueiaCartaoFeign {

	@PostMapping("/{id}/bloqueios")
	public BloqueioResponse bloqueio (@PathVariable Long id, BloqueioRequest request);
	
	@GetMapping("/{id}")
	public CartaoResponse busca(@PathVariable Long id);
}
