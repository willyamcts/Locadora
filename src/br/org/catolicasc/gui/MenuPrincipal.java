package br.org.catolicasc.gui;

import javax.swing.JFrame;
import br.org.catolicasc.dao.ClienteDao;
import br.org.catolicasc.model.Cliente;
import br.org.catolicasc.dao.ClienteDao;

import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuPrincipal extends JFrame {
	
	/*
	public MenuPrincipal(String a) {
		

		JButton jb = new JButton();
		
		//jb.setText("Adicionar cliente");
		jb.setBounds(100, 350, 80, 45);
		add(jb);
		
		
		setTitle("Locadora");
		setSize(700,550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	*/
	
	
	public static void main(String[] args) {
		//new MenuPrincipal("Locacao");


		Scanner entrada = new Scanner(System.in);
		
		
		

		System.out.print("Insira o nome do cliente: ");
		String nome = entrada.nextLine();
		
		System.out.println("Insira o CPF do cliente (somente nÃºmeros): ");
		long cpf = entrada.nextLong();
		entrada.nextLine();
		
		System.out.println("Insira o endereco do cliente: ");
		String endereco = entrada.nextLine();
		
		System.out.println("Insira o telefone do cliente (somente nÃºmeros): ");
		long telefone = entrada.nextLong();
		entrada.nextLine();

		
		Cliente novoCliente = new Cliente(
	
	// Verificar as chamadas do pacote Banco e implementar a inserção no sqlite;
		//RE: Só recebe um cliente e passas para o método insert;
		
		ClienteDao dao = new ClienteDao();
		dao.insert(novoCliente);
	}
	
}
