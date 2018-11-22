package br.org.catolicasc.model;

public class Dvd {

	private int id;
	private int cod;
	private boolean locacao = false;

	//Muitos dvds podem ter um mesmo filme, ou 
	//	um filme tem muitos dvds = @ManyToOne
	private Filme filme;
	
	
	public Dvd() {}
	
	public Dvd(Filme filme, int cod, boolean locacao) {
		this.cod = cod;
		this.locacao = locacao;
	}	
	
	
	
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	

	public boolean isLocacao() {
		return locacao;
	}
	public void setLocacao(boolean locacao) {
		this.locacao = locacao;
	}
}
