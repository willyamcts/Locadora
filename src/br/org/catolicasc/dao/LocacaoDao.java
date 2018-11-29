package br.org.catolicasc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import br.org.catolicasc.model.Cliente;
import br.org.catolicasc.model.Dvd;
import br.org.catolicasc.model.Endereco;
import br.org.catolicasc.model.Filme;
import br.org.catolicasc.model.Locacao;
import br.org.catolicasc.model.Pessoa;
import br.org.catolicasc.model.Telefone;

public class LocacaoDao implements Dao<Locacao> {
	
	private static final String GET_BY_ID = "SELECT * FROM locacao NATURAL JOIN dvd "
			+ "NATURAL JOIN cliente WHERE id = ?";
	private static final String GET_ALL = "SELECT * FROM locacao NATURAL JOIN dvd "
			+ "NATURAL JOIN cliente";
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
			stmt.setString(1, l.getAluguel());
			stmt.setString(2, l.getDevolucao());
			//stmt.setDate(1, new java.sql.Date(l.getAluguel().getTimeInMillis()) );
			//stmt.setDate(2, new java.sql.Date(l.getDevolucao().getTimeInMillis()) );
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
	 * Update - Not used
	 */
	@Override
	public void update(Locacao t) {
		// Non implement		
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



	private Locacao getLocacaoRS(ResultSet rs) throws SQLException {
		Locacao l = new Locacao();
			
		l.setId( rs.getInt("id") );
		l.setAluguel(rs.getString("data_locacao"));
		l.setDevolucao(rs.getString("data_devolucao"));
		
		/*
		Calendar data = Calendar.getInstance();		
		data.setTime(rs.getDate("data_locacao"));
		l.setAluguel(data);
		
		data = null;
		data.setTime(rs.getDate("data_devolucao"));
		l.setDevolucao(data);
		*/
		
		
		Filme f = new Filme();
		//data = null;
		//data.setTime(rs.getDate("data_lancamento"));
		f.setId(rs.getInt("filme_id"));
		/*
		f.setTitulo(rs.getString("titulo"));
		f.setGenero(rs.getString("genero"));
		f.setDuracao(rs.getLong("duracao"));
		f.setDataLancamento(rs.getString("data_lancamento"));
		//f.setDataLancamento(data);
		*/
		//data = null;
		
		
		Dvd dvd = new Dvd();
		//Dvd dvdLocado = new Dvd(rs.getInt("id"), rs.getInt("codigo"), rs.getBoolean("locado"), f);
		//l.setDvd( dvdLocado );
		
		dvd.setId( rs.getInt("dvd_id") );
		//dvd.setCod( rs.getInt("codigo") );
		dvd.setFilme(f);
		l.setDvd(dvd);
		
		Pessoa p = new Pessoa();
		p.setId( rs.getInt("pessoa_id") );
		
		
		Cliente cliente = new Cliente( rs.getInt("cliente_id"), rs.getBoolean("locador"), p );		
		l.setCliente(cliente);
	
		return l;
    }


}
