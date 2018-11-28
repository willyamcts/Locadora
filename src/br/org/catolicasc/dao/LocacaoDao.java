package br.org.catolicasc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

import br.org.catolicasc.model.Cliente;
import br.org.catolicasc.model.Dvd;
import br.org.catolicasc.model.Filme;
import br.org.catolicasc.model.Locacao;

public class LocacaoDao implements Dao<Locacao> {
	
	private static final String GET_BY_ID = "SELECT * FROM locacao NATURAL JOIN dvd ON dvd_id = dvd.id "
			+ "NATURAL JOIN cliente ON cliente_id = cliente.id WHERE id = ?";
	private static final String GET_ALL = "SELECT * FROM locacao NATURAL JOIN dvd ON dvd_id = dvd.id "
			+ "NATURAL JOIN cliente ON cliente_id = cliente.id";
	private static final String INSERT = "INSERT INTO locacao (data_locacao, data_devolucao, dvd_id, cliente_id) "
			+ "VALUES (?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE locacao SET data_locacao = ?, data_devolucao = ?, "
			+ "dvd_id = ?, cliente_id = ?";
	private static final String DELETE = "DELETE FROM locacao WHERE id = ?";

	
//Construtor da classe, ja cria a tabela no db;
	public LocacaoDao() {
		try {
			createTable();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao criar tabela locacao no banco.", e);
		}
	}
	
	
//Metodo que cria a tabela 	
	private void createTable() throws SQLException {
	    String sqlTable = "CREATE TABLE IF NOT EXISTS locacao"
	            + "  (id           		INTEGER,"
	            + "   data_locacao		TEXT,"
	            + "   data_devolucao	TEXT,"
	            + "   dvd_id			INTEGER,"
	            + "   cliente_id		INTEGER,"
	            + "   FOREIGN KEY (dvd_id) REFERENCES dvd(id),"
	            + "   FOREIGN KEY (cliente_id) REFERENCES cliente(id),"
	            + "   PRIMARY KEY (id))";
	    
	    Connection conn = DbConnection.getConnection();


	    Statement stmt = conn.createStatement();
	    stmt.execute(sqlTable);
	    
	    DbConnection.closeConnection(conn, stmt, null);
	}	
	
	
	
	/*
	 * Create
	 */
	public void insert(Locacao l) {
		Connection conn = DbConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		try {
			stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setDate(1, new java.sql.Date(l.getAluguel().getTimeInMillis()) );
			stmt.setDate(2, new java.sql.Date(l.getDevolucao().getTimeInMillis()) );
			stmt.setInt(3, l.getDvd().getId());
			stmt.setInt(4, l.getCliente().getId());
			
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			
			if (rs.next()) {
				l.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao inserir locacao.", e);
		}finally {
		    DbConnection.closeConnection(conn, stmt, null);
		}
	}
	
	
	/*
	 * Read by Id 
	 */
	@Override
	public Locacao getByKey(int id) {
		Connection conn = DbConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		Locacao l = null;
		
		try {
			stmt = conn.prepareStatement(GET_BY_ID);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				l = getLocacaoRS(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection(conn, stmt, rs);
		}
		
		return l;
	}
	

	/*
	 * Read all;
	 */
	@Override
	public List<Locacao> getAll() {
		Connection conn = DbConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Locacao> locacao = new ArrayList<>();
		
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(GET_ALL);
			
			while (rs.next()) {
				locacao.add(getLocacaoRS(rs));
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection(conn, stmt, rs);
		}
			
			return locacao;
	}
	
	
	/*
	 * Update
	 */
	@Override
	public void update(Locacao t) {
		// Non implement		
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



	private Locacao getLocacaoRS(ResultSet rs) throws SQLException {
		Locacao l = new Locacao();
			
		l.setId( rs.getInt("id") );
		
		Calendar data = Calendar.getInstance();
		data.setTime(rs.getDate("data_locacao"));
		l.setAluguel(data);
		
		data = null;
		data.setTime(rs.getDate("data_devolucao"));
		l.setDevolucao(data);
		
		Filme f = new Filme();
		data = null;
		data.setTime(rs.getDate("data_devolucao"));
		f.setId(rs.getInt("filme_id"));
		f.setTitulo(rs.getString("titulo"));
		f.setGenero(rs.getString("genero"));
		f.setDuracao(rs.getLong("duracao"));
		f.setDataLancamento(data);
		
		data = null;
		Dvd dvdLocado = new Dvd(rs.getInt("dvd_id"), rs.getInt("codigo"), rs.getBoolean("locado"), f); 
		l.setDvd( dvdLocado );
	
		return l;
    }


}
