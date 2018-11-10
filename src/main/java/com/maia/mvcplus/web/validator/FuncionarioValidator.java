package com.maia.mvcplus.web.validator;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.maia.mvcplus.domain.Funcionario;

public class FuncionarioValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Funcionario.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		Funcionario f = (Funcionario) obj;

		LocalDate dtaAdimissao = f.getDataAdmissao();
		if (f.getDataDemissao() != null) {
			if (f.getDataDemissao().isBefore(dtaAdimissao))	{
				errors.rejectValue("dataDemissao", "PosteriorDataEntrada.funcionario.dataDemissao");
			}
		}
	}

}
