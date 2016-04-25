package Teste;

import java.sql.SQLException;
import java.util.List;

import DAO.FuncionarioDao;
import Model.Funcionario;

public class executaFuncionario {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		FuncionarioDao funcDao = new FuncionarioDao();
		Funcionario func = new Funcionario();
		Funcionario func2 = new Funcionario();
		List<Funcionario> listaFunc;
		
		func.setNome("Leonardo");
		func.setUsuario("vellinholeo");
		func.setSenha("vellinho");
		
		func2.setNome("Joao");
		func2.setUsuario("joaozinho");
		func2.setSenha("oaoj");
		
		funcDao.insertFuncionario(func);										//INSERT
		funcDao.insertFuncionario(func2);										//INSERT
		System.out.println(" ");
		listaFunc = funcDao.selectFuncionario();								//SELECT
		for(Funcionario f: listaFunc){
			System.out.println("Nome:"+ f.getNome());
			System.out.println("Usuario:"+ f.getUsuario());
			System.out.println("Senha:"+f.getSenha());
			System.out.println(" ");
		}
		System.out.println(" ");
		func.setNome("Leonardo Vellinho");
		funcDao.updateFuncionario(func, 1); 										//UPDATE
		
		listaFunc = funcDao.selectFuncionario();								//SELECT
		for(Funcionario f: listaFunc){
			System.out.println("Nome:"+ f.getNome());
			System.out.println("Usuario:"+ f.getUsuario());
			System.out.println("Senha:"+f.getSenha());
			System.out.println(" ");
		}
		
		func.setId(2);
		funcDao.removeFuncionario(func);										//REMOVE
	}

}
