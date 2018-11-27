package br.org.catolicasc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.org.catolicasc.model.Cliente;
import br.org.catolicasc.model.Dvd;
import br.org.catolicasc.model.Filme;
import br.org.catolicasc.model.Locacao;

public class LocacaoDao implements Dao<Locacao> {
	
	private static final String GET_BY_ID = "SELECT * FROM locacao NATURAL JOIN dvd NATURAL JOIN cliente WHERE id = ?";
	private static final String GET_ALL = "SELECT * FROM locacao";
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
			stmt.setDate(1, new java.sql.Date(l.getAluguel().getTime()));
			stmt.setDate(2, new java.sql.Date(l.getDevolucao().getTime()));
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
		List<Locacao> locacoes = null;

		// implement
		
		return locacoes;
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

	
	// https://stackoverflow.com/questions/24736427/how-to-get-date-from-a-resultset
	private Locacao getLocacaoRS(ResultSet rs) throws SQLException {
		Locacao l = new Locacao();
			
		l.setId( rs.getInt("id") );
		l.setAluguel(rs.);
		l.setCod(rs.getDate("codigo"));
		l.setLocacao(rs.getBoolean("locado"));
		l.setFilme( new Filme(rs.getInt("filme_id"), rs.getString("titulo"), rs.getString("titulo"),
				rs.getLong("duracao"), rs.XXXXXXXX("data_lancamento")) );
	
		return l;
    }


}
