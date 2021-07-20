package com.zup.academy.mauricio.proposta.integracao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zup.academy.mauricio.proposta.cartao.CartaoRequest;
import com.zup.academy.mauricio.proposta.cartao.CartaoResponse;

@FeignClient(name = "cartoes", url = "http://localhost:8888")
public interface CartaoClienteFeign {

	
		@RequestMapping(method = RequestMethod.POST, value = "/api/cartoes")
		CartaoResponse associarCartaoComProposta(@RequestBody CartaoRequest request);
}


