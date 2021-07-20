package com.zup.academy.mauricio.proposta.renegociacao;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.zup.academy.mauricio.proposta.cartao.Cartao;

@Entity
public class Renegociacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer quantidade;
	
	private Number valor;
	
	private LocalDateTime dataDeCriacao = LocalDateTime.now();
	
	@ManyToOne
	@Valid
	@NotNull
	private Cartao cartao;
	
	@Deprecated
	private Renegociacao() {}

	public Renegociacao(Integer quantidade, Number valor, LocalDateTime dataDeCriacao, @Valid @NotNull Cartao cartao) {
		super();
		this.quantidade = quantidade;
		this.valor = valor;
		this.dataDeCriacao = dataDeCriacao;
		this.cartao = cartao;
	}

	public Long getId() {
		return id;
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

	public Cartao getCartao() {
		return cartao;
	}
	
	
}
