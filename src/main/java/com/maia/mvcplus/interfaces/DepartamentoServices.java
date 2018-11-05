package com.maia.mvcplus.interfaces;

import java.util.List;

import com.maia.mvcplus.domain.Departamento;

public interface DepartamentoServices {

	

	void salvar(Departamento departamento);

	void editar(Departamento departamento);

	void excluir(Long id);

	Departamento buscarPorId(Long id);

	List<Departamento> buscarTodos();

	boolean departamentoTemCargo(Long id);

}
