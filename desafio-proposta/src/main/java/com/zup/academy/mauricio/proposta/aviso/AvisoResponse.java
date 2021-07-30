package com.zup.academy.mauricio.proposta.aviso;

import java.time.LocalDateTime;

import com.zup.academy.mauricio.proposta.cartao.Cartao;

public class AvisoResponse {

	private String destino;

	private String validoAte;

	private String instanteAviso;

	private String ipCliente;

	private String userAgent;

	public AvisoResponse(String destino, String validoAte, String instanteAviso, String ipCliente, String userAgent) {
		super();

		this.destino = destino;
		this.validoAte = validoAte;
		this.instanteAviso = instanteAviso;
		this.ipCliente = ipCliente;
		this.userAgent = userAgent;
	}

	

	public String getDestino() {
		return destino;
	}

	public String getValidoAte() {
		return validoAte;
	}

	public String getInstanteAviso() {
		return instanteAviso;
	}

	public String getIpCliente() {
		return ipCliente;
	}

	public String getUserAgent() {
		return userAgent;
	}

	


}
