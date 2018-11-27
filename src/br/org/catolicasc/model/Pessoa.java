package br.org.catolicasc.model;


public class Pessoa {
	private int id;
	private String nome;
	private String cpf;
	private int idade;
	private Endereco endereco;
	private Telefone telefone;
	

	public Pessoa() {}
	
	 public Pessoa(int id, String nome, String cpf, int idade, Telefone fone, Endereco end) {
		 this.nome = nome;
		 this.idade = idade;
		 this.cpf = cpf;
		 this.telefone = fone;
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
		//Endereco end = new Endereco();
		//String endereco = null;
		//endereco = end.getLogradouro()+ ", " +end.getNumeroResidencia()+ " - " 
		//+end.getBairro()+ ", "+end.getCidade();
		
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
}
