package com.maia.mvcplus.interfaces;

import java.util.Date;
import java.util.List;

import com.maia.mvcplus.domain.Funcionario;

public interface FuncionarioServices {
	void salvar(Funcionario funcionario);

	void editar(Funcionario funcionario);

	void excluir(Long id);

	Funcionario buscarPorId(Long id);

	List<Funcionario> buscarTodos();

	List<Funcionario> buscarPorNome(String nome);

	Object buscarPorCargo(Long id);

	Object buscarPorDatas(Date entrada, Date saida);
}
