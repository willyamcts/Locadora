package br.org.catolicasc.ui;

import java.util.List;

import br.org.catolicasc.dao.ClienteDao;
import br.org.catolicasc.dao.PessoaDao;
import br.org.catolicasc.dao.TelefoneDao;
import br.org.catolicasc.model.Cliente;
import br.org.catolicasc.model.Endereco;
import br.org.catolicasc.model.Pessoa;
import br.org.catolicasc.model.Telefone;


public class InterfaceCliente extends InterfaceModelo {	

	private ClienteDao clienteDao = new ClienteDao();
	private TelefoneDao telefoneDao = new TelefoneDao();
	PessoaDao pessoaDao = new PessoaDao();
		
		
	protected void insereCliente(){		
		/*
		 * 
		System.out.print("\t INSERINDO CLIENTE \n\n"
				+ "Informe o nome do cliente: ");
		String nome = entrada.nextLine();
		
		System.out.print("Informe a idade de " +nome+ ": ");
		int idade = entrada.nextInt();
		entrada.nextLine();
		
		System.out.print("CPF de " +nome+ ": ");
		String cpf = entrada.nextLine();
		
		System.out.print("Telefone 1 de " +nome+ ": ");
		String fone1 = entrada.nextLine();
				
		System.out.print("Telefone 2 de " +nome+ ": ");
		String fone2 = entrada.nextLine();
		
		System.out.print("Telefone 3 de " +nome+ ": ");
		String fone3 = entrada.nextLine();
		
		System.out.print("Cidade de residencia: ");
		String cidade = entrada.nextLine();
		
		System.out.print("Bairro de residencia: ");
		String bairro = entrada.nextLine();
		
		System.out.print("Logradouro: ");
		String logradouro = entrada.nextLine();
		
		System.out.print("Numero residencia/apto: ");
		int nCasa = entrada.nextInt();
		entrada.nextLine();
		
		*/

		
		// Teste //
		
		String nome = "Teste 1";
		int idade = 19;
		String cpf = "111.222.333-45";
		
		String fone1 = "41 90000-0000";
		
		String cidade = "Mafra";
		String bairro = "Vila Nova";
		String logradouro = "Av. Vila Nova";
		int nCasa = 4567;
		
		
		
		
		Pessoa pessoa = new Pessoa();
		Cliente c = new Cliente();
		Telefone fone = new Telefone();
		Endereco end = new Endereco();
		
		
		end.setCidade(cidade);
		end.setBairro(bairro);
		end.setLogradouro(logradouro);
		end.setNumeroResidencia(nCasa);
		
		
		
		/*
		 * 
		 * NECESSARIO PASSAR ID DE PESSOA PARA TELEFONE
		 * 
		 */

		

		fone.setCodArea(obtemDD(fone1));
		fone.setNumero(obtemNumero(fone1));
		//fone.setPessoa(pessoa);
		
		telefoneDao.insert(fone);
		
		//pessoa = new Pessoa(nome, cpf, idade, telefones, end);
		pessoa.setNome(nome);
		pessoa.setIdade(idade);
		pessoa.setCpf(cpf);
		pessoa.setEndereco(end);
		pessoa.setTelefone(fone);
		
		pessoaDao.insert(pessoa);
		
		/*
		fone.setCodArea(obtemDD(fone1));
		fone.setNumero(obtemNumero(fone1));
		fone.setPessoa(pessoa);
			
		telefoneDao.insert(fone);
		*/
		
		//pessoa.setTelefone(fone);
		
		c.setPessoa(pessoa);
		c.setLocacao(false);
		//pulaLinhas();
		
		clienteDao.insert(c);
	}
	
	
	private int obtemDD(String fone){
		int ddFone = Integer.parseInt(fone.substring(0,2));
		
		return ddFone;
	}	
	
	
	private String obtemNumero(String numero) {
		String fone = null;
		
		fone = numero.substring(2, numero.length());
		
		return fone;
	}	
	
	
	protected void removeCliente() {
		System.out.print("\t REMOVENDO CLIENTE \n"
				+ "Insira o Id do cliente a ser removido: ");
		int cliente_id = entrada.nextInt();
		
		clienteDao.delete(cliente_id);
	}	
	
	

	protected void listaTodosCliente() {
		List<Cliente> clientes = clienteDao.getAll();
		Telefone telefone = new Pessoa().getTelefone();
		//String[] fones = new String[3];

		pulaLinhas();		
		System.out.println("\t LISTA DE CLIENTES: ");
		System.out.println("Id\t Nome\t\t CPF \t\t"
				+ "     Idade\t Fone\t"
				+ "\t\t\t Aluguel\t\t Endereço\n");		
				

		for (Cliente c: clientes) {
			System.out.println(c.getId()+ "\t " +c.getPessoa().getNome()+ "\t " 
					+c.getPessoa().getCpf()+ "\t      " +c.getPessoa().getIdade()+ 
					"\t" +telefone+ "\t " +c.isLocacao()+"\t\t " 
					+c.getPessoa().getEndereco());
		}
	}	
	
}
