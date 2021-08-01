package com.zup.academy.mauricio.proposta.carteira;

public class CarteiraDigitalResponse {

		private String email;
		
		private String carteira;
		
		private String associadaEm;
		
		private String emissor;

		public CarteiraDigitalResponse(String email, String carteira, String associadaEm, String emissor) {
			super();
			this.email = email;
			this.carteira = carteira;
			this.associadaEm = associadaEm;
			this.emissor = emissor;
		}

		public String getEmail() {
			return email;
		}

		public String getCarteira() {
			return carteira;
		}

		public String getAssociadaEm() {
			return associadaEm;
		}

		public String getEmissor() {
			return emissor;
		}
		
		
}
