package com.maia.mvcplus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maia.mvcplus.dao.DepartamentoDAOImpl;
import com.maia.mvcplus.domain.Departamento;
import com.maia.mvcplus.interfaces.DepartamentoServices;

@Transactional
@Service
public class DepartamentoServicesImpl implements DepartamentoServices {

	@Autowired
	private DepartamentoDAOImpl dao;

	@Override
	public void salvar(Departamento departamento) {
		dao.save(departamento);
	}

	@Override
	public void editar(Departamento departamento) {
		dao.update(departamento);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Departamento buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Departamento> buscarTodos() {

		return dao.findAll();
	}

}
