package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Medicos {

	public boolean loginMedico (String login, String senha) throws Exception
	{
		boolean retorno = false;

		try{

			String tabela_medico;

			/* DADOS TABELA MEDICO*/
			tabela_medico = "SELECT cpf, senha FROM MEDICO WHERE cpf = ? and senha = ?";

			BD.comando.prepareStatement (tabela_medico);

			BD.comando.setString    (1, login);
			BD.comando.setString (2, senha);

			MeuResultSet resultado = (MeuResultSet)BD.comando.executeQuery();

			retorno = resultado.first();
		}

		catch (SQLException erro)
		{
			throw new Exception ("Médico não cadastrado");
		}

		return retorno;
	}
	
	public MeuResultSet selectNomeMedico (String cpf) throws Exception
	{
		MeuResultSet resultado;

		try{

			String tabela_dados_pessoais_medico;

			/* DADOS TABELA MEDICO*/
			tabela_dados_pessoais_medico = "SELECT nome FROM DADOS_PESSOAIS_MEDICO WHERE MEDICO_CPF = ?";

			BD.comando.prepareStatement (tabela_dados_pessoais_medico);

			BD.comando.setString    (1, cpf);
			
			resultado = (MeuResultSet)BD.comando.executeQuery();

			resultado.next();
		}

		catch (SQLException erro)
		{
			throw new Exception ("Médico não cadastrado");
		}

		return resultado;
	}

	public void createMedico (Medico medico) throws Exception
	{
		try{

			String tabela_medico, tabela_dados_pessoais_medico, tabela_dados_residenciais_medico, tabela_dados_contato_medico;

			/* DADOS TABELA MEDICO*/
			tabela_medico = "INSERT INTO medico (cpf,crmv,senha) VALUES (?,?,?)";

			BD.comando.prepareStatement (tabela_medico);

			BD.comando.setString    (1, medico.getCpf());
			BD.comando.setString (2, medico.getCrmv());
			BD.comando.setString  (3, medico.getSenha());

			BD.comando.executeUpdate ();
			BD.comando.commit        ();

			/* DADOS TABELA DADOS_PESSOAIS*/
			tabela_dados_pessoais_medico = "INSERT INTO dados_pessoais_medico (MEDICO_CPF,NOME,SOBRENOME,NASCIMENTO,GENERO) VALUES (?,UPPER(?),UPPER(?),?,?)";

			BD.comando.prepareStatement (tabela_dados_pessoais_medico);

			BD.comando.setString  (1, medico.getCpf());
			BD.comando.setString  (2, medico.getNome());
			BD.comando.setString  (3, medico.getSobrenome());
			BD.comando.setString  (4, medico.getNascimento());
			BD.comando.setString  (5, medico.getGenero());

			BD.comando.executeUpdate ();
			BD.comando.commit        ();

			/* DADOS TABELA DADOS_RESIDENCIAIS*/
			tabela_dados_residenciais_medico = "INSERT INTO dados_residenciais_medico (CEP,MEDICO_CPF,ENDERECO,BAIRRO,NUMERO,COMPLEMENTO,CIDADE,ESTADO) VALUES (?,?,UPPER(?),UPPER(?),UPPER(?),UPPER(?),UPPER(?),?)";

			BD.comando.prepareStatement (tabela_dados_residenciais_medico);

			BD.comando.setString  (1, medico.getCep());
			BD.comando.setString  (2, medico.getCpf());
			BD.comando.setString  (3, medico.getEndereco());
			BD.comando.setString  (4, medico.getBairro());
			BD.comando.setString  (5, medico.getNumero());
			BD.comando.setString  (6, medico.getComplemento());
			BD.comando.setString  (7, medico.getCidade());
			BD.comando.setString  (8, medico.getEstado());

			BD.comando.executeUpdate ();
			BD.comando.commit        ();

			/* DADOS TABELA DADOS_CONTATO*/
			tabela_dados_contato_medico = "INSERT INTO dados_contato_medico (medico_cpf,email,fixo,celular) VALUES (?,LOWER(?),?,?)";

			BD.comando.prepareStatement (tabela_dados_contato_medico);

			BD.comando.setString    (1, medico.getCpf());
			BD.comando.setString    (2, medico.getEmail());
			BD.comando.setString (3, medico.getFixo());
			BD.comando.setString  (4, medico.getCelular());

			BD.comando.executeUpdate ();
			BD.comando.commit        ();
		}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao cadastrar medico");
		}
	}
	
	public int contadorMedicosCadastrados() throws Exception{
		
		int total = 0;
		
		try{
			String tabela_medico;

			tabela_medico = "SELECT count(*) from medico";

			BD.comando.prepareStatement (tabela_medico);
			
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
	
	public MeuResultSet getTabelaVeterinario () throws Exception
	{
		MeuResultSet resultado = null;
		
		try
		{
			String tabela_dados_pessoais_medico;

				tabela_dados_pessoais_medico = "SELECT dp.NOME,dp.SOBRENOME,med.CPF,med.CRMV,med.CPF,dp.ID_DADOS_PESSOAIS FROM dados_pessoais_medico dp, medico med where med.CPF = dp.MEDICO_CPF";

				BD.comando.prepareStatement (tabela_dados_pessoais_medico);

				resultado = (MeuResultSet)BD.comando.executeQuery (); 
		}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao recuperar as tabelas para o filtro de veterinários");
		}

		return resultado;
	}
	
	public MeuResultSet selectTodosDadosMedicos (String cpf)  throws Exception
	{
		MeuResultSet resultado = null;
		
		try
		{
			String tabela_dados;

				tabela_dados = "select dpm.NOME,dpm.SOBRENOME,dpm.NASCIMENTO,dpm.GENERO, med.CPF,med.CRMV, drm.CEP,drm.ENDERECO,drm.BAIRRO,drm.NUMERO,drm.COMPLEMENTO,drm.CIDADE,drm.ESTADO, " +
				"dcm.EMAIL,dcm.FIXO,dcm.CELULAR from dados_pessoais_medico dpm, medico med, dados_residenciais_medico drm, dados_contato_medico dcm " + 
				"where dpm.MEDICO_CPF = ? and med.CPF = ? and drm.MEDICO_CPF = ? and dcm.MEDICO_CPF = ?";

				BD.comando.prepareStatement (tabela_dados);
	
				BD.comando.setString  (1, cpf);
				BD.comando.setString  (2, cpf);
				BD.comando.setString  (3, cpf);
				BD.comando.setString  (4, cpf);
				
				resultado = (MeuResultSet)BD.comando.executeQuery (); 
		}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao recuperar as tabelas para o filtro de veterinários");
		}

		return resultado;
	}
			
	public void deleteMedico (String cpf) throws Exception
	{
		try
		{
			String sql;

			sql = "DELETE FROM medico " +
					"WHERE CPF = ?";

			BD.comando.prepareStatement (sql);

			BD.comando.setString (1, cpf);

			BD.comando.executeUpdate ();
			BD.comando.commit        ();        
			}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao excluir livro");
		}
	}
	
	public void updateCRMV (String cpf, String crmv) throws Exception
	{
		try
		{
			String tabela_medico;

			tabela_medico = "UPDATE MEDICO SET CRMV = ? WHERE CPF = ?";

			BD.comando.prepareStatement (tabela_medico);

			BD.comando.setString (1, crmv);
			BD.comando.setString (2, cpf);

			BD.comando.executeUpdate ();
			BD.comando.commit        ();        
			}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao excluir livro");
		}
	}
	
	public void updateDadosPessoaisMedico (String cpf, String nome, String sobrenome, String nascimento, String genero) throws Exception
	{
		try
		{
			String tabela_medico;

			tabela_medico = "UPDATE DADOS_PESSOAIS_MEDICO SET NOME = UPPER(?), SOBRENOME = UPPER(?), NASCIMENTO = ?, GENERO = ? WHERE MEDICO_CPF = ?";

			BD.comando.prepareStatement (tabela_medico);

			BD.comando.setString (1, nome);
			BD.comando.setString (2, sobrenome);
			BD.comando.setString (3, nascimento);
			BD.comando.setString (4, genero);
			BD.comando.setString (5, cpf);

			BD.comando.executeUpdate ();
			BD.comando.commit        ();        
			}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao excluir livro");
		}
	}
	
	public void updateDadosResidenciaisMedico (String cep, String endereco, String bairro, String numero, String complemento, String cidade, String estado, String cpf) throws Exception
	{
		try
		{
			String tabela_dados_residenciais_medico;

			tabela_dados_residenciais_medico = "UPDATE DADOS_RESIDENCIAIS_MEDICO SET CEP = (?), ENDERECO = UPPER(?), BAIRRO = UPPER(?), " +
			"NUMERO = UPPER(?), COMPLEMENTO = UPPER(?), CIDADE = UPPER(?), ESTADO = UPPER(?) WHERE MEDICO_CPF = ?";

			BD.comando.prepareStatement (tabela_dados_residenciais_medico);

			BD.comando.setString (1, cep);
			BD.comando.setString (2, endereco);
			BD.comando.setString (3, bairro);
			BD.comando.setString (4, numero);
			BD.comando.setString (5, complemento);
			BD.comando.setString (6, cidade);
			BD.comando.setString (7, estado);
			BD.comando.setString (8, cpf);
			
			BD.comando.executeUpdate ();
			BD.comando.commit        ();        
			}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao excluir livro");
		}
	}

	public void updateDadosContatoMedico (String email, String fixo, String celular, String cpf) throws Exception
	{
		try
		{
			String tabela_dados_contato_medico;

			tabela_dados_contato_medico = "UPDATE DADOS_CONTATO_MEDICO SET EMAIL = LOWER(?), FIXO = ?, CELULAR = ? WHERE MEDICO_CPF = ?";

			BD.comando.prepareStatement (tabela_dados_contato_medico);

			BD.comando.setString (1, email);
			BD.comando.setString (2, fixo);
			BD.comando.setString (3, celular);
			BD.comando.setString (4, cpf);
			
			BD.comando.executeUpdate ();
			BD.comando.commit        ();        
			}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao excluir livro");
		}
	}
	
	public boolean selectTodosMedicosCadastrados (String cpf) throws Exception
	{
		boolean retorno = false;
		
		try
		{
			String tabela_medico;

			tabela_medico = "SELECT CPF FROM MEDICO WHERE CPF = ?";

			BD.comando.prepareStatement (tabela_medico);

			BD.comando.setString (1, cpf);
			
			MeuResultSet resultado = (MeuResultSet)BD.comando.executeQuery();
			
			retorno = resultado.first();		        
			}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao excluir livro");
		}
		
		return retorno;
	}
}
