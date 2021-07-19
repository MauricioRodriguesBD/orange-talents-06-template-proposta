package com.zup.academy.mauricio.proposta.criaproposta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.zup.academy.mauricio.proposta.validador.CpfOrCnpj;

@Entity
public class Proposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@CpfOrCnpj
	@NotNull
	@Column()
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

	@Enumerated
	@NotNull
	private StatusAvaliacao statusAvaliacao;

	@Deprecated
	private Proposta() {
	}

	public Proposta(@NotNull String documento, @Email @NotNull String email, @NotBlank String nome,
			@NotBlank String endereco, @NotNull @Positive Double salario) {
		super();
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
		
	}

	public Long getId() {
		return id;
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

	public StatusAvaliacao getStatusAvaliacao() {
		return statusAvaliacao;
	}
	public void setStatus(RetornoAvaliacao status) {
		if (status == RetornoAvaliacao.SEMRESTRICAO) {
			this.statusAvaliacao = StatusAvaliacao.ELEGIVEL;
		}
		else if (status == RetornoAvaliacao.COMRESTRICAO){
			this.statusAvaliacao = statusAvaliacao.NAOELEGIVEL;
		}
		
	}

}
