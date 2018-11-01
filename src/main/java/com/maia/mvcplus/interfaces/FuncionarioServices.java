package com.maia.mvcplus.interfaces;

import java.util.List;

import com.maia.mvcplus.domain.Funcionario;

public interface FuncionarioServices {
	void salvar(Funcionario funcionario);

	void editar(Funcionario funcionario);

	void excluir(Long id);

	Funcionario buscarPorId(Long id);

	List<Funcionario> buscarTodos();
}
