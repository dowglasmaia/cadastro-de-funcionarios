package com.maia.mvcplus.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * Autor: Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * */

@SuppressWarnings("serial")
@Entity
@Table(name = "CARGOS")
public class Cargo extends AbstractEntity<Long> {

	@NotBlank(message = "Informe o Nome do Cargo")
	@Size(min = 3, max = 60, message = "O nome do Cargo deve ter entre {min} e {max} caracteres.")
	@Column(length = 50, nullable = false, unique = true)
	private String nome;

	@NotNull(message = "Selecione o Departemento relativo ao Cargo.")
	@JoinColumn(nullable=false)
	@ManyToOne
	private Departamento departamentos;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "cargo")
	private List<Funcionario> funcionarios = new ArrayList<>();

	// Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Departamento getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(Departamento departamentos) {
		this.departamentos = departamentos;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
