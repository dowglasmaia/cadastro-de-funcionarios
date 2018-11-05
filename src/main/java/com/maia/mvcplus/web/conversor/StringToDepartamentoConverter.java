package com.maia.mvcplus.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.maia.mvcplus.domain.Departamento;
import com.maia.mvcplus.interfaces.DepartamentoServices;

/*
 * Class que convert do Departamento
 * */

@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento> {

	@Autowired
	private DepartamentoServices services;
	
	@Override
	public Departamento convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return services.buscarPorId(id);
	}

}
