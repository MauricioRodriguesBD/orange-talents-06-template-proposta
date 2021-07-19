package com.zup.academy.mauricio.proposta.criaproposta;

public class StatusPropostaResponse {
		
	
	private String documento;
	
	private String nome;
	
	private Long idProposta;
	
	private RetornoAvaliacao retorno;

	private String status;

	public StatusPropostaResponse(String documento, String nome, Long idProposta, RetornoAvaliacao retorno,
			String status) {
		super();
		this.documento = documento;
		this.nome = nome;
		this.idProposta = idProposta;
		this.retorno = retorno;
		this.status = status;
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

	public RetornoAvaliacao getRetorno() {
		return retorno;
	}

	public String getStatus() {
		return status;
	}
	
	
	
}
