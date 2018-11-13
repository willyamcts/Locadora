package br.org.catolicasc.gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuPrincipal extends JFrame {
	
	
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
	
	
	public static void main(String[] args) {
		new MenuPrincipal("Locacao");
		
	}
	
	
}
