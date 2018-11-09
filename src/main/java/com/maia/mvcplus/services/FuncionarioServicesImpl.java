package com.maia.mvcplus.services;

import java.util.Date;
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
	public Object buscarPorDatas(Date entrada, Date saida) {
		// TODO Auto-generated method stub
		return null;
	}

}
