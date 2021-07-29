package com.zup.academy.mauricio.proposta.cartao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zup.academy.mauricio.proposta.aviso.Aviso;
import com.zup.academy.mauricio.proposta.bloqueio.Bloqueio;
import com.zup.academy.mauricio.proposta.carteira.CarteiraDigital;
import com.zup.academy.mauricio.proposta.criaproposta.Proposta;
import com.zup.academy.mauricio.proposta.parcela.Parcela;
import com.zup.academy.mauricio.proposta.renegociacao.Renegociacao;
import com.zup.academy.mauricio.proposta.vencimento.Vencimento;

public class CartaoResponse {

	@NotBlank
	private Long id;
	@NotNull
	private LocalDateTime emitidoEm;
	@NotBlank
	private String titular;
	@NotNull
	@Valid
	private List<Bloqueio> bloqueios = new ArrayList<>();
	@NotNull
	@Valid
	private List<Aviso> avisos = new ArrayList<>();
	@NotNull
	@Valid
	private List<CarteiraDigital> carteiras = new ArrayList<>();
	@NotNull
	@Valid
	private List<Parcela> parcelas = new ArrayList<>();
	@NotNull
	private BigDecimal limite;
	@Valid
	private Renegociacao renegociacao;
	@NotNull
	@Valid
	private Vencimento vencimento;

	public Long getId() {
		return id;
	}

	public LocalDateTime getEmitidoEm() {
		return emitidoEm;
	}

	public String getTitular() {
		return titular;
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

	public List<Bloqueio> getBloqueios() {
		return bloqueios;
	}

	public Bloqueio getUltimoBloqueio() {
		return bloqueios.get(bloqueios.size() - 1);
	}

	public Cartao toModel(Proposta proposta) {

		return new Cartao(this.id, this.emitidoEm, this.titular, this.bloqueios, this.avisos, this.carteiras,
				this.parcelas, this.limite, this.renegociacao, this.vencimento, proposta);
	}

}
