package Teste;
import java.util.Calendar;

import DAO.ContatoDao;
import Model.Contato;

public class TestaInsere {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Contato contato = new Contato();
		 contato.setNome("Caelum");
		 contato.setEmail("contato@caelum.com.br");
		 contato.setEndereco("R. Vergueiro 3185 cj57");
		 contato.setDataNascimento(Calendar.getInstance());
		 
		 // grave nessa conex�o!!!
		 ContatoDao dao = new ContatoDao();
		 
		 // m�todo elegante
		 dao.adiciona(contato);
		 
		 System.out.println("Gravado!");
	}

}
