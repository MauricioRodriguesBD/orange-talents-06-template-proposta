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

	private LocalDateTime validoAte = LocalDateTime.now();

	private String destino;

	@ManyToOne
	private Cartao cartao;

	@Deprecated
	private Aviso() {
	}

	public Aviso(LocalDateTime validoAte, String destino, Cartao cartao) {
		super();
		this.validoAte = validoAte;
		this.destino = destino;
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

		
}
