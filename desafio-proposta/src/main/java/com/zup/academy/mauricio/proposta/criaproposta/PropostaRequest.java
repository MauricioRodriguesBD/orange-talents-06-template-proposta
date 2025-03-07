package com.zup.academy.mauricio.proposta.criaproposta;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.zup.academy.mauricio.proposta.criaproposta.status.StatusAvaliacao;
import com.zup.academy.mauricio.proposta.validador.CpfOrCnpj;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PropostaRequest {

	@CpfOrCnpj
	private String documento;

	@Email
	@NotNull
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String endereco;

	@NotNull
	@Positive
	private Double salario;

	@Enumerated(EnumType.STRING)
//	@NotNull
	private StatusAvaliacao statusAvaliacao;

	public PropostaRequest(String documento, @Email @NotNull String email, @NotBlank String nome,
			@NotBlank String endereco, @NotNull @Positive Double salario) {
		super();
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
		this.statusAvaliacao = statusAvaliacao;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public Double getSalario() {
		return salario;
	}

	public Proposta toModel() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return new Proposta(encoder.encode(documento), email, nome, endereco, salario);
	}
	
	

}
