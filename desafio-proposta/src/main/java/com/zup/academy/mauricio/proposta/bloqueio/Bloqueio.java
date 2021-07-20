package com.zup.academy.mauricio.proposta.bloqueio;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zup.academy.mauricio.proposta.cartao.Cartao;

@Entity
public class Bloqueio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime bloqueadoEm = LocalDateTime.now();
	
	@NotBlank
	private String sistemaResponsavel;
	
	@NotNull
	private boolean ativo;
	
	@ManyToOne
	@NotNull
	@Valid
	private Cartao cartao;
	
	@Deprecated
	private Bloqueio() {}

	public Bloqueio(LocalDateTime bloqueadoEm,
			@NotBlank String sistemaResponsavel,
			@NotNull boolean ativo,
			Cartao cartao) {
		super();
		this.bloqueadoEm = bloqueadoEm;
		this.sistemaResponsavel = sistemaResponsavel;
		this.ativo = ativo;
		this.cartao = cartao;
	}

	public Long getId() {
		return id;
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

	public Cartao getCartao() {
		return cartao;
	}
	
	
	
}
