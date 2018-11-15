package br.org.catolicasc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.org.catolicasc.dao.DbConnection;

public class ClienteDao implements Dao<Cliente> {	
	
	private static final String GET_BY_ID = "SELECT * FROM cliente WHERE id = ?";
	private static final String GET_ALL = "SELECT * FROM cliente";
	private static final String INSERT = "INSERT INTO cliente (nome, cpf, endereco, telefone, locador) "
			+ "VALUES (?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE cliente SET nome = ?, cpf = ?, endereco = ?, "
			+ "telefone = ?, locador = ? WHERE id = ?";
	private static final String DELETE = "DELETE FROM cliente WHERE id = ?";

	
//Construtor da classe, ja cria a tabela no db;
	public ClienteDao() {
		try {
			createTable();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao criar tabela no banco.", e);
		}
	}
	
	
//Metodo que cria a tabela 	
	private void createTable() throws SQLException {
	    String sqlTable = "CREATE TABLE IF NOT EXISTS cliente"
	            + "  (id           INTEGER,"
	            + "   nome            VARCHAR(50),"
	            + "   cpf			  BIGINT,"
	            + "   endereco           VARCHAR(255),"
	            + "   telefone           BIGINT,"
	            + "   locador       INTEGER,"
	            + "   PRIMARY KEY (id))";
	    
	    Connection conn = DbConnection.getConnection();


	    Statement stmt = conn.createStatement();
	    stmt.execute(sqlTable);
	    
	    close(conn, stmt, null);
	}
	
	
//Metodos que insere clientes no banco
	@Override
	public void insert(Cliente cliente) {
		Connection conn = DbConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		int getLocador = 0; //false
		
		if (cliente.isLocador()) {
			getLocador = 1;
		}
		
		try {
			stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, cliente.getNome());
			stmt.setLong(2, cliente.getCpf());
			stmt.setString(3, cliente.getEndereco());
			stmt.setLong(4, cliente.getTelefone());
			stmt.setInt(5, getLocador);
			
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			
			if (rs.next()) {
				cliente.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao inserir cliente.", e);
		}finally {
			close(conn, stmt, rs);
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao fechar recursos.", e);
		}		
	}


	@Override
	public Cliente getByKey(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Cliente> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Cliente t) {
		// TODO Auto-generated method stub
		
	}
	
}
