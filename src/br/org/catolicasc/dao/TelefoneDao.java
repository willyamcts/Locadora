package dao;

import java.util.List;

import javax.persistence.EntityManager;

import jpa.ConnectionFactory;
import model.Telefone;

public class TelefoneDao {

		private EntityManager em = ConnectionFactory.getEntityManager();
		
		
		/*
		 * Create
		 */
		public String salva(Telefone Telefone) {
		
			//Implement
		
		}
		
		
		/*
		 * Read by Id
		 */
		public Telefone pesquisa(int id) {
			Telefone d = new Telefone();
		
			//Implement
			
			return d;
		}
		
		
		/*
		 * Read all
		 */
		public List<Telefone> listaTodos() {
			List<Telefone> Telefones = null;
		
			//Implement
			
			return Telefones;
		}
		
		
		/*
		 * Update
		 */
		public void atualiza(Telefone Telefone) {
		
			//Implement
		}
		
		
		/*
		 * Delete
		 */
		public void remove(int id) {
			Telefone Telefone = null;
		
			//Implement
			
		}
		
	
	
}
