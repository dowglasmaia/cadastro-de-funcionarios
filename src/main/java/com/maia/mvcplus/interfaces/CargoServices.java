package com.maia.mvcplus.interfaces;

import java.util.List;

import com.maia.mvcplus.domain.Cargo;

public interface CargoServices {

	void salvar(Cargo cargo);

	void editar(Cargo cargo);

	void excluir(Long id);

	Cargo buscarPorId(Long id);

	List<Cargo> buscarTodos();
}
