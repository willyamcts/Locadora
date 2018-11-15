package br.org.catolicasc.dao;

public class Cliente extends Pessoa {

	private boolean locador;
	

	public Cliente(int id, String nome,  long cpf, String endereco,
			long telefone, boolean locador) {
		
		super(id, nome, cpf, endereco, telefone);

		this.locador = locador;
	}
	
	


// Getters e Setters
	public boolean isLocador() {
		return locador;
	}
	
// Getters e Setters	
	public void setLocador(boolean locador) {
		this.locador = locador;
	}
	
	
	
	

}
