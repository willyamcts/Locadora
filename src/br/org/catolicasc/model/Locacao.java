package br.org.catolicasc.model;

import java.util.Date;

public class Locacao {

	private int id;
	private Date aluguel = new Date();
	private Date devolucao = new Date();
	
	// Um dvd tem muitas locacoes;
	private Dvd dvd;

	// Um cliente tem muitas locações;
	private Cliente cliente;
	
	
	
	public Locacao() {}
	
	public Locacao(Date dataAluguel, Date dataDevolucao, Dvd dvd, Cliente cliente) {
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
	
	
	public Date getAluguel() {
		return aluguel;
	}
	public void setAluguel(Date aluguel) {
		this.aluguel = aluguel;
	}
	
	
	public Date getDevolucao() {
		return devolucao;
	}
	public void setDevolucao(Date devolucao) {		
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
