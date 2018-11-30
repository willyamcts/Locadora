package br.org.catolicasc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.org.catolicasc.model.Telefone;

public class TelefoneDao implements Dao<Telefone> {
	
	private static final String GET_BY_ID = "SELECT * FROM telefone WHERE id = ?";
	private static final String GET_ALL = "SELECT * FROM telefone";
	private static final String INSERT = "INSERT INTO telefone (cod_area, numero) "
			+ "VALUES (?, ?)";
	private static final String UPDATE = "UPDATE telefone SET cod_area = ?, numero = ? WHERE id = ?";
	private static final String DELETE = "DELETE FROM telefone WHERE id = ?";

	
//Construtor da classe, ja cria a tabela no db;
	public TelefoneDao() {
		try {
			createTable();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao criar tabela pessoa no banco.", e);
		}
	}
	
	
//Metodo que cria a tabela 	
	private void createTable() throws SQLException {
	    String sqlTable = "CREATE TABLE IF NOT EXISTS telefone"
	            + "  (id           		INTEGER,"
	            + "   cod_area			INTEGER,"
	            + "   numero			VARCHAR(14),"
	            //+ "   pessoa_id			INTEGER,"
	            //+ "   FOREIGN KEY (pessoa_id) REFERENCES pessoa(id),"
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
	public void insert(Telefone telefone) {
		Connection conn = DbConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, telefone.getCodArea());
			stmt.setString(2, telefone.getNumero());
			
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			
			if (rs.next()) {
				telefone.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao inserir telefone.", e);
		}finally {
		    DbConnection.closeConnection(conn, stmt, null);
		}

		
		/*
		} finally {
			//Non implement, close in other method
		}
		*/
	}
	
	
	/*
	 * Read by Id
	 */
	@Override
	public Telefone getByKey(int id) {
		Connection conn = DbConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Telefone t = new Telefone();
		
		try {
			stmt = conn.prepareStatement(GET_BY_ID);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				t = getTelefoneRS(rs);
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection(conn, stmt, rs);
		}
		
		return t;
	}
	
	
	/*
	 * Read all
	 */
	@Override
	public List<Telefone> getAll() {
		List<Telefone> Telefones = null;
		

		//Implement
		
		
		return Telefones;
	}
	
	
	/*
	 * Update
	 */
	@Override
	public void update(Telefone t) {
		//Non Implement
	}
	
	
	/*
	 * Delete - // Not used
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

	
	
	private Telefone getTelefoneRS(ResultSet rs) throws SQLException {
		Telefone t = new Telefone();
 		t.setId( rs.getInt("id") );
		t.setCodArea( rs.getInt("cod_area") );
		t.setNumero( rs.getString("numero") );
		
		
		return t;
	}
	
	
}
