package com.zup.academy.mauricio.proposta.aviso;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.zup.academy.mauricio.proposta.cartao.Cartao;

@Entity
public class Aviso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime validoAte;

	private LocalDateTime dataAviso;

	private String destino;

	private String ip;

	private String userAgent;

	@ManyToOne
	private Cartao cartao;

	@Deprecated
	private Aviso() {
	}

	

	public Aviso(LocalDateTime validoAte, LocalDateTime dataAviso, String destino, String ip, String userAgent,
			Cartao cartao) {
		super();
		this.validoAte = validoAte;
		this.dataAviso = dataAviso;
		this.destino = destino;
		this.ip = ip;
		this.userAgent = userAgent;
		this.cartao = cartao;
	}



	public Long getId() {
		return id;
	}

	public LocalDateTime getValidoAte() {
		return validoAte;
	}

	public String getDestino() {
		return destino;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public String getIp() {
		return ip;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public LocalDateTime getDataAviso() {
		return dataAviso;
	}

	// método que setar em outro lugar com os atributos necessários
	public void setInformacoesDeRequest(String remoteAddr, String agent, Cartao cartao) {

		this.ip = remoteAddr;
		this.userAgent = agent;
		this.cartao = cartao;
	}

}
