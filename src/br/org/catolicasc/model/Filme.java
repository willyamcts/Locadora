package br.org.catolicasc.model;

import java.util.Collection;
import java.util.Date;

public class Filme {

	private int id;
	private String titulo;
	private String genero;
	private long duracao;
	private Date dataLancamento;

	private Collection<Dvd> dvds;
	
	
	
	public Filme() {}
	

	public Filme(int id, String titulo, String genero, long duracao, Date dataLancamento) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.duracao = duracao;
		this.dataLancamento = dataLancamento;
	}	
	
	
		
	public Collection<Dvd> getDvds() {
		return dvds;
	}

	public void setDvds(Collection<Dvd> dvds) {
		this.dvds = dvds;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}


	public Date getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}


	public long getDuracao() {
		return duracao;
	}
	public void setDuracao(long duracao) {
		this.duracao = duracao;
	}

}
