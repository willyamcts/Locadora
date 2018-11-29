package br.org.catolicasc.ui;


import br.org.catolicasc.dao.ClienteDao;
import br.org.catolicasc.dao.DvdDao;
import br.org.catolicasc.dao.LocacaoDao;
import br.org.catolicasc.model.Cliente;
import br.org.catolicasc.model.Dvd;
import br.org.catolicasc.model.Locacao;

public class InterfaceLocacao extends InterfaceModelo {

	private Dvd dvd = new Dvd();
	private Cliente cliente = new Cliente();
	Locacao l = new Locacao();
	
	private DvdDao dvdDao = new DvdDao();
	private LocacaoDao locacaoDao = new LocacaoDao();
	private ClienteDao clienteDao = new ClienteDao();

	
	
	public void adicionar() {		
		pulaLinhas();
		System.out.print("\t INSERINDO LOCAÇÃO \n\n"
				+ "Informe id do dvd: ");
		int dvdId = entrada.nextInt();
		entrada.nextLine();
		
		System.out.print("Informe o id do cliente: ");
		int clienteId = entrada.nextInt();
		entrada.nextLine();
				
		
		
		
		if ( dvdDao.getByKey(dvdId).isLocacao() ) {
			System.out.println("\n\n\t Não é possível inserir aluguel pois o DVD informado já está alugado.");
		} else {
			String alugado = dataAtual();
			String devolucao = addDiasAData(6);
			
			
			cliente = clienteDao.getByKey(clienteId);
			//cliente.setPessoa(cliente.getPessoa());
			cliente.setLocacao(true);
			clienteDao.update(cliente);
			
			dvd = dvdDao.getByKey(dvdId);
			dvd.setLocacao(true);
			dvdDao.update(dvd);

			
			l.setAluguel(alugado);
			l.setDevolucao(devolucao);
						
			l.setDvd(dvd);
			l.setCliente(cliente);				
			locacaoDao.insert(l);
		}
		
	}
	

	public void listarTodos() {
		// TODO Auto-generated method stub
		
	}

	
	public void editar() {
		// TODO Auto-generated method stub
		
	}

	
	public void excluir() {
		
		pulaLinhas();
		System.out.print("\t REMOVENDO LOCAÇÃO \n"
				+ "Insira o Id da locação a ser removida: ");
		int locacaoId = entrada.nextInt();
		
		
		l = locacaoDao.getByKey(locacaoId);
		

		//Alterar no cliente, locador para false; 
		//cliente = clienteDao.getByKey(l.getCliente().getId());
		cliente.setLocacao(false);
		//clienteDao.update(cliente);
		
		
		// Altera dvd para disponível em estoque
		//dvd = dvdDao.getByKey(l.getDvd().getId());
		dvd.setLocacao(false);
		//dvdDao.update(dvd);
		
		
		//l.setCliente(cliente);
		
		locacaoDao.delete(locacaoId);
		
	}
	
}
