package com.zup.academy.mauricio.proposta.cartao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zup.academy.mauricio.proposta.aviso.AvisoRequest;
import com.zup.academy.mauricio.proposta.bloqueio.BloqueioRequest;
import com.zup.academy.mauricio.proposta.carteira.CarteiraDigitalRequest;
import com.zup.academy.mauricio.proposta.criaproposta.Proposta;
import com.zup.academy.mauricio.proposta.parcela.ParcelaRequest;
import com.zup.academy.mauricio.proposta.renegociacao.RenegociacaoRequest;
import com.zup.academy.mauricio.proposta.vencimento.VencimentoRequest;

public class CartaoResponse {

	@NotBlank
	private String id;

	@NotNull
	private LocalDateTime emitidoEm;

	@NotBlank
	private String titular;

	@NotNull
	@Valid
	private List<BloqueioRequest> bloqueios = new ArrayList<>();

	@NotNull
	@Valid
	private List<AvisoRequest> avisos = new ArrayList<>();

	@NotNull
	@Valid
	private List<CarteiraDigitalRequest> carteiras = new ArrayList<>();

	@NotNull
	@Valid
	private List<ParcelaRequest> parcelas = new ArrayList<>();

	@NotNull
	private BigDecimal limite;

	@Valid
	private RenegociacaoRequest renegociacao;

	@NotNull
	@Valid
	private VencimentoRequest vencimento;

	public CartaoResponse(@NotBlank String id,
			@NotNull LocalDateTime emitidoEm,
			@NotBlank String titular,
			@NotNull @Valid Collection<BloqueioRequest> bloqueios,
			@NotNull @Valid Collection<AvisoRequest> avisos,
			@NotNull @Valid Collection<CarteiraDigitalRequest> carteiras, 
			@NotNull @Valid Collection<ParcelaRequest> parcelas,
			@NotNull BigDecimal limite, @Valid RenegociacaoRequest renegociacao,
			@NotNull @Valid VencimentoRequest vencimento) {
		this.id = id;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.bloqueios.addAll(bloqueios);
		this.avisos.addAll(avisos);
		this.carteiras.addAll(carteiras);
		this.parcelas.addAll(parcelas);
		this.limite = limite;
		this.renegociacao = renegociacao;
		this.vencimento = vencimento;
	}
	
	public Cartao toModel(Proposta proposta) {

        return new Cartao( emitidoEm, titular, bloqueios, avisos, carteiras, parcelas,
                          limite, renegociacao, vencimento, proposta);
    }

}
