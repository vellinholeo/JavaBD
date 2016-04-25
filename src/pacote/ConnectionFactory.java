package pacote;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
	     try {
	         return DriverManager.getConnection(
	 "jdbc:mysql://localhost/test", "root", "root");
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	//stmt.setDate(4, new java.sql.Date(
    //        Calendar.getInstance().getTimeInMillis()));
	//stmt.setDate(4, dataParaGravar);
	//stmt.execute();
}
