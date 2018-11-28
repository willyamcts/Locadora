package br.org.catolicasc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.org.catolicasc.model.Dvd;
import br.org.catolicasc.model.Filme;

public class DvdDao implements Dao<Dvd> {
	
	private static final String GET_BY_ID = "SELECT * FROM dvd NATURAL JOIN filme WHERE id = ?";
	private static final String GET_ALL = "SELECT * FROM dvd NATURAL JOIN filme";
	private static final String INSERT = "INSERT INTO dvd (codigo, locado, filme_id) "
			+ "VALUES (?, ?, ?)";
	private static final String UPDATE = "UPDATE dvd SET codigo = ?, locado = ?, "
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
	            + "   codigo			INTEGER,"
	            + "   locado			NUMERIC,"
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
		Connection conn = DbConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		Dvd d = null;
		
		try {
			stmt = conn.prepareStatement(GET_BY_ID);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				d = getDvdRS(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection(conn, stmt, rs);
		}
		
		return d;
	}
	
	
	/*
	 * Read all
	 */
	@Override
	public List<Dvd> getAll() {
		List<Dvd> dvds = new ArrayList<>();
		
		Connection conn = DbConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(GET_ALL);
			
			while (rs.next()) {
				dvds.add(getDvdRS(rs));
			}			
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao obter todos os dvds.", e);
		} finally {
			DbConnection.closeConnection(conn, stmt, rs);
		}
		
		return dvds;
	}
	
	
	/*
	 * Update
	 */
	@Override
	public void update(Dvd dvd) {
		Connection conn = DbConnection.getConnection();
		
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(UPDATE);
			stmt.setInt(1, dvd.getCod());
			stmt.setBoolean(2, dvd.isLocacao());
			stmt.setInt(3, dvd.getFilme().getId());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection(conn, stmt, null);
		}
		
	}
	
	
	/*
	 * Delete
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
	
	
	
	
	private Dvd getDvdRS(ResultSet rs) throws SQLException {
		Dvd dvd = new Dvd();
			
		dvd.setId( rs.getInt("id") );
		dvd.setCod(rs.getInt("codigo"));
		dvd.setLocacao(rs.getBoolean("locado"));
		
		
		Filme f = new Filme();
		
		//Calendar data = Calendar.getInstance();		
		//data.setTime(rs.getDate("data_lancamento"));
		
		f.setId(rs.getInt("filme_id"));
		f.setTitulo(rs.getString("titulo"));
		f.setGenero(rs.getString("genero"));
		f.setDuracao(rs.getLong("duracao"));
		//f.setDataLancamento(data);
		f.setDataLancamento(rs.getString("data_lancamento"));
		
		dvd.setFilme(f);
	
		return dvd;
    }
	
}
