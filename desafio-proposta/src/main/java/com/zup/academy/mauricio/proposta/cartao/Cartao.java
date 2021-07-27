package com.zup.academy.mauricio.proposta.cartao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zup.academy.mauricio.proposta.aviso.Aviso;
import com.zup.academy.mauricio.proposta.aviso.AvisoRequest;
import com.zup.academy.mauricio.proposta.biometria.Biometria;
import com.zup.academy.mauricio.proposta.bloqueio.Bloqueio;
import com.zup.academy.mauricio.proposta.bloqueio.BloqueioRequest;
import com.zup.academy.mauricio.proposta.carteira.CarteiraDigital;
import com.zup.academy.mauricio.proposta.carteira.CarteiraDigitalRequest;
import com.zup.academy.mauricio.proposta.criaproposta.Proposta;
import com.zup.academy.mauricio.proposta.parcela.Parcela;
import com.zup.academy.mauricio.proposta.parcela.ParcelaRequest;
import com.zup.academy.mauricio.proposta.renegociacao.Renegociacao;
import com.zup.academy.mauricio.proposta.renegociacao.RenegociacaoRequest;
import com.zup.academy.mauricio.proposta.vencimento.Vencimento;
import com.zup.academy.mauricio.proposta.vencimento.VencimentoRequest;

@Entity
public class Cartao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime emitidoEm;

	@NotBlank
	private String titular;

	@OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
	private List<Bloqueio> bloqueios;

	@OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
	private List<Aviso> avisos;

	@OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
	private List<CarteiraDigital> carteiras;

	@OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
	private List<Parcela> parcelas;

	@NotNull
	private BigDecimal limite;

	@OneToOne(cascade = CascadeType.MERGE)
	private Renegociacao renegociacao;

	@NotNull
	@Valid
	@OneToOne(mappedBy = "cartao", cascade = CascadeType.MERGE)
	private Vencimento vencimento;

	@NotNull
	@Valid
	@OneToOne
	private Proposta proposta;

	@Deprecated
	public Cartao() {

	}

	public Cartao(@NotBlank Long id, LocalDateTime emitidoEm, @NotBlank String titular, List<Bloqueio> bloqueios,
			List<Aviso> avisos, List<CarteiraDigital> carteiras, List<Parcela> parcelas, @NotNull BigDecimal limite,
			Renegociacao renegociacao, @NotNull @Valid Vencimento vencimento, @NotNull @Valid Proposta proposta) {
		super();
		this.id = id;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.bloqueios = bloqueios;
		this.avisos = avisos;
		this.carteiras = carteiras;
		this.parcelas = parcelas;
		this.limite = limite;
		this.renegociacao = renegociacao;
		this.vencimento = vencimento;
		this.proposta = proposta;
	}

	public void addBloqueio(Bloqueio bloqueio) {
		this.bloqueios.add(bloqueio);
	}

	public void addAviso(Aviso aviso) {
		this.avisos.add(aviso);
	}




	public Long getId() {
		return id;
	}

	public LocalDateTime getEmitidoEm() {
		return emitidoEm;
	}

	public String getTitular() {
		return titular;
	}

	public List<Bloqueio> getBloqueios() {
		return bloqueios;
	}

	public List<Aviso> getAvisos() {
		return avisos;
	}

	public List<CarteiraDigital> getCarteiras() {
		return carteiras;
	}

	public List<Parcela> getParcelas() {
		return parcelas;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public Renegociacao getRenegociacao() {
		return renegociacao;
	}

	public Vencimento getVencimento() {
		return vencimento;
	}

	public Proposta getProposta() {
		return proposta;
	}

}
