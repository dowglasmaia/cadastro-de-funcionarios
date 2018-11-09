package com.maia.mvcplus.dao;

import java.time.LocalDate;
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

	// Buscar Funcionario Por cargo
	public List<Funcionario> findByCargo(Long id) {
		return createQuery("select f from Funcionario f where f.cargo.id = ?1", id);
	}

	// Buscar Funcionario Por Data de Entrada e Saida
	public List<Funcionario> findByDataEntradaSainda(LocalDate entrada, LocalDate saida) {
		String jpql = new StringBuilder("select f from Funcionario f ")
				.append("where f.dataAdmissao >= ?1 and f.dataDemissao <= ?2 ")
				.append("order by f.dataAdmissao asc")
				.toString();
		return createQuery(jpql, entrada, saida);
	}

	// Buscar Funcionario Por Data de Entrada
	public List<Funcionario> finByDataEntrada(LocalDate entrada) {
		String jpql = new StringBuilder("select f from Funcionario f ")
				.append("where f.dataAdmissao = ?1 ")
				.append("order by f.dataAdmissao asc")
				.toString();
		return createQuery(jpql, entrada);
	}

	// Buscar Funcionario Por Data de Saida
	public List<Funcionario> findByDataSainda(LocalDate saida) {
		String jpql = new StringBuilder("select f from Funcionario f ")
				.append("where f.dataDemissao = ?1 ")
				.append("order by f.dataAdmissao asc")
				.toString();		
	   return createQuery(jpql, saida);
	}

}
