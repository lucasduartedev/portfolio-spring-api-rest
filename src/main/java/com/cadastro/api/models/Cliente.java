package com.cadastro.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "email")
	private String email;

//	Construtores
	public Cliente() {
	}

	public Cliente(String nome, String cpf, String telefone, String email) {
		super();
		validarNome(nome);
		validarCpf(cpf);
		validarTelefone(telefone);
		validarEmail(email);
	}

//	Mpetodos especiais
	public void validarNome(String nome) {
		if (nome == null || nome.length() < 4) {
			throw new IllegalArgumentException("Nome Inválido!");
		}
		this.nome = nome;
	}

	public void validarCpf(String cpf) {
		if (cpf == null || !cpf.matches("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}")) {
			throw new IllegalArgumentException("CPF Inválido!");
		}
		this.cpf = cpf;
	}

	public void validarTelefone(String tel) {
		if (tel == null || !tel.matches("([0-9]{5}||[0-9]{4})\\-[0-9]{4}")) {
			throw new IllegalArgumentException("Telefone Inválido!");
		}
		this.telefone = tel;
	}

	public void validarEmail(String email) {
		if (email == null || !email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
			throw new IllegalArgumentException("Email Inválido");
		}
		this.email = email;
	}

//	Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
