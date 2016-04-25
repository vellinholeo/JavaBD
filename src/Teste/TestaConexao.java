package Teste;
import java.sql.Connection;
import java.sql.SQLException;

import pacote.ConnectionFactory;

public class TestaConexao {
	public static void main(String[] args) throws SQLException{
	Connection connection = new ConnectionFactory().getConnection();
	System.out.println("Aberta conexao!");
	connection.close();
	}
}
