package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Animais {

	public void createAnimal (Animal animal) throws Exception {

		try{

			String tabela_animal;

			/* DADOS TABELA ANIMAL */
			tabela_animal = "INSERT INTO animal (NOME,SOBRENOME,NASCIMENTO,SEXO,ESPECIE,RACA,PELAGEM,CPF_CLI_MED) VALUES (UPPER(?),UPPER(?),?,?,UPPER(?),UPPER(?),UPPER(?),?)";

			BD.comando.prepareStatement (tabela_animal);

			BD.comando.setString  (1, animal.getNome());
			BD.comando.setString  (2, animal.getSobrenome());
			BD.comando.setString  (3, animal.getNascimento());
			BD.comando.setString  (4, animal.getSexo());
			BD.comando.setString  (5, animal.getEspecie());
			BD.comando.setString  (6, animal.getRaca());
			BD.comando.setString  (7, animal.getPelagem());
			BD.comando.setString  (8, animal.getCliente_cpf());

			BD.comando.executeUpdate ();
			BD.comando.commit        ();
		}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao cadastrar animal");
		}
	}

	
	public int contadorAnimaisCadastrados() throws Exception{

		int total = 0;

		try{
			String tabela_animal;

			tabela_animal = "SELECT count(*) from animal";

			BD.comando.prepareStatement (tabela_animal);

			MeuResultSet query = (MeuResultSet)BD.comando.executeQuery();

			query.next();

			total = query.getInt("count(*)");
		}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao recuperar as tabelas para o filtro de veterinários");
		}

		return total;
	}

	public MeuResultSet getTabelaAnimais() throws Exception
	{
		MeuResultSet resultado = null;

		try
		{
			String tabela_animal;

			tabela_animal = "SELECT NOME, SEXO, ESPECIE, CPF_CLI_MED, ID_ANIMAL FROM animal";

			BD.comando.prepareStatement (tabela_animal);

			resultado = (MeuResultSet)BD.comando.executeQuery (); 
		}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao recuperar as tabelas para o filtro de veterinários");
		}

		return resultado;
	}

	public boolean selectTodosAnimaisCadastrados (String cpf) throws Exception
	{
		boolean retorno = false;

		try
		{
			String tabela_animal;

			tabela_animal = "SELECT NOME FROM ANIMAL WHERE CPF_CLI_MED = ?";

			BD.comando.prepareStatement (tabela_animal);

			BD.comando.setString (1, cpf);

			MeuResultSet resultado = (MeuResultSet)BD.comando.executeQuery();

			retorno = resultado.first();		        
		}
		catch (SQLException erro) {
			throw new Exception ("Erro ao excluir livro");
		}

		return retorno;
	}

	public MeuResultSet selectTodosDadosAnimais (String id_animal)  throws Exception
	{
		MeuResultSet resultado = null;

		try
		{
			String tabela_dados;

			tabela_dados = "select NOME,SOBRENOME,NASCIMENTO,SEXO,ESPECIE,RACA,PELAGEM,CPF_CLI_MED FROM ANIMAL where ID_ANIMAL = ?";

			BD.comando.prepareStatement (tabela_dados);

			BD.comando.setString  (1, id_animal);

			resultado = (MeuResultSet)BD.comando.executeQuery (); 
		}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao recuperar as tabelas para o filtro de veterinários");
		}

		return resultado;
	}

	public void UpdateDadosAnimal (String nome, String sobrenome, String nascimento, String sexo, String especie, String raca, String pelagem, String cpf, String id_animal) throws Exception {

		try{

			String tabela_animal;

			/* DADOS TABELA ANIMAL */
			tabela_animal = "UPDATE animal set NOME = UPPER(?),SOBRENOME = UPPER(?),NASCIMENTO = ?,SEXO = ?,ESPECIE = UPPER(?),RACA = UPPER(?),PELAGEM = UPPER(?), CPF_CLI_MED = ? WHERE ID_ANIMAL = ?";

			BD.comando.prepareStatement (tabela_animal);

			BD.comando.setString  (1, nome);
			BD.comando.setString  (2, sobrenome);
			BD.comando.setString  (3, nascimento);
			BD.comando.setString  (4, sexo);
			BD.comando.setString  (5, especie);
			BD.comando.setString  (6, raca);
			BD.comando.setString  (7, pelagem);
			BD.comando.setString  (8, cpf);
			BD.comando.setString  (9, id_animal);

			BD.comando.executeUpdate ();
			BD.comando.commit        ();
		}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao cadastrar medico");
		}
	}

	public void deleteAnimal (String id_animal) throws Exception
	{
		try
		{
			String sql;

			sql = "DELETE FROM animal " +
					"WHERE id_animal = ?";

			BD.comando.prepareStatement (sql);

			BD.comando.setString (1, id_animal);

			BD.comando.executeUpdate ();
			BD.comando.commit        ();        
		}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao excluir livro");
		}
	}

	public int selectCPFMedico (String cpf) throws Exception{

		int total = 0;

		try{
			String tabela_medico;

			tabela_medico = "SELECT count(*) FROM DADOS_PESSOAIS_MEDICO WHERE MEDICO_CPF = ?";

			BD.comando.prepareStatement (tabela_medico);

			BD.comando.setString (1, cpf);
			
			MeuResultSet query = (MeuResultSet)BD.comando.executeQuery();

			query.next();

			total = query.getInt("count(*)");

		}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao excluir livro");
		}

		return total;
	}

	public int selectCPFCliente (String cpf) throws Exception{

		int total = 0;

		try{
			String tabela_cliente;

			tabela_cliente = "SELECT count(*) FROM DADOS_PESSOAIS_CLIENTE WHERE CLIENTE_CPF = ?";

			BD.comando.prepareStatement (tabela_cliente);
			
			BD.comando.setString (1, cpf);

			MeuResultSet query = (MeuResultSet)BD.comando.executeQuery();

			query.next();

			total = query.getInt("count(*)");
		}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao excluir livro");
		}

		return total;
	}
}
