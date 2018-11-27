package br.org.catolicasc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.org.catolicasc.model.Cliente;
import br.org.catolicasc.model.Pessoa;

public class PessoaDao implements Dao<Pessoa> {
	
	private static final String GET_BY_ID = "SELECT * FROM pessoa NATURAL JOIN telefone NATURAL JOIN endereco WHERE id = ?";
	private static final String GET_ALL = "SELECT * FROM pessoa NATURAL JOIN telefone NATURAL JOIN endereco";
	private static final String INSERT = "INSERT INTO pessoa (nome, cpf, idade, endereco_id, telefone_id) "
			+ "VALUES (?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE pessoa SET nome = ?, cpf = ?, idade = ?, "
			+ "endereco_id = ?, telefones_id = ? WHERE id = ?";
	private static final String DELETE = "DELETE FROM pessoa WHERE id = ?";

	
//Construtor da classe, ja cria a tabela no db;
	public PessoaDao() {
		try {
			createTable();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao criar tabela pessoa no banco.", e);
		}
	}
	
	
	
	private void createTable() throws SQLException {
	    String sqlTable = "CREATE TABLE IF NOT EXISTS pessoa"
	            + "  (id           		INTEGER,"
	            + "   nome				VARCHAR(50),"
	            + "   cpf				VARCHAR(14),"
	            + "   idade        		INTEGER,"
	            + "   endereco_id		INTEGER,"
	            + "   telefone_id		INTEGER,"
	            + "   FOREIGN KEY (endereco_id) REFERENCES endereco(id),"
	            + "   FOREIGN KEY (telefone_id) REFERENCES telefone(id),"
	            + "   PRIMARY KEY (id))";
	    
	    Connection conn = DbConnection.getConnection();


	    Statement stmt = conn.createStatement();
	    stmt.execute(sqlTable);
	    
	    DbConnection.closeConnection(conn, stmt, null);
	}
	
	

	@Override
	public void insert(Pessoa pessoa) {
		Connection conn = DbConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getCpf());
			stmt.setInt(3, pessoa.getIdade());
			stmt.setInt(4, pessoa.getEndereco().getId());
			stmt.setInt(5, pessoa.getTelefone().getId());
			
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			
			if (rs.next()) {
				pessoa.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao inserir cliente.", e);
		}finally {
		    DbConnection.closeConnection(conn, stmt, null);
		}

	}


	@Override
	public Pessoa getByKey(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Pessoa> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Pessoa p) {
		// TODO Auto-generated method stub
		
	}

	
	

}
