package com.maia.mvcplus.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * Autor: Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * */

@SuppressWarnings("serial")
@Entity
@Table(name = "ENDERECOS")
public class Endereco extends AbstractEntity<Long> {

	@Column(length = 50, nullable = false)
	@NotBlank(message = "Campo Obrigatório")
	private String logradouro;

	@Column(length = 10, nullable = false)
	@NotBlank(message = "Campo Obrigatório")
	private String numero;

	@Column(length = 50, nullable = false)
	@NotBlank(message = "Campo Obrigatório")
	private String bairro;

	@Column(length = 12, nullable = false)
	@NotBlank(message = "Campo Obrigatório")
	private String cep;

	@Column(length = 50)
	private String Complemento;

	@Column(length = 50, nullable = false)
	@NotBlank(message = "Campo Obrigatório")
	private String Cidade;

	@Column(length = 2, nullable = false)
	@NotBlank(message = "Campo Obrigatório")
	@Enumerated(EnumType.STRING)
	private UF uf;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "endereco")
	private List<Funcionario> funcionarios = new ArrayList<>();

	// Getters e Setters
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return Complemento;
	}

	public void setComplemento(String complemento) {
		Complemento = complemento;
	}

	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
