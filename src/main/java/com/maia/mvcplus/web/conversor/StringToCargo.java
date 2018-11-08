package com.maia.mvcplus.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.maia.mvcplus.domain.Cargo;
import com.maia.mvcplus.interfaces.CargoServices;

/*
 * Class que convert do Cargo
 * */

@Component
public class StringToCargo implements Converter<String, Cargo> {

	@Autowired
	private CargoServices services;

	@Override
	public Cargo convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return services.buscarPorId(id);
	}

}
