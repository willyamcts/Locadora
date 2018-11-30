package br.org.catolicasc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.org.catolicasc.dao.DbConnection;
import br.org.catolicasc.model.Cliente;
import br.org.catolicasc.model.Endereco;
import br.org.catolicasc.model.Pessoa;
import br.org.catolicasc.model.Telefone;

public class ClienteDao implements Dao<Cliente> {
	
	private static final String GET_BY_ID = "SELECT * FROM cliente NATURAL JOIN pessoa WHERE id = ?";
	private static final String GET_ALL = "SELECT * FROM cliente NATURAL JOIN pessoa";
	private static final String INSERT = "INSERT INTO cliente (pessoa_id, locador) "
			+ "VALUES (?, ?)";
	private static final String UPDATE = "UPDATE cliente SET pessoa_id = ?, locador = ?";
	private static final String DELETE = "DELETE FROM cliente WHERE id = ?";

	
//Construtor da classe, ja cria a tabela no db;
	public ClienteDao() {
		try {
			createTable();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao criar tabela cliente no banco.", e);
		}
	}
	
	
//Metodo que cria a tabela 	
	private void createTable() throws SQLException {
	    String sqlTable = "CREATE TABLE IF NOT EXISTS cliente"
	            + "  (id           		INTEGER,"
	            + "   pessoa_id       	INTEGER,"
	            + "   locador       	INTEGER,"
	            + "   FOREIGN KEY (pessoa_id) REFERENCES pessoa(id),"
	            + "   PRIMARY KEY (id))";
	    
	    Connection conn = DbConnection.getConnection();

	    Statement stmt = conn.createStatement();
	    stmt.execute(sqlTable);
	    
	    DbConnection.closeConnection(conn, stmt, null);
	}
	
	
//Metodos que insere clientes no banco
	@Override
	public void insert(Cliente cliente) {
		Connection conn = DbConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		//boolean locador = false; //false
		
		try {
			stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, cliente.getPessoa().getId());
			stmt.setBoolean(2, cliente.isLocacao());
			
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			
			if (rs.next()) {
				cliente.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao inserir cliente.", e);
		}finally {
		    DbConnection.closeConnection(conn, stmt, null);
		}

	}
	
	
	
	@Override
	public Cliente getByKey(int id) {
		Connection conn = DbConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		Cliente c = null;
		
		try {
			stmt = conn.prepareStatement(GET_BY_ID);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				c = getClienteRs(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection(conn, stmt, rs);
		}
		
		return c;
	}


	@Override
	public List<Cliente> getAll() {
		List<Cliente> clientes = new ArrayList<>();
	
		Connection conn = DbConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(GET_ALL);
			
			while (rs.next()) {
				clientes.add(getClienteRs(rs));
			}			
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao obter todos os clientes.", e);
		} finally {
			DbConnection.closeConnection(conn, stmt, rs);
		}
	
		return clientes;
	}
	

	/*
	 * Update
	 */
	@Override
	public void update(Cliente cliente) {
		Connection conn = DbConnection.getConnection();
		
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(UPDATE);
			stmt.setInt(1, cliente.getPessoa().getId());
			stmt.setBoolean(2, cliente.isLocacao());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection(conn, stmt, null);
		}
		
	}
	
	
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


	
	
	
	private Cliente getClienteRs(ResultSet rs) throws SQLException
    {
		Cliente cliente = new Cliente();
			
		cliente.setId( rs.getInt("id") );
		cliente.setLocacao(rs.getBoolean("locador"));
		

		Pessoa p = new Pessoa();		
		
		p.setId( rs.getInt("pessoa_id") );
		p.setNome( rs.getString("nome") );
		p.setCpf( rs.getString("cpf") );
		p.setIdade( rs.getInt("idade") );
		
		
		/*
		Telefone tel = new Telefone();
		
		tel.setId(rs.getInt("telefone_id"));
		tel.setCodArea(rs.getInt("cod_area"));
		tel.setNumero(rs.getString("numero"));
		
		
		Endereco endereco = new Endereco();
		
		endereco.setId( rs.getInt("p.endereco_id"));
		endereco.setCidade(rs.getString("cidade"));
		endereco.setBairro(rs.getString("bairro"));
		endereco.setLogradouro(rs.getString("logradouro"));
		endereco.setNumeroResidencia(rs.getInt("numero_residencia"));
		
		
		p.setEndereco(endereco);
		p.setTelefone(tel);
		*/
		
		cliente.setPessoa(p);
	
		return cliente;
    }
	
	
}
