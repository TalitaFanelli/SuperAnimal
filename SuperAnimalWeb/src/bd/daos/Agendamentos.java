package bd.daos;

import java.sql.SQLException;

import bd.BD;
import bd.core.MeuResultSet;
import bd.dbos.Agendamento;

public class Agendamentos {

	public boolean createAgedamento (String cpf, String data, String horario, String animal, String total, String banho, String tosa, String hidratacao, String unhas, String dentes, String ouvidos) throws Exception {

		boolean resultado = false;
		
		try{

			String tabela_agendamento;

			/* DADOS TABELA AGENDAMENTO */
			tabela_agendamento = "INSERT INTO agendamento (CLIENTE_CPF, DATA_AGENDADA, HORARIO, ANIMAL, TOTAL, BANHO, TOSA, HIDRATACAO, UNHAS, DENTES, OUVIDOS) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

			BD.comando.prepareStatement (tabela_agendamento);

			BD.comando.setString  (1, cpf);
			BD.comando.setString  (2, data);
			BD.comando.setString  (3, horario);
			BD.comando.setString  (4, animal);
			BD.comando.setString  (5, total);
			BD.comando.setString  (6, banho);
			BD.comando.setString  (7, tosa);
			BD.comando.setString  (8, hidratacao);
			BD.comando.setString  (9, unhas);
			BD.comando.setString  (10, dentes);
			BD.comando.setString  (11, ouvidos);

			BD.comando.executeUpdate ();
			BD.comando.commit        ();
			
			resultado = true;
		}
		catch (SQLException erro)
		{
			throw new Exception ("Erro criar agendamento");
		}
		
		return resultado;
	}
	
	public MeuResultSet selectAgendamentos (String cpf) throws Exception {
		
		MeuResultSet resultado;
		
		try{

			String tabela_agendamento;

			/* DADOS TABELA AGENDAMENTO */
			tabela_agendamento = "select * from agendamento where cliente_cpf = ?";

			BD.comando.prepareStatement (tabela_agendamento);

			BD.comando.setString    (1, cpf);
			
			resultado = (MeuResultSet)BD.comando.executeQuery();			
		}
		catch (SQLException erro)
		{
			throw new Exception ("Erro buscar agendamento");
		}
		
		return resultado;
	}
	
	public boolean deleteAgendamento(String id) throws Exception
	{
		boolean resultado = false;
		
		try
		{
			String sql;

			sql = "DELETE FROM agendamento " +
					"WHERE ID_AGENDAMENTO = ?";

			BD.comando.prepareStatement (sql);

			BD.comando.setInt(1, Integer.parseInt(id));

			BD.comando.executeUpdate ();
			BD.comando.commit        ();  
			
			resultado = true;
		}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao excluir livro");
		}
		
		return resultado;
	}
}
