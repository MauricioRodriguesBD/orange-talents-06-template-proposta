package com.zup.academy.mauricio.proposta.renegociacao;

import java.time.LocalDateTime;

import com.zup.academy.mauricio.proposta.cartao.Cartao;

public class RenegociacaoRequest {

	private Integer quantidade;

	private Number valor;

	private LocalDateTime dataDeCriacao;

	public RenegociacaoRequest(Integer quantidade, Number valor, LocalDateTime dataDeCriacao) {
		super();
		this.quantidade = quantidade;
		this.valor = valor;
		this.dataDeCriacao = dataDeCriacao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Number getValor() {
		return valor;
	}

	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	}

	public Renegociacao toModel(Cartao cartao) {
		return new Renegociacao(this.quantidade, this.valor, this.dataDeCriacao, cartao);
	}
}
