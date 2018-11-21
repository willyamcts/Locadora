package dao;

import java.util.List;

import javax.persistence.EntityManager;

import jpa.ConnectionFactory;
import model.Pessoa;

public class PessoaDao {
	
	/*
	 * Create
	 */
	public String salva(Pessoa p) {
		
		//Implement
	}
	
	
	/*
	 * Read by Id
	 */
	public Pessoa pesquisa(int id) {
		Pessoa c = new Pessoa();
		
		//Implement
		
		return c;
	}
	
	
	/*
	 * Read all
	 */
	public List<Pessoa> listaTodos() {
		List<Pessoa> Pessoas = null;
		
		//Implement
		
		return Pessoas;
	}
	
	
	/*
	 * Update
	 */
	public void atualiza(Pessoa p) {
		
		//Implement
	}
	
	
	/*
	 * Delete
	 */
	public void remove(int id){
		
		//Implement
	}
	
}
