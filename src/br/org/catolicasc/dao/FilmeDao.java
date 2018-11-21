package dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import jpa.ConnectionFactory;
import model.Filme;

public class FilmeDao extends DaoBase {
	
	
	/*
	 * Create
	 */
	public String salva(Filme filme) {
		
		//Implement
	}
		
	
	/*
	 * Read by Id
	 */
	public Filme pesquisa(int id) {
		Filme f = new Filme();
		
		
		//Implement
		
		return f;
	}
	
	
	
	/*
	 * Read by name
	 */
	/*
	public Filme pesquisaByName(String titulo){
		Filme filme = null;
		
		//Implement - Non
		
		return filme;
	}
	 */
		
	/*
	 * Read all
	 */
	public List<Filme> listaTodos() {
		List<Filme> filmes = null;		
		
		
		//Implement		
		
		
		return filmes;
	}
	
	
	/*
	
	/*
	 * Update
	 
	public void atualiza(Filme f) {		
		
		//Implement - Non
		
	}
	
		
	/*
	 * Delete
	 
	public void remove(int id) {
		
		//Implement - Non
		
	}
	
	*/
}
