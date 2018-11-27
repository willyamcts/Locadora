package br.org.catolicasc.ui;

import java.util.Scanner;

public class InterfaceTelasRem {
	
	Scanner entrada = new Scanner(System.in);
	
	
	public InterfaceTelasRem() {};
	
	
	
	
	/*
	 * 	INSER��O
	 * 
	 */
	private void Interfacecliente() {	
	
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
	
	}

	
	private void interfaceDvd() {
		System.out.print("\t INSERINDO DVD \n\n"
				+ "Informe t�tulo do filme: ");
		String titulo = entrada.nextLine();
		
		System.out.print("Informe o g�nero: ");
		String genero = entrada.nextLine();
		
		
		System.out.print("Data de lan�amento: ");
		String dataEntrada = entrada.nextLine();
		//Date lancamento = new InterfacePrincipal().formataData(dataEntrada);
		
		System.out.print("Dura��o do filme (em minutos): ");
		long duracao = entrada.nextLong();
		
		System.out.print("Quantidade em estoque: ");
		int qtdEstoque = entrada.nextInt();
		entrada.nextLine();
	}
	
	
	
	private void interfaceLocacao() {
		
		System.out.print("\t INSERINDO LOCA��O \n\n"
				+ "Informe id do dvd: ");
		int dvdId = entrada.nextInt();
		entrada.nextLine();
		
		System.out.print("Informe o id do cliente: ");
		int clienteId = entrada.nextInt();
		entrada.nextLine();
	}
	
	
	
	
	
	
	
	/*
	 * 
	 * 	LISTA TODOS
	 * 
	 * 
	 */
	
	//Listagem de clientes deve mostrar:
	//System.out.println("Nome	CPF		Idade		Fone	Aluguel		Endere�o");		
	
	//Listagem de Dvds deve mostrar:
	//System.out.println("Id	Titulo		G�nero		Data de lan�amento		Dura��o		Cod. Dvd");

	//Listagem de Loca��es deve mostrar:
	//System.out.println("Id		Cliente	(Id)	Titulo filme	Cod. Dvd");
	
}
