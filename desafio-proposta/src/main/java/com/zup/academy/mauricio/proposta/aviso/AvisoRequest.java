package com.zup.academy.mauricio.proposta.aviso;

import java.time.LocalDateTime;

import com.zup.academy.mauricio.proposta.cartao.Cartao;

public class AvisoRequest {

	private String validoAte;

	private String destino;

	private String ip;

	private String userAgent;

	private String dataAviso;

	public AvisoRequest(String validoAte, String destino, String dataAviso, String ip, String userAgent,
			Cartao cartao) {
		super();
		this.validoAte = validoAte;
		this.destino = destino;
		this.dataAviso = dataAviso;
		this.ip = ip;

	}

	public String getValidoAte() {
		return validoAte;
	}

	public String getDestino() {
		return destino;
	}

	public Aviso toModel(Cartao cartao) {
		return new Aviso(LocalDateTime.parse(validoAte), LocalDateTime.parse(dataAviso),destino, ip, userAgent,
				cartao);
	}

}
