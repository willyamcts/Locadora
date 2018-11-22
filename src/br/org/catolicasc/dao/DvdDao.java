package br.org.catolicasc.dao;

import java.util.List;

import br.org.catolicasc.model.Dvd;

public class DvdDao {


	/*
	 * Create
	 */
	public String salva(Dvd dvd) {
		String status = null;

		// Implement
		
		return status;
	}
	
	
	/*
	 * Read by Id
	 */
	public Dvd pesquisa(int id) {
		Dvd d = new Dvd();
		
		if ( id > 0 ){

			// Implement
			
		}
		
		return d;
	}
	
	
	/*
	 * Read all
	 */
	public List<Dvd> listaTodos() {

		List<Dvd> dvds = null;

		// Implement
		
		
		return dvds;
	}
	
	
	/*
	 * Update
	 */
	public void atualiza(Dvd dvd) {

		// Implement
		
	}
	
	
	/*
	 * Delete
	 */
	public void remove(int id) {
		Dvd dvd = null;

		//Implement
		
	}
	
	
}
