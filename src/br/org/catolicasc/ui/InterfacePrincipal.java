package br.org.catolicasc.ui;

import br.org.catolicasc.ui.InterfaceCliente;

public class InterfacePrincipal extends InterfaceModelo {

	private InterfaceCliente ic = new InterfaceCliente();
	private InterfaceDvd id = new InterfaceDvd();
	private InterfaceLocacao il = new InterfaceLocacao();
	
	
	
	/*
	 * Menu principal para usuario;
	 */
	public void menuPrincipal() {

		int op = 0;
		
		do {
			pulaLinhas();
			System.out.println("\t MENU LOCADORA ");
			System.out.println("1 - Inserir loca��o, cliente ou DVD");
			System.out.println("2 - Remover loca��o, cliente ou DVD");
			System.out.println("3 - Listar loca��es, clientes ou DVDs");
			System.out.println("4 - Sair");
			System.out.print("Op��o: ");
			
			op = ic.entrada.nextInt();
			ic.entrada.nextLine();
			pulaLinhas();
		} while ( op <= 0 && op < 4);
		
		if ( op == 1 ) {
			menuEscolhido("i");
		} else if ( op == 2 ) {
			menuEscolhido("r");
		} else if ( op == 3 ) {
			menuEscolhido("l");
		}

	}
	
	
	/*
	 * Altera menu conforme o solicitado no metodo @menuPrincipal;
	 */
	private void menuEscolhido(String operacao) {
		int op = 0;
		int multiplicador = 1;
		
		if ( operacao == "i"){
			operacao = "Inserir";
		} else if ( operacao == "r") {
			operacao = "Remover";
			multiplicador = 5;
		} else if ( operacao == "l") {
			operacao = "Listar";
			multiplicador = 21;
		}
		
		
		do {
			System.out.println("\t SISTEMA ");
			System.out.println("1 - " +operacao+ " loca��o");
			System.out.println("2 - " +operacao+ " DVD");
			System.out.println("3 - " +operacao+ " cliente");
			System.out.println("4 - Sair");
			System.out.print("Op��o: ");
			
			op = ic.entrada.nextInt();
			ic.entrada.nextLine();

		} while ( op <= 0 && op < 4);

		op *= multiplicador;
		
		switch (op) {
			case 1: 
				il.adicionar();;
				break;
			case 2: 
				id.insereDvd();
				break;
			case 3: 
				ic.insereCliente();
				break;
			case 4|20|44:
				System.out.println("\n\t Execu��o encerrada!!!");
				System.exit(0);
				break;
				
			case 5: 
				il.excluir();
				break;
			case 10: 
				id.removeDvd();
				break;
			case 15: 
				ic.removeCliente();
				break;

			case 21:
				il.listarTodos();
				break;
			case 42:
				id.listaTodosDvd();
				break;
			case 63:
				ic.listaTodosCliente();
				break;
				
			default:
				break;
		}		
	}	
	
}
