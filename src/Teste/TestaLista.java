package Teste;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import DAO.ContatoDao;
import Model.Contato;

public class TestaLista {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ContatoDao dao = new ContatoDao();
		Contato testaContato = new Contato();		
		List<Contato> contatos = dao.getLista();		
		
		for (Contato contato : contatos) {
			String dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(contato.getDataNascimento().getTime());
			  System.out.println("Nome: " + contato.getNome());
			  System.out.println("Email: " + contato.getEmail());
			  System.out.println("Endereço: " + contato.getEndereco());
			  System.out.println("Data de Nascimento: " + 
					  dataFormatada + "\n");
		}
		testaContato = dao.pesquisar(2);
		System.out.println(testaContato.getNome() + ", "+testaContato.getEndereco());
		
		long id = 1;
		testaContato.setNome("Ilegra");
		testaContato.setEmail("leonardo.vellinho@ilegra.com");
		testaContato.setEndereco("Av. W. Luis");
		testaContato.setId(id);
		
		dao.altera(testaContato);
		
		testaContato = dao.pesquisar(1);
		System.out.println(testaContato.getNome() + ", "+testaContato.getEndereco());
		id = 2;
		testaContato.setId(id);
		dao.remove(testaContato);		

	}

}
