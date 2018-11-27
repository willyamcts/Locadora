package br.org.catolicasc.ui;

import java.util.Date;

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
		System.out.print("\t INSERINDO LOCA��O \n\n"
				+ "Informe id do dvd: ");
		int dvdId = entrada.nextInt();
		entrada.nextLine();
		
		System.out.print("Informe o id do cliente: ");
		int clienteId = entrada.nextInt();
		entrada.nextLine();
		
				
		Date alugado = dataAtual();
		Date devolucao = addDiasAData(6);
		
		
		cliente = clienteDao.getByKey(clienteId);
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
	

	public void listarTodos() {
		// TODO Auto-generated method stub
		
	}

	public void editar() {
		// TODO Auto-generated method stub
		
	}

	public void excluir() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
