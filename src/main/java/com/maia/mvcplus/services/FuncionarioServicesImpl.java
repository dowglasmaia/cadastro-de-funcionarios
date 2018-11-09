package com.maia.mvcplus.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maia.mvcplus.dao.FuncionarioDAOImpl;
import com.maia.mvcplus.domain.Funcionario;
import com.maia.mvcplus.interfaces.FuncionarioServices;

@Transactional
@Service
public class FuncionarioServicesImpl implements FuncionarioServices {

	@Autowired
	private FuncionarioDAOImpl dao;

	@Override
	public void salvar(Funcionario funcionario) {
		dao.save(funcionario);
	}

	@Override
	public void editar(Funcionario funcionario) {
		dao.update(funcionario);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Funcionario buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Funcionario> buscarTodos() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Funcionario> buscarPorNome(String nome) {
		return dao.findByName(nome);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Funcionario> buscarPorCargo(Long id) {
		return dao.findByCargo(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Funcionario> buscarPorDatas(LocalDate entrada, LocalDate saida) {
		if (entrada != null && saida != null) {
			return dao.findByDataEntradaSainda(entrada, saida); // Retorna com referencia das duas Datas , Entrda e  Saida																
		} else if (entrada != null) {
			return dao.finByDataEntrada(entrada); // Retorna com referencia a Data de Entrda
		} else if (saida != null) {
			return dao.findByDataSainda(saida); // Retorna com referencia a Data de Saida
		} else {
			return new ArrayList<>(); // Retorna uma lista Vazia caso nao seja informada nenhuma Data
		}
	}

}
