package com.zup.academy.mauricio.proposta.criaproposta;

public enum RetornoAvaliacao {

	SEMRESTRICAO(StatusAvaliacao.ELEGIVEL),
	COMRESTRICAO(StatusAvaliacao.NAOELEGIVEL);

	private StatusAvaliacao statusAvaliacao;

	

	private RetornoAvaliacao(StatusAvaliacao statusAvaliacao) {
		this.statusAvaliacao = statusAvaliacao;
	}



	public StatusAvaliacao getStatusAvaliacao() {
		return statusAvaliacao;
	}

}
