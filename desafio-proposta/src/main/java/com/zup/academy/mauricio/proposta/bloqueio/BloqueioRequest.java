package com.zup.academy.mauricio.proposta.bloqueio;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zup.academy.mauricio.proposta.cartao.Cartao;

public class BloqueioRequest {

	@NotBlank
	private String sistemaResponsavel;

	public BloqueioRequest(@NotBlank String sistemaResponsavel) {
		super();
		this.sistemaResponsavel = sistemaResponsavel;
	}

	public String getSistemaResponsavel() {
		return sistemaResponsavel;
	}

}
