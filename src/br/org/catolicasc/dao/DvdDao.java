package dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import jpa.ConnectionFactory;
import model.Dvd;
import net.sf.ehcache.hibernate.HibernateUtil;

public class DvdDao {

	private EntityManager em = new ConnectionFactory().getEntityManager();
	
	
	/*
	 * Create
	 */
	public String salva(Dvd dvd) {
		
		//Implement
		
	}
		
	
	/*
	 * Read by Id
	 */
	public Dvd pesquisa(int id) {
		
		//Implement
	}
	
		
	/*
	 * Read all
	 */
	public List<Dvd> listaTodos() {
		
		//Implement
		
	}
	
	
	/*
	 * Update
	 */
	public void atualiza(Dvd dvd) {
		
		//Implement
		
	}
	
		
	/*
	 * Delete
	 */
	public void remove(int id) {
		
		//Implement
		
	}
	
}
