package com.maia.mvcplus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maia.mvcplus.dao.CargoDAOImpl;
import com.maia.mvcplus.domain.Cargo;
import com.maia.mvcplus.interfaces.CargoServices;

@Service
@Transactional(readOnly = false) // (readOnly = false) e o Padrão mesmo que não seja explicito na anotação
public class CargoServicesImpl implements CargoServices {

	@Autowired
	private CargoDAOImpl dao; 

	@Override
	public void salvar(Cargo cargo) {
		dao.save(cargo);
	}

	@Override
	public void editar(Cargo cargo) {
		dao.update(cargo);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Cargo buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cargo> buscarTodos() {
		return dao.findAll();
	}

}
