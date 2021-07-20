package com.zup.academy.mauricio.proposta.aviso;

import java.time.LocalDateTime;

import com.zup.academy.mauricio.proposta.cartao.Cartao;

public class AvisoRequest {

		private LocalDateTime validoAte;
		
		private String destino;

		public AvisoRequest(LocalDateTime validoAte, String destino) {
			super();
			this.validoAte = validoAte;
			this.destino = destino;
		}

		public LocalDateTime getValidoAte() {
			return validoAte;
		}

		public String getDestino() {
			return destino;
		}


		public Aviso toModel(Cartao cartao) {
	        return new Aviso(validoAte, destino, cartao);
	    }
		
		
}
