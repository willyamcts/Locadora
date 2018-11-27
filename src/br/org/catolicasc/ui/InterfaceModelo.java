package br.org.catolicasc.ui;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public abstract class InterfaceModelo {
	/*
	abstract public void adicionar();
	abstract public void listarTodos();
	abstract public void editar();
	abstract public void excluir();
	*/
	protected Scanner entrada;
	
	
	
	public InterfaceModelo() {
		entrada = new Scanner(System.in);
	}

	
	
	
	protected void pulaLinhas() {
		for (int i=0; i < 2; i++) {System.out.println("\n");}
	}
	
	
	
	/*
	 * Formata data para o formato "dd/MM/yyyy",
	 * retornando um Date;
	 */
	public Date formataData(String d){		

		Date date = null;		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = df.parse(d);
		} catch (ParseException e){
			e.printStackTrace();
		}		
		
		return date;
	}
	
	
	/*
	 * Retorna data de hoje em obj Date chamando 
	 * metodo de formatacao da data;
	 */
	public Date dataAtual() {		
		Date date = new Date();

		/*
		// Formata data;
		String d = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(date);
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		return (date = df.parse(d));
		*/
		
		String dateS = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(date);
		//java.sql.Date dateSQL = new java.sql.Date(formataData(dateS));
		return formataData(dateS);
	}
	
	
	/*
	 * Acrescenta 6 dias ao dia de hoje e retorna
	 *  o objeto Date;
	 */
	public Date addDiasAData(int qtdDias) {
		Date hoje = dataAtual();
		Date data = null;
		
		Calendar c = Calendar.getInstance();
		c.setTime(hoje);		
		c.add(Calendar.DATE, +qtdDias);
		
		data = c.getTime();
		
		return data;
	}
	
	
	protected int geraRandom(){
		int x = (int) (Math.random() * 1001);
		
		return x;
	}
	
	
	
}
