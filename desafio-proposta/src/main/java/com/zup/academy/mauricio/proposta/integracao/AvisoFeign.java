package com.zup.academy.mauricio.proposta.integracao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.zup.academy.mauricio.proposta.aviso.AvisoRequest;
import com.zup.academy.mauricio.proposta.aviso.AvisoResponse;

@FeignClient(name="avisos",
url = "http://localhost:8888")
public interface AvisoFeign {

		
	@PostMapping("/{id}/avisos")
	public AvisoResponse aviso(@PathVariable Long id,AvisoRequest request);
}
