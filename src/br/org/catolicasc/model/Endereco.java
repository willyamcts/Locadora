package br.org.catolicasc.model;

public class Endereco {
	
	private int id;
	private String cidade;
	private String bairro;
	private String logradouro;
	private int numeroResidencia;
	
	private Pessoa pessoa = new Pessoa();
	
	public Endereco(){}
	
	public Endereco(int id, String cidade, String bairro, String logradouro, int numeroResidencia) {
		this.cidade = cidade;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numeroResidencia = numeroResidencia;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	

	public int getNumeroResidencia() {
		return numeroResidencia;
	}
	public void setNumeroResidencia(int numeroResidencia) {
		this.numeroResidencia = numeroResidencia;
	}

	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
