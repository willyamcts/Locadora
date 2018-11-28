package br.org.catolicasc.model;

import java.util.Calendar;

public class Locacao {

	private int id;
	private Calendar aluguel;
	private Calendar devolucao;
	
	// Um dvd tem muitas locacoes;
	private Dvd dvd;

	// Um cliente tem muitas locações;
	private Cliente cliente;
	
	
	
	public Locacao() {}
	
	public Locacao(Calendar dataAluguel, Calendar dataDevolucao, Dvd dvd, Cliente cliente) {
		this.aluguel = dataAluguel;
		this.devolucao = dataDevolucao;
		this.cliente = cliente;
		this.dvd = dvd;
	}
	
		
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public Calendar getAluguel() {
		return aluguel;
	}
	public void setAluguel(Calendar aluguel) {
		this.aluguel = aluguel;
	}
	
	
	public Calendar getDevolucao() {
		return devolucao;
	}
	public void setDevolucao(Calendar devolucao) {		
		this.devolucao = devolucao;
	}

	
	public void setDvd(Dvd dvd) {
		this.dvd = dvd;
	}	
	public Dvd getDvd() {
		return dvd;
	}
	

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
