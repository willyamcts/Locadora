package br.org.catolicasc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.org.catolicasc.model.Filme;

public class FilmeDao implements Dao<Filme> {
	
	private static final String GET_BY_ID = "SELECT * FROM filme WHERE id = ?";
	private static final String GET_ALL = "SELECT * FROM filme";
	private static final String INSERT = "INSERT INTO filme (titulo, genero, duracao, data_lancamento) "
			+ "VALUES (?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE filme SET titulo = ?, genero = ?, "
			+ "duracao = ?, data_lancamento = ?";
	private static final String DELETE = "DELETE FROM filme WHERE id = ?";

	
//Construtor da classe, ja cria a tabela no db;
	public FilmeDao() {
		try {
			createTable();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao criar tabela filme no banco.", e);
		}
	}
	
	
//Metodo que cria a tabela 	
	private void createTable() throws SQLException {
	    String sqlTable = "CREATE TABLE IF NOT EXISTS filme"
	            + "  (id           		INTEGER,"
	            + "   titulo			VARCHAR(250),"
	            + "   genero			VARCHAR(250),"
	            + "   duracao			INTEGER,"
	            + "   data_lancamento	TEXT,"
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
	public void insert(Filme filme) {
		Connection conn = DbConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		try {
			stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, filme.getTitulo());
			stmt.setString(2, filme.getGenero());
			stmt.setLong(3, filme.getDuracao());
			stmt.setDate(4, new java.sql.Date(filme.getDataLancamento().getTime()));
			
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			
			if (rs.next()) {
				filme.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao inserir filme.", e);
		}finally {
		    DbConnection.closeConnection(conn, stmt, null);
		}
	}
		
	
	/*
	 * Read by Id
	 */
	@Override
	public Filme getByKey(int id) {
		Filme f = new Filme();
		
		
		//Implement
		
		return f;
	}
	
	
	/*
	 * Read by name
	 */
	/*
	public Filme pesquisaByName(String titulo){
		Filme filme = null;
		
		//Implement - Non
		
		return filme;
	}
	*/
	
	
	/*
	 * Read all
	 */
	@Override
	public List<Filme> getAll() {
		List<Filme> filmes = null;		
		
		
		//Implement		
		
		
		return filmes;
	}


	/*
	 * Update
	 */
	@Override
	public void update(Filme f) {		
		
		//Implement - Non
		
	}
	
		
	/*
	 * Delete
	 */
	@Override
	public void delete(int id) {
		
		//Implement - Non
		
	}

}
