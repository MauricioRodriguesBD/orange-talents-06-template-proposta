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

	private String idExterno;

	private LocalDateTime bloqueadoEm;

	@NotBlank
	private String sistemaResponsavel;

	@NotNull
	private boolean ativo;

	@NotNull
	@Valid
	@ManyToOne
	private Cartao cartao;

	private String ipCliente;

	private String userAgent;

	@Deprecated
	public Bloqueio() {

	}

	public Bloqueio(String idExterno, LocalDateTime bloqueadoEm, @NotBlank String sistemaResponsavel,
			@NotNull boolean ativo, @NotNull @Valid Cartao cartao) {
		super();

		this.idExterno = idExterno;
		this.bloqueadoEm = bloqueadoEm;
		this.sistemaResponsavel = sistemaResponsavel;
		this.ativo = ativo;

	}

	public void setInformacoesDeRequest(String remoteAddr, String agent, Cartao cartao) {

		this.ipCliente = remoteAddr;
		this.userAgent = agent;
		this.cartao = cartao;
	}

	public Long getId() {
		return id;
	}

	public String getIdExterno() {
		return idExterno;
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

	public String getIpCliente() {
		return ipCliente;
	}

	public String getUserAgent() {
		return userAgent;
	}

}
