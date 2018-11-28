package br.org.catolicasc.model;

import java.util.Calendar;

public class Locacao {

	private int id;
	private String aluguel;
	private String devolucao;
	
	// Um dvd tem muitas locacoes;
	private Dvd dvd;

	// Um cliente tem muitas locações;
	private Cliente cliente;
	
	
	
	public Locacao() {}

	//public Locacao(Calendar dataAluguel, Calendar dataDevolucao, Dvd dvd, Cliente cliente) {
	public Locacao(String dataAluguel, String dataDevolucao, Dvd dvd, Cliente cliente) {
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
	
	/*
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
	*/	

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	public void setDvd(Dvd dvd) {
		this.dvd = dvd;
	}	
	public Dvd getDvd() {
		return dvd;
	}
	
	
	
	
	
	public void setAluguel(String aluguel) {
		this.aluguel = aluguel;
	}
	public String getAluguel() {
		return aluguel;
	}
	
	public void setDevolucao(String devolucao) {
		this.devolucao = devolucao;
	}
	public String getDevolucao() {
		return devolucao;
	}

}
