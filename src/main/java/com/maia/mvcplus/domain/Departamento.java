package com.maia.mvcplus.domain;

import java.util.ArrayList;
import java.util.List;

//( o * informa que todas os inports são da javax.persistence)
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
@Table(name = "DEPARTAMENTOS")
public class Departamento extends AbstractEntity<Long> {

	@NotBlank(message = "Informe um Nome para Departamento")
	@Size(min = 3, max = 60, message = "O nome do Departamento deve ter entre {min} e {max} caracteres.")
	@Column(length = 50, nullable =  false, unique = true)
	private String nome;

	@JsonIgnore
	@OneToMany(mappedBy = "departamentos")
	private List<Cargo> cargos = new ArrayList<>();

	// Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cargo> getCargos() {
		return cargos;  
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}


	

}
