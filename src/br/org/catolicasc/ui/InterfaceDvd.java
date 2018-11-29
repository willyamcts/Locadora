package br.org.catolicasc.ui;

import java.util.List;

import br.org.catolicasc.dao.DvdDao;
import br.org.catolicasc.dao.FilmeDao;
import br.org.catolicasc.model.Dvd;
import br.org.catolicasc.model.Filme;

public class InterfaceDvd extends InterfaceModelo {
	
	private DvdDao dvdDao = new DvdDao();
	private FilmeDao filmeDao = new FilmeDao(); 

	protected void insereDvd() {
		
		/*
		 * 
		System.out.print("\t INSERINDO DVD \n\n"
				+ "Informe título do filme: ");
		String titulo = entrada.nextLine();
		
		System.out.print("Informe o gênero: ");
		String genero = entrada.nextLine();
		
		
		System.out.print("Data de lançamento: ");
		String dataEntrada = entrada.nextLine();
		Date lancamento = new InterfacePrincipal().formataData(dataEntrada);
		
		System.out.print("Duração do filme (em minutos): ");
		long duracao = entrada.nextLong();
		
		System.out.print("Quantidade em estoque: ");
		int qtdEstoque = entrada.nextInt();
		entrada.nextLine();
		*/

		String titulo = "Homem de ferro";
		String genero = "Ação";
		String dataEntrada = "11/10/2010";
		//Date lancamento = formataData(dataEntrada);
							//java.sql.Date lancamento = new java.sql.Date(formataData(dataEntrada));
		long duracao = 123;
		
		
		Filme filme = new Filme();
		Dvd dvd = new Dvd();
		
		filme.setTitulo(titulo);
		filme.setGenero(genero);
		
		/*
		// Convert Date to Calendar
		Calendar cal = Calendar.getInstance();
		cal.setTime(lancamento);
		
		filme.setDataLancamento(cal);
		*/
		filme.setDataLancamento(dataEntrada);
		
		filme.setDuracao(duracao);
		
		
		/*
		filmeDao.pesquisaByName(titulo);
		System.out.println("Pesquisa por nome...");
		System.exit(0);
		*/
		
		filmeDao.insert(filme);
		
		dvd.setFilme(filme);
		dvd.setCod(geraRandom());
		dvd.setLocacao(false);

		dvdDao.insert(dvd);
	}	
	

	
	protected void removeDvd() {

		pulaLinhas();
		System.out.print("\t EXCLUINDO DVD \n"
				+ "Informe o id do DVD: ");
		int dvdId = entrada.nextInt();
		entrada.nextLine();

		if ( dvdDao.getByKey(dvdId).isLocacao() ) {
			System.out.println("\n\n\t Não é possível remover dvd, ele está locado.");
		} else {
			
			dvdDao.delete(dvdId);		
		}
		
	}
	
	
	
	protected void listaTodosDvd() {
		
		List<Dvd> dvd = dvdDao.getAll();
		
		pulaLinhas();		
		System.out.println("\t LISTA DE DVDs: ");
		System.out.println("Id\t Titulo\t\t\t Gênero\t Data de lançamento\t Duração\t Cod. Dvd\n");
		
		
		for ( Dvd d: dvd ) {

			System.out.println(d.getId()+ "\t " +d.getFilme().getTitulo()+ "\t\t " +d.getFilme().getGenero()+ "\t " 
					+d.getFilme().getDataLancamento()+ "\t\t " +d.getFilme().getDuracao()+ "min\t\t\t " +d.getCod());
		}
		
	}
	
}
