package com.zup.academy.mauricio.proposta.vencimento;

import java.time.LocalDateTime;

import com.zup.academy.mauricio.proposta.cartao.Cartao;

public class VencimentoRequest {
		
	
	private  Integer dia;
	
	private LocalDateTime dataDeCriacao;

	public VencimentoRequest(Integer dia, LocalDateTime dataDeCriacao) {
		super();
		this.dia = dia;
		this.dataDeCriacao = dataDeCriacao;
	}

	public Integer getDia() {
		return dia;
	}

	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	}
	
	public Vencimento toModel(Cartao cartao) {
		return new Vencimento(this.dia, this.dataDeCriacao, cartao);
	}
}
