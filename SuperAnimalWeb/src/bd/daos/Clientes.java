package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Clientes {

	public void createCliente (Cliente cliente) throws Exception
	{
		try{

			String tabela_cliente, tabela_dados_pessoais_cliente, tabela_dados_residenciais_cliente, tabela_dados_contato_cliente;

			/* DADOS TABELA MEDICO*/
			tabela_cliente = "INSERT INTO cliente (cpf,senha) VALUES (?,?)";

			BD.comando.prepareStatement (tabela_cliente);

			BD.comando.setString    (1, cliente.getCpf());
			BD.comando.setString  (2, cliente.getSenha());

			BD.comando.executeUpdate ();
			BD.comando.commit        ();

			/* DADOS TABELA DADOS_PESSOAIS*/
			tabela_dados_pessoais_cliente = "INSERT INTO dados_pessoais_cliente (CLIENTE_CPF,NOME,SOBRENOME,NASCIMENTO,GENERO) VALUES (?,UPPER(?),UPPER(?),?,?)";

			BD.comando.prepareStatement (tabela_dados_pessoais_cliente);

			BD.comando.setString  (1, cliente.getCpf());
			BD.comando.setString  (2, cliente.getNome());
			BD.comando.setString  (3, cliente.getSobrenome());
			BD.comando.setString  (4, cliente.getNascimento());
			BD.comando.setString  (5, cliente.getGenero());

			BD.comando.executeUpdate ();
			BD.comando.commit        ();

			/* DADOS TABELA DADOS_RESIDENCIAIS*/
			tabela_dados_residenciais_cliente = "INSERT INTO dados_residenciais_cliente (CEP,CLIENTE_CPF,ENDERECO,BAIRRO,NUMERO,COMPLEMENTO,CIDADE,ESTADO) VALUES (?,?,UPPER(?),UPPER(?),UPPER(?),UPPER(?),UPPER(?),?)";

			BD.comando.prepareStatement (tabela_dados_residenciais_cliente);

			BD.comando.setString  (1, cliente.getCep());
			BD.comando.setString  (2, cliente.getCpf());
			BD.comando.setString  (3, cliente.getEndereco());
			BD.comando.setString  (4, cliente.getBairro());
			BD.comando.setString  (5, cliente.getNumero());
			BD.comando.setString  (6, cliente.getComplemento());
			BD.comando.setString  (7, cliente.getCidade());
			BD.comando.setString  (8, cliente.getEstado());

			BD.comando.executeUpdate ();
			BD.comando.commit        ();

			/* DADOS TABELA DADOS_CONTATO*/
			tabela_dados_contato_cliente = "INSERT INTO dados_contato_cliente (cliente_cpf,email,fixo,celular) VALUES (?,LOWER(?),?,?)";

			BD.comando.prepareStatement (tabela_dados_contato_cliente);

			BD.comando.setString    (1, cliente.getCpf());
			BD.comando.setString    (2, cliente.getEmail());
			BD.comando.setString (3, cliente.getFixo());
			BD.comando.setString  (4, cliente.getCelular());

			BD.comando.executeUpdate ();
			BD.comando.commit        ();
		}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao cadastrar medico");
		}
	}

	public int contadorClientesCadastrados() throws Exception{

		int total = 0;

		try{
			String tabela_cliente;

			tabela_cliente = "SELECT count(*) from cliente";

			BD.comando.prepareStatement (tabela_cliente);

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
	
	public int contadorAnimaisCadastrados(String cpf) throws Exception{

		int total = 0;

		try{
			String tabela_cliente;

			tabela_cliente = "SELECT count(*) from animal where CPF_CLI_MED = ?";

			BD.comando.prepareStatement (tabela_cliente);

			BD.comando.setString    (1, cpf);
			
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
	
	public MeuResultSet getTabelaClientes() throws Exception
	{
		MeuResultSet resultado = null;

		try
		{
			String tabela_dados_pessoais_cliente_animal;

			tabela_dados_pessoais_cliente_animal = "SELECT NOME, SOBRENOME, CLIENTE_CPF FROM dados_pessoais_cliente";

			BD.comando.prepareStatement (tabela_dados_pessoais_cliente_animal);

			resultado = (MeuResultSet)BD.comando.executeQuery (); 
		}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao recuperar as tabelas para o filtro de veterinários");
		}

		return resultado;
	}
	
	public MeuResultSet selectNomeAnimaisCliente(String cpf) throws Exception
	{
		MeuResultSet resultado = null;

		try
		{
			String tabela_animal;

			tabela_animal = "SELECT NOME FROM animal where CPF_CLI_MED = ? order by nome";

			BD.comando.prepareStatement (tabela_animal);
			
			BD.comando.setString    (1, cpf);

			resultado = (MeuResultSet)BD.comando.executeQuery (); 
		}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao recuperar as tabelas para o filtro de veterinários");
		}

		return resultado;
	}
	
	public MeuResultSet selectTodosDadosClientes (String cpf)  throws Exception
	{
		MeuResultSet resultado = null;

		try
		{
			String tabela_dados;

			tabela_dados = "select dpm.NOME,dpm.SOBRENOME,dpm.NASCIMENTO,dpm.GENERO,cli.CPF,drm.CEP,drm.ENDERECO,drm.BAIRRO,drm.NUMERO,drm.COMPLEMENTO,drm.CIDADE,drm.ESTADO, " +
					"dcm.EMAIL,dcm.FIXO,dcm.CELULAR from dados_pessoais_cliente dpm, cliente cli, dados_residenciais_cliente drm, dados_contato_cliente dcm " + 
					"where dpm.CLIENTE_CPF = ? and cli.CPF = ? and drm.CLIENTE_CPF = ? and dcm.CLIENTE_CPF = ?";

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

	public void deleteCliente (String cpf) throws Exception
	{
		try
		{
			String sql;

			sql = "DELETE FROM cliente " +
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

	public void updateDadosPessoaisCliente (String cpf, String nome, String sobrenome, String nascimento, String genero) throws Exception
	{
		try
		{
			String tabela_cliente;

			tabela_cliente = "UPDATE DADOS_PESSOAIS_CLIENTE SET NOME = UPPER(?), SOBRENOME = UPPER(?), NASCIMENTO = ?, GENERO = ? WHERE CLIENTE_CPF = ?";

			BD.comando.prepareStatement (tabela_cliente);

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

	public void updateDadosResidenciaisCliente (String cep, String endereco, String bairro, String numero, String complemento, String cidade, String estado, String cpf) throws Exception
	{
		try
		{
			String tabela_dados_residenciais_cliente;

			tabela_dados_residenciais_cliente = "UPDATE DADOS_RESIDENCIAIS_CLIENTE SET CEP = (?), ENDERECO = UPPER(?), BAIRRO = UPPER(?), " +
					"NUMERO = UPPER(?), COMPLEMENTO = UPPER(?), CIDADE = UPPER(?), ESTADO = UPPER(?) WHERE CLIENTE_CPF = ?";

			BD.comando.prepareStatement (tabela_dados_residenciais_cliente);

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

	public void updateDadosContatoCliente (String email, String fixo, String celular, String cpf) throws Exception
	{
		try
		{
			String tabela_dados_contato_medico;

			tabela_dados_contato_medico = "UPDATE DADOS_CONTATO_CLIENTE SET EMAIL = LOWER(?), FIXO = ?, CELULAR = ? WHERE CLIENTE_CPF = ?";

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

	public boolean selectTodosClientesCadastrados (String cpf) throws Exception
	{
		boolean retorno = false;

		try
		{
			String tabela_medico;

			tabela_medico = "SELECT CPF FROM CLIENTE WHERE CPF = ?";

			BD.comando.prepareStatement (tabela_medico);

			BD.comando.setString (1, cpf);

			MeuResultSet resultado = (MeuResultSet)BD.comando.executeQuery();

			retorno = resultado.first();		        
		}
		catch (SQLException erro) {
			throw new Exception ("Erro ao excluir livro");
		}

		return retorno;
	}
	
	public boolean loginCliente (String login, String senha) throws Exception
	{
		boolean retorno = false;

		try{

			String tabela_cliente;

			/* DADOS TABELA MEDICO*/
			tabela_cliente = "SELECT cpf, senha FROM CLIENTE WHERE cpf = ? and senha = ?";

			BD.comando.prepareStatement (tabela_cliente);

			BD.comando.setString    (1, login);
			BD.comando.setString (2, senha);

			MeuResultSet resultado = (MeuResultSet)BD.comando.executeQuery();

			retorno = resultado.first();
		}

		catch (SQLException erro)
		{
			throw new Exception ("Cliente não cadastrado");
		}

		return retorno;
	}
}
