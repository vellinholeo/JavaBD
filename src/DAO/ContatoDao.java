package DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Model.Contato;
import pacote.ConnectionFactory;

public class ContatoDao{
	private Connection connection;

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) {
		String sql = "insert into contatos " + "(nome,email,endereco,dataNascimento)" + " values (?,?,?,?)";
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contato> getLista() throws SQLException {
		List<Contato> contatos = new ArrayList<Contato>();
		PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where nome like 'C%'");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			// criando o objeto Contato
			Contato contato = new Contato();
			contato.setNome(rs.getString("nome"));
			contato.setEmail(rs.getString("email"));
			contato.setEndereco(rs.getString("endereco"));

			// montando a data através do Calendar
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("dataNascimento"));
			contato.setDataNascimento(data);

			// adicionando o objeto à lista
			contatos.add(contato);
		}

		rs.close();
		stmt.close();

		return contatos;
	}

	public Contato pesquisar(int id) throws SQLException {
		Contato contatos = new Contato();
		PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where id =" + id);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			contatos.setNome(rs.getString("nome"));
			contatos.setEmail(rs.getString("email"));
			contatos.setEndereco(rs.getString("endereco"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("dataNascimento"));
			contatos.setDataNascimento(data);
			// String dataFormatada = new SimpleDateFormat("dd/MM/yyyy
			// HH:mm:ss").format(contato.getDataNascimento().getTime());
			// contato.setDataNascimento(dataFormatada);
		}

		return contatos;
	}

	public void altera(Contato contato) {
		String sql = "update contatos set nome=?, email=?," + "endereco=?, dataNascimento=? where id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Contato contato) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from contatos where id=?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
			System.out.println("Removido");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
