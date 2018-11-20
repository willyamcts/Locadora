package dao;

import java.util.List;
import javax.persistence.EntityManager;
import jpa.ConnectionFactory;
import model.Cliente;

public class ClienteDao {
	
	private EntityManager em = new ConnectionFactory().getEntityManager();
	
	/*
	 * Create
	 */
	public String salva(Cliente c) {
		
		//Implement
		
	}
	
	
	/*
	 * Read by Id
	 */
	public Cliente pesquisa(int id) {
		
		//Implement
	}
	
	
	/*
	 * Read all
	 */
	public List<Cliente> listaTodos() {
		
		//Implement
	}
	
	
	/*
	 * Update
	 */
	public void atualiza(Cliente c) {
		
		//Implement
		
	}
	
	
	/*
	 * Delete
	 */
	public void remove(int id){
		
		//Implement
		
	}

	
	
	
	/*
	 * Deletar para envio
	 */
	/*
	public List<Cliente> pesquisaPorNome(String nomeMarca) {
		Query q = em.createNamedQuery("Marca.pesquisaPorNome");
		q.setParameter("nomeMarca", "%" + nomeMarca + "%");
		return q.getResultList();
	}
	
	public List<Cliente> listaTodosSimplificado(){
		Query q = em.createQuery(" select  new Marca(m.id, m.nome) "
				       + " from Marca m ");
		return q.getResultList();
	}
	*/
}
