package com.zup.academy.mauricio.proposta.validador;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.stereotype.Component;


@Component
public class ValidadorCpfCnpj implements ConstraintValidator<CpfOrCnpj, CharSequence>{

	@Override
	public boolean isValid(CharSequence value, ConstraintValidatorContext context) {

		if(value==null) {
			return true;
		}
		//Buscando a restrição @CPF
		CPFValidator cpf = new CPFValidator();
		cpf.initialize(null);
		//Buscando a restrição @CPNJ
		CNPJValidator cnpj = new CNPJValidator();
		cnpj.initialize(null);
		
		//retorna CPf ou CNPJ
		return cpf.isValid(value, context)
				||
				cnpj.isValid(value, context);		
		
	}

	

}
