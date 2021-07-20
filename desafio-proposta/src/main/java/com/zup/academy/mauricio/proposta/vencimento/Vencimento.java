package com.zup.academy.mauricio.proposta.vencimento;

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
public class Vencimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer dia;

	private LocalDateTime dataDeCriacao = LocalDateTime.now();

	@Valid
	@NotNull
	@ManyToOne
	private Cartao cartao;

	@Deprecated
	private Vencimento() {
	}

	public Vencimento(Integer dia, LocalDateTime dataDeCriacao, @Valid @NotNull Cartao cartao) {
		super();
		this.dia = dia;
		this.dataDeCriacao = dataDeCriacao;
		this.cartao = cartao;
	}

	public Long getId() {
		return id;
	}

	public Integer getDia() {
		return dia;
	}

	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	}

	public Cartao getCartao() {
		return cartao;
	}
	
	
}
