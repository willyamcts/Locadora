package br.org.catolicasc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
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
			stmt.setDate(4, new java.sql.Date(filme.getDataLancamento().getTimeInMillis()));
			
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
		
	private Filme getFilmeRS(ResultSet rs) throws SQLException {
		Filme filme = new Filme();
		
		filme.setId( rs.getInt("id") );
		filme.setTitulo(rs.getString("titulo"));
		filme.setGenero(rs.getString("genero"));
		filme.setDuracao( rs.getInt("duracao") );
		
		Calendar data = Calendar.getInstance();
		data.setTime(rs.getDate("dataLancamento"));
		filme.setDataLancamento(data);
			
		return filme;
 
	}
	/*
	 * Read by Id
	 */
	@Override
	public Filme getByKey(int id) {	
		Connection conn = DbConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		Filme f = new Filme();
		
		try {
			stmt = conn.prepareStatement(GET_BY_ID);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				f = getFilmeRS(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection(conn, stmt, rs);
		}
		
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
			
		Connection conn = DbConnection.getConnection();
		
		List<Filme> filmes = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(GET_ALL);
			
			while (rs.next()) {
				filmes.add(getFilmeRS(rs));
			}			
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao obter todos os dvd's.", e);
		} finally {
			DbConnection.closeConnection(conn, stmt, null);
		}
		
	
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
	 * Delete - Not used
	 */
	@Override
	public void delete(int id) {
		Connection conn = DbConnection.getConnection();
		
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(DELETE);
			
			stmt.setInt(1, id);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection(conn, stmt, null);
		}
		
	}
	
}
