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
	private TipoCarteira tipo;

	

	public CarteiraDigitalRequest(@NotBlank @Email String email, LocalDateTime associadaEm,
			@NotBlank TipoCarteira tipo) {
		super();
		this.email = email;
		this.associadaEm = associadaEm;
		this.tipo = tipo;
	}

	public String getEmail() {
		return email;
	}

	public LocalDateTime getAssociadaEm() {
		return associadaEm;
	}

	public TipoCarteira getTipo() {
		return tipo;
	}

	
	
	
	
}
