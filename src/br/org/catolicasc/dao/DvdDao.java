package br.org.catolicasc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.org.catolicasc.model.Dvd;

public class DvdDao implements Dao<Dvd> {
	
	private static final String GET_BY_ID = "SELECT * FROM dvd NATURAL JOIN filme WHERE id = ?";
	private static final String GET_ALL = "SELECT * FROM dvd NATURAL JOIN filme";
	private static final String INSERT = "INSERT INTO dvd (cod, locacao, filme_id) "
			+ "VALUES (?, ?, ?)";
	private static final String UPDATE = "UPDATE dvd SET cod = ?, locacao = ?, "
			+ "filme_id = ?";
	private static final String DELETE = "DELETE FROM dvd WHERE id = ?";

	
//Construtor da classe, ja cria a tabela no db;
	public DvdDao() {
		try {
			createTable();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao criar tabela dvd no banco.", e);
		}
	}
	
	
//Metodo que cria a tabela 	
	private void createTable() throws SQLException {
	    String sqlTable = "CREATE TABLE IF NOT EXISTS dvd"
	            + "  (id           		INTEGER,"
	            + "   cod				INTEGER,"
	            + "   locacao			NUMERIC,"
	            + "   filme_id			INTEGER,"
	            + "   FOREIGN KEY (filme_id) REFERENCES filme(id),"
	            + "   PRIMARY KEY (id))";
	    
	    Connection conn = DbConnection.getConnection();


	    Statement stmt = conn.createStatement();
	    stmt.execute(sqlTable);
	    
	    DbConnection.closeConnection(conn, stmt, null);
	}



	/*
	 * Create
	 */
	@Override
	public void insert(Dvd dvd) {
		Connection conn = DbConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		try {
			stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, dvd.getCod());
			stmt.setBoolean(2, dvd.isLocacao());
			stmt.setInt(3, dvd.getFilme().getId());
			
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			
			if (rs.next()) {
				dvd.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao inserir dvd.", e);
		}finally {
		    DbConnection.closeConnection(conn, stmt, null);
		}
	}
	
	
	/*
	 * Read by Id
	 */
	@Override
	public Dvd getByKey(int id) {
		Dvd d = new Dvd();
		
		if ( id > 0 ){

			// Implement
			
		}
		
		return d;
	}
	
	
	/*
	 * Read all
	 */
	@Override
	public List<Dvd> getAll() {

		List<Dvd> dvds = null;

		// Implement
		
		
		return dvds;
	}
	
	
	/*
	 * Update
	 */
	@Override
	public void update(Dvd dvd) {

		// Implement
		
	}
	
	
	/*
	 * Delete
	 */
	@Override
	public void delete(int id) {
		Dvd dvd = null;

		//Implement
		
	}
	
}
