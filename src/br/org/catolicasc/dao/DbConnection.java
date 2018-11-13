package br.org.catolicasc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {
	public static final String URL = "jdbc:sqlite:banco.db";
	
	private static Connection conn = null;

	/*  Obtem um conexao com o banco e 
	 * @return objeto Connection */
	public static Connection getConnection() {
		
		try {
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(URL);
			}
		} catch (SQLException ex) {
			throw new RuntimeException("Erro na tentativa de conexão ao SQLite", ex);
		}
	
		return conn;
	}
}
