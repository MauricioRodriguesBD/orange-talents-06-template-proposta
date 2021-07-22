package com.zup.academy.mauricio.proposta.biometria;

import java.time.LocalDateTime;
import java.util.Base64;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zup.academy.mauricio.proposta.cartao.Cartao;
import com.zup.academy.mauricio.proposta.validador.ExistsId;

@Entity
public class Biometria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private byte[] fingerPrint;

	private LocalDateTime data = LocalDateTime.now();

	@ManyToOne
	@NotNull
	@ExistsId(domainClass = Cartao.class,fieldName = "cartao")
	private Cartao cartao;

	@Deprecated
	private Biometria() {
	}

	public Biometria(@NotBlank String fingerPrint, Cartao cartao) {

		this.fingerPrint = Base64.getEncoder().encode(fingerPrint.getBytes());
		this.cartao = cartao;
	}

	public LocalDateTime getData() {
		return data;
	}
//
//	public void encodaFinger(String encoda) {
//		encoda = Base64.getEncoder().encodeToString(this.fingerPrint.getBytes());
//		System.out.println(encoda);
//
//	}

	public byte[] getFingerPrint() {
		return fingerPrint;
	}

	public Long getId() {
		return id;
	}

}
