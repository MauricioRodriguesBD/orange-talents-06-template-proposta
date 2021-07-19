package com.zup.academy.mauricio.proposta.criaproposta;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zup.academy.mauricio.proposta.validador.CpfOrCnpj;

public class StatusPropostaRequest {

	@CpfOrCnpj
	@NotNull
	private String documento;
	
	@NotBlank
	private String nome;
	
	@NotNull
	private Long idProposta;

	public StatusPropostaRequest(Proposta proposta) {
		super();
		this.documento = proposta.getDocumento();
		this.nome = proposta.getNome();
		this.idProposta = proposta.getId();
	}

	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}

	public Long getIdProposta() {
		return idProposta;
	}
	
	
}
