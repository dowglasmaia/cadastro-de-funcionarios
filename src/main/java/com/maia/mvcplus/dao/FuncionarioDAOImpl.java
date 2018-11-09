package com.maia.mvcplus.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.maia.mvcplus.domain.Funcionario;

@Repository
public class FuncionarioDAOImpl extends AbstractDao<Funcionario, Long> {

	// Buscar Por Nome Usando JPQL
	public List<Funcionario> findByName(String name) {
		TypedQuery<Funcionario> query = getEntityManager()
				.createQuery("select f from Funcionario f where f.nome like :nome", Funcionario.class);
		query.setParameter("nome", "%" + name + "%");
		return query.getResultList();

	}

	// Buscar Por Nome Usando a Create Quere criada no AbatractDAO
	public List<Funcionario> buscarPorNome(String nome) {
		return createQuery("select f from Funcionario f where f.nome like concat('%',?1,'%')", nome);

	}

}
