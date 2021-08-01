package com.zup.academy.mauricio.proposta.integracao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.zup.academy.mauricio.proposta.carteira.CarteiraDigitalRequest;
import com.zup.academy.mauricio.proposta.carteira.CarteiraDigitalResponse;

@FeignClient(name="carteira",
			url = "http://localhost:8888")
public interface CarteiraFeign {
	
	@PostMapping("/{id}/carteiras")
	public CarteiraDigitalResponse carteira(@PathVariable Long id, CarteiraDigitalRequest request);

}
