package com.zup.academy.mauricio.proposta.criaproposta.status;

import java.util.HashMap;
import java.util.Map;


public enum StatusAvaliacao {

	ELEGIVEl,
	NAO_ELEGIVEL,
	SEM_RESTRICAO,
	COM_RESTRICAO;
	
	public static StatusAvaliacao mapeamento(String status) {
		Map<String, StatusAvaliacao> mapeia = new HashMap<String, StatusAvaliacao>();
		mapeia.put("ELEGIVEL", StatusAvaliacao.SEM_RESTRICAO);
		mapeia.put("NAO_ELEGIVEL", StatusAvaliacao.COM_RESTRICAO);
	
		return mapeia.get(status);
}
}
