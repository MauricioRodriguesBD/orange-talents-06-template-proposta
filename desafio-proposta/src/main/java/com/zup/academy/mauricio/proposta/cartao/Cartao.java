package com.zup.academy.mauricio.proposta.cartao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
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
	private Set<Bloqueio> bloqueios = new HashSet<>();

	@OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
	private Set<Aviso> avisos = new HashSet<>();

	@OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
	private Set<CarteiraDigital> carteiras = new HashSet<>();

	@OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
	private Set<Parcela> parcelas = new HashSet<>();

	private BigDecimal limite;

	@OneToOne(mappedBy = "cartao", cascade = CascadeType.MERGE)
	private Renegociacao renegociacao;

	@OneToOne(mappedBy = "cartao", cascade = CascadeType.MERGE)
	private Vencimento vencimento;
	
//	@OneToOne(mappedBy = "cartao", cascade = CascadeType.MERGE)
//	private Set<Biometria> biometrias = new HashSet<>();

	@OneToOne
	private Proposta proposta;

	@Deprecated
	private Cartao() {
	}

	public Cartao(@NotNull LocalDateTime emitidoEm, @NotBlank String titular,
			@NotNull @Valid Collection<BloqueioRequest> bloqueios, @NotNull @Valid Collection<AvisoRequest> avisos,
			@NotNull @Valid Collection<CarteiraDigitalRequest> carteiras,
			@NotNull @Valid Collection<ParcelaRequest> parcelas, @NotNull BigDecimal limite,
			@Valid RenegociacaoRequest renegociacao, @NotNull @Valid VencimentoRequest vencimento,
			@NotNull @Valid Proposta proposta) {

		this.emitidoEm = emitidoEm;
		this.titular = titular;
		Set<Bloqueio> novosBloqueios = bloqueios.stream().map(bloqueio -> bloqueio.toModel(this))
				.collect(Collectors.toSet());
		this.bloqueios.addAll(novosBloqueios);
		Set<Aviso> novosAvisos = avisos.stream().map(aviso -> aviso.toModel(this)).collect(Collectors.toSet());
		this.avisos.addAll(novosAvisos);
		Set<CarteiraDigital> novasCarteiras = carteiras.stream().map(carteira -> carteira.toModel(this))
				.collect(Collectors.toSet());
		this.carteiras.addAll(novasCarteiras);
		Set<Parcela> novasParcelas = parcelas.stream().map(parcela -> parcela.toModel(this))
				.collect(Collectors.toSet());
		this.parcelas.addAll(novasParcelas);
		this.limite = limite;
		if (renegociacao == null) {
			this.renegociacao = null;
		} else {
			this.renegociacao = renegociacao.toModel(this);
		}
		this.proposta = proposta;

	}

	public Long getId() {
		return id;
	}
}
