package br.org.catolicasc.model;


public class Cliente {

	private int id;
	private boolean locacao;
	
	private Pessoa pessoa;
	

	public Cliente() {}	
	
	public Cliente(int id, boolean locacao) {
		this.locacao = locacao;
	}

	public Cliente(int id, boolean locacao, Pessoa p) {
		this.locacao = locacao;
		this.pessoa = p;
	}
	
	
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	

	public boolean isLocacao() {
		return locacao;
	}
	public void setLocacao(boolean locacao) {
		this.locacao = locacao;
	}	
	
	/*
	public Dvd getFilmeLocado() {
		return (Dvd) filmeLocado;
	}
	public void setFilmeLocado(Dvd filmeLocado) {
		this.filmeLocado = (List<Dvd>) filmeLocado;
	}
	*/

}
