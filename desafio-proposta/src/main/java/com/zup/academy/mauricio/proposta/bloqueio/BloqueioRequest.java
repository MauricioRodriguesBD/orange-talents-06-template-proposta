package com.zup.academy.mauricio.proposta.bloqueio;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zup.academy.mauricio.proposta.cartao.Cartao;

public class BloqueioRequest {

	private LocalDateTime bloqueadoEm;

	@NotBlank
	private String sistemaResponsavel;

	@NotNull
	private boolean ativo;

	public BloqueioRequest(LocalDateTime bloqueadoEm, @NotBlank String sistemaResponsavel, @NotNull boolean ativo) {
		super();
		this.bloqueadoEm = bloqueadoEm;
		this.sistemaResponsavel = sistemaResponsavel;
		this.ativo = ativo;
	}

	public LocalDateTime getBloqueadoEm() {
		return bloqueadoEm;
	}

	public String getSistemaResponsavel() {
		return sistemaResponsavel;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public Bloqueio toModel(Cartao cartao) {
		return new Bloqueio(this.bloqueadoEm, this.sistemaResponsavel, this.ativo, cartao);
	}

}
