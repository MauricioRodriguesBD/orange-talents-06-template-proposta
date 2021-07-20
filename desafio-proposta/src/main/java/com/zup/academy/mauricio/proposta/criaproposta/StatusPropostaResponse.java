package com.zup.academy.mauricio.proposta.criaproposta;

public class StatusPropostaResponse {

	private String documento;

	private String nome;

	private Long idProposta;

	private String retorno;

	public StatusPropostaResponse(String documento, String nome, Long idProposta, String retorno, String status) {
		super();
		this.documento = documento;
		this.nome = nome;
		this.idProposta = idProposta;
		this.retorno = retorno;

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

	public String getRetorno() {
		return retorno;
	}



}
