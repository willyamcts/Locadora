package br.org.catolicasc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.org.catolicasc.model.Endereco;

public class EnderecoDao implements Dao<Endereco> {
	
	private static final String GET_BY_ID = "SELECT * FROM endereco WHERE id = ?";
	private static final String GET_ALL = "SELECT * FROM endereco";
	private static final String INSERT = "INSERT INTO endereco (cidade, bairro, logradouro, numero_residencia) "
			+ "VALUES (?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE endereco SET cidade = ?, bairro = ?, "
			+ "logradouro = ?, numero_residencia = ?";
	private static final String DELETE = "DELETE FROM endereco WHERE id = ?";

	
//Construtor da classe, ja cria a tabela no db;
	public EnderecoDao() {
		try {
			createTable();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao criar tabela endereco no banco.", e);
		}
	}
	
	
//Metodo que cria a tabela 	
	private void createTable() throws SQLException {
	    String sqlTable = "CREATE TABLE IF NOT EXISTS endereco"
	            + "  (id           		INTEGER,"
	            + "   cidade			VARCHAR(20),"
	            + "   bairro			VARCHAR(30),"
	            + "   logradouro		VARCHAR(50),"
	            + "   numero_residencia	INTEGER,"
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
	public void insert(Endereco end) {
		Connection conn = DbConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		try {
			stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, end.getCidade());
			stmt.setString(2, end.getBairro());
			stmt.setString(3, end.getLogradouro());
			stmt.setInt(4, end.getNumeroResidencia());
			
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			
			if (rs.next()) {
				end.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao inserir endereco.", e);
		}finally {
		    DbConnection.closeConnection(conn, stmt, null);
		}
	}


	@Override
	public Endereco getByKey(int id) {
		Connection conn = DbConnection.getConnection();
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	Endereco e = null;
	
	try {
		stmt = conn.prepareStatement(GET_BY_ID);
		stmt.setInt(1, id);
		rs = stmt.executeQuery();
		
		if (rs.next()) {
			e = getEnderecoRS(rs);
		}
	} catch (SQLException ex) {
		ex.printStackTrace();
	} finally {
		DbConnection.closeConnection(conn, stmt, rs);
	}
	
	return e;
	}


	@Override
	public List<Endereco> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Endereco t) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	private Endereco getEnderecoRS(ResultSet rs) throws SQLException {
		Endereco e = new Endereco();
		
		e.setId( rs.getInt("id") );
		e.setCidade( rs.getString("cidade") );
		e.setBairro( rs.getString("bairro") );
		e.setLogradouro( rs.getString("logradouro") );
		e.setNumeroResidencia( rs.getInt("numero_residencia") );
    
    	return e;
	}
	
}
