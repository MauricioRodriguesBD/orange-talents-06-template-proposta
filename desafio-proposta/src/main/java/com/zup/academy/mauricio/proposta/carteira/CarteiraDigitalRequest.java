package com.zup.academy.mauricio.proposta.carteira;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.zup.academy.mauricio.proposta.cartao.Cartao;

public class CarteiraDigitalRequest {

	@NotBlank
	@Email
	private String email;
	
	private LocalDateTime associadaEm;
	
	@NotBlank
	private String emissor;

	public CarteiraDigitalRequest(@NotBlank @Email String email, LocalDateTime associadaEm, @NotBlank String emissor) {
		super();
		this.email = email;
		this.associadaEm = associadaEm;
		this.emissor = emissor;
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
	
	public CarteiraDigital toModel(Cartao cartao) {
		return new CarteiraDigital(this.email, this.associadaEm, this.emissor, cartao);
	}
	
}
