package br.org.catolicasc.model;

import java.util.Collection;

public class Pessoa {
	private int id;
	private String nome;
	private String cpf;
	private int idade;
	private Endereco endereco;

	private Collection<Telefone> telefones;
	

	public Pessoa() {}
	
	 public Pessoa(String nome, String cpf, int idade, Collection<Telefone> fones, Endereco end) {
		 this.nome = nome;
		 this.idade = idade;
		 this.cpf = cpf;
		 this.telefones = (Collection<Telefone>) fones;
		 this.endereco = end;
	};
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
	public Collection<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(Collection<Telefone> telefones) {
		this.telefones = telefones;
	}

}
