package br.org.catolicasc.ui;

import java.util.Scanner;


public abstract class InterfaceModelo {

	abstract public void adicionar();
	abstract public void listarTodos();
	abstract public void editar();
	abstract public void excluir();
	protected Scanner entrada;
	
	
	
	public InterfaceModelo() {
		entrada = new Scanner(System.in);
	}
	
}
