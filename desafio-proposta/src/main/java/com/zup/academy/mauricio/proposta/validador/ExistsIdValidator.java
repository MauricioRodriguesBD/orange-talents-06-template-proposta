package com.zup.academy.mauricio.proposta.validador;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object>{
	 private String domainAttribute;
	    private Class<?> klass;
	    @PersistenceContext
	    private EntityManager manager;

	    @Override
	    public void initialize(ExistsId params) {
	        domainAttribute = params.fieldName();
	        klass = params.domainClass();
	    }

	    @Override
	    public boolean isValid(Object value, ConstraintValidatorContext context) {
	        if(value == null) {
	            return true;
	        }

	        Query query = manager.createQuery("select 1 from "+klass.getName()+" where "+domainAttribute+"=:value");
	        query.setParameter("value", value);


	        List<?> list = query.getResultList();
	        Assert.isTrue(list.size() <=1, "você tem mais de um "+klass+" com o atributo "+domainAttribute+" com o valor = "+value);

	        return !list.isEmpty();
	    }
}
