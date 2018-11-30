package br.org.catolicasc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.org.catolicasc.model.Cliente;
import br.org.catolicasc.model.Endereco;
import br.org.catolicasc.model.Pessoa;
import br.org.catolicasc.model.Telefone;

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
		Connection conn = DbConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		Pessoa p = null;
		
		try {
			stmt = conn.prepareStatement(GET_BY_ID);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				p = getPessoaRS(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection(conn, stmt, rs);
		}
	
	return p;
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

	
	
	private Pessoa getPessoaRS(ResultSet rs) throws SQLException {
		EnderecoDao enderecoDao = new EnderecoDao();
		TelefoneDao telefoneDao = new TelefoneDao();
		Pessoa p = new Pessoa();		
		
		p.setId( rs.getInt("id") );
		p.setNome( rs.getString("nome") );
		p.setCpf( rs.getString("cpf") );
		p.setIdade( rs.getInt("idade") );
		
		//Endereco endereco = enderecoDao.getByKey( rs.getInt("endereco_id") );
		//Telefone telefone = telefoneDao.getByKey( rs.getInt("telefone_id") );
		Endereco endereco = new Endereco();
		
		endereco.setId( rs.getInt("endereco_id") );
		endereco.setCidade( rs.getString("cidade") );
		endereco.setBairro( rs.getString("bairro") );
		endereco.setLogradouro( rs.getString("logradouro") );
		endereco.setNumeroResidencia( rs.getInt("numero_residencia") );
		
		Telefone telefone = new Telefone();
		
		telefone.setId( rs.getInt("telefone_id") );
		telefone.setCodArea( rs.getInt("cod_area") );
		telefone.setNumero( rs.getString("numero") );
		
		p.setEndereco(endereco);
		p.setTelefone(telefone);
		
		return p;
	}
	
}
