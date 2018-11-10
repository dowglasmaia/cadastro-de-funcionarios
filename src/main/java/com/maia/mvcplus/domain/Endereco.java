package com.maia.mvcplus.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/*
 * Autor: Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * */

@SuppressWarnings("serial")
@Entity
@Table(name = "ENDERECOS")
public class Endereco extends AbstractEntity<Long> {

	@NotBlank(message = "Campo Obrogatório")
	@Column(length = 50, nullable = false)
	private String logradouro;

	@NotBlank(message = "Campo Obrogatório")
	@Column(length = 10, nullable = false)
	private String numero;

	@NotBlank(message = "Campo Obrogatório")
	@Column(length = 50, nullable = false)
	private String bairro;

	@NotBlank(message = "Campo Obrogatório")
	@Column(length = 12, nullable = false)
	private String cep;

	@Column(length = 50)
	private String Complemento;

	@NotBlank(message = "Campo Obrogatório")
	@Column(length = 50, nullable = false)
	private String Cidade;

	@NotNull(message = "Informe uma UF para a Cidade")
	@Column(length = 2, nullable = false)
	@Enumerated(EnumType.STRING)
	private UF uf;

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

}
