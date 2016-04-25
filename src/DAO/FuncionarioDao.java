package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Funcionario;
import pacote.ConnectionFactory;

public class FuncionarioDao {
	private Connection connection;
	
	public FuncionarioDao(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void insertFuncionario(Funcionario fun){
		String sql = "insert into funcionarios "+"(nome,usuario,senha)"+ "values(?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);			
			ps.setString(1, fun.getNome());
			ps.setString(2, fun.getUsuario());
			ps.setString(3, fun.getSenha());
			ps.execute();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		//return false;
	}
	
	public List<Funcionario> selectFuncionario() throws SQLException{
		List<Funcionario> listFunc = new ArrayList<Funcionario>();
		String sql = "select * from funcionarios";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			Funcionario func = new Funcionario();
			
			func.setNome(rs.getString("nome"));
			func.setUsuario(rs.getString("usuario"));
			func.setSenha(rs.getString("senha"));
			
			listFunc.add(func);
		}
		return listFunc;
	}
	
	public void updateFuncionario(Funcionario func, int id) throws SQLException{
		String sql = "update funcionarios set nome=?, usuario=?,senha=? where id="+id;
		
		PreparedStatement ps = connection.prepareStatement(sql);		
		ps.setString(1, func.getNome());
		ps.setString(2, func.getUsuario());
		ps.setString(3, func.getSenha());
		
		ps.execute();
		ps.close();
	}
	
	public void removeFuncionario(Funcionario func) throws SQLException{
		String sql = "delete from funcionarios where id=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1, func.getId());
		
		ps.execute();
		ps.close();
	}

}
