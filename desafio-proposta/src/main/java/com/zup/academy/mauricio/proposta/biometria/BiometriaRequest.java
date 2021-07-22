package com.zup.academy.mauricio.proposta.biometria;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.zup.academy.mauricio.proposta.cartao.Cartao;

public class BiometriaRequest {

	@NotBlank
	private String fingerPrint;
	
//	private String cartao;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public BiometriaRequest(String fingerPrint) {
		super();
		this.fingerPrint = fingerPrint;
	}

	public String getFingerPrint() {
		return fingerPrint;
	}

	public Biometria toModel(Cartao cartao) {
		
		
		return new Biometria(fingerPrint,cartao);
	}

}
