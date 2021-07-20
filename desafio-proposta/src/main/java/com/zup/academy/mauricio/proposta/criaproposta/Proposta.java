package com.zup.academy.mauricio.proposta.criaproposta;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.zup.academy.mauricio.proposta.cartao.Cartao;
import com.zup.academy.mauricio.proposta.cartao.CartaoRequest;
import com.zup.academy.mauricio.proposta.criaproposta.status.StatusAvaliacao;
import com.zup.academy.mauricio.proposta.validador.CpfOrCnpj;

@Entity
public class Proposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@CpfOrCnpj
	@NotNull
	@Column(nullable = false)
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
	private StatusAvaliacao statusAvaliacao;

	@OneToOne(cascade = CascadeType.MERGE)
	private Cartao cartao;

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
		this.statusAvaliacao = statusAvaliacao;
		this.cartao = cartao;
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

	public void setStatusAvaliacao(StatusAvaliacao statusAvaliacao) {
		this.statusAvaliacao = statusAvaliacao;
	}

	public Cartao getCartao() {
		return cartao;
	}
	public CartaoRequest toCartaoRequest() {

		return new CartaoRequest(documento, nome, id);

	}

}
