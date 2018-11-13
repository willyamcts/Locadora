package br.org.catolicasc.ui;

import java.util.Scanner;

import bib.ui.InterfaceTexto.Estado;

public abstract class InterfaceModelo {

	abstract public void adicionar();
	abstract public void listarTodos();
	abstract public void editar();
	abstract public void excluir();
	protected Scanner entrada;
	private Estado estadoAtual = Estado.PRINCIPAL;
	

	private enum Estado {PRINCIPAL, CLIENTE, DVD};

	public InterfaceModelo() {
		entrada = new Scanner(System.in);
	}
	
	
	private void abreMenu() {
		System.out.println();
		
		switch (estadoAtual) {
		case CLIENTE:
			menuCliente(); //JPanel
			break;
		case DVD:
			menuDvd(); //JPanel
			break;
		default:
			menuPrincipal(); //JPanel
		}
		System.out.println();
		System.out.println("\tEM TELA PRINCIPAL");
	}
	
	
	
	
}
