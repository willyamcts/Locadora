package br.org.catolicasc.ui;


public class InterfacePrincipal {

	private Estado estadoAtual = Estado.PRINCIPAL;
	

	private enum Estado {PRINCIPAL, CLIENTE, DVD};

	
	
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
	
	
	
	protected void menuCliente() {}
	protected void menuDvd() {}
	protected void menuPrincipal() {}
		
}
