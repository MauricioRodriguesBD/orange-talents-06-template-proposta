package com.zup.academy.mauricio.proposta.carteira;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zup.academy.mauricio.proposta.cartao.Cartao;

@Entity
public class CarteiraDigital {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Email
	@NotBlank
	private String email;
	
	@NotBlank
	private String carteira;
	
	private LocalDateTime associadaEm;
	@NotBlank
	private String emissor;
	
	private String ipCliente;
	
	private String userAgent;
	
	@ManyToOne
	@Valid
	@NotNull
	private Cartao cartao;
	
	@Deprecated
	private CarteiraDigital() {}

	public CarteiraDigital(@Email @NotBlank String email,@NotBlank String carteira, LocalDateTime associadaEm, @NotBlank String emissor,
			Cartao cartao) {
		super();
		this.email = email;
		this.carteira = carteira;
		this.associadaEm = associadaEm;
		this.emissor = emissor;
		this.cartao = cartao;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public LocalDateTime getAssociadaEm() {
		return associadaEm;
	}

	public String getEmissor() {
		return emissor;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public String getCarteira() {
		return carteira;
	}

	public String getIpCliente() {
		return ipCliente;
	}

	public String getUserAgent() {
		return userAgent;
	}
	
	public void setInformacoes(String remoteAddr,String agent,Cartao cartao) {
		this.ipCliente = remoteAddr;
		this.userAgent = agent;
		this.cartao = cartao;
	}
	
	
}
