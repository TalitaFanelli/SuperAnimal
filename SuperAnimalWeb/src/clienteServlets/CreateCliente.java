package clienteServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bd.BD;
import bd.dbos.Cliente;

/**
 * Servlet implementation class CreateCliente
 */
@WebServlet("/CreateCliente")// This is the URL of the servlet.
public class CreateCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		String cpf = request.getParameter("cliente_cpf");
		String crmv = request.getParameter("cliente_crmv");
		String senha = request.getParameter("cliente_senha");

		String nome = request.getParameter("cliente_nome");
		String sobrenome = request.getParameter("cliente_sobrenome");
		String nascimento = request.getParameter("cliente_nascimento");
		String genero = request.getParameter("cliente_genero");

		String cep = request.getParameter("cliente_cep");
		String endereco = request.getParameter("cliente_endereco");
		String bairro = request.getParameter("cliente_bairro");
		String numero = request.getParameter("cliente_numero");
		String complemento = request.getParameter("cliente_complemento");
		String cidade = request.getParameter("cliente_cidade");
		String estado = request.getParameter("cliente_estado");

		String email = request.getParameter("cliente_email");
		String fixo = request.getParameter("cliente_fixo");
		String celular = request.getParameter("cliente_cel");
		
		if(complemento.trim() == ""){
			complemento = "N/A";
		}
		
		if(fixo.trim() == ""){
			fixo = "(00)0000-0000";
		}
				
		try{		
			
			boolean retorno = BD.clientes.selectTodosClientesCadastrados(cpf);
			
			if(retorno == true){
				
				request.getSession().setAttribute("cpf_digitado", cpf);
				request.getSession().setAttribute("mensagem", "aviso");
				
				response.sendRedirect(request.getContextPath() + "/jsp/cliente/cadastrar.jsp?resultado=aviso");
			}
			
			else{
			
			Cliente cliente = new Cliente(cpf, senha, nome, sobrenome, nascimento, genero,
					cep, endereco, bairro, numero, complemento, cidade, estado, email,
					fixo, celular);
			
			BD.clientes.createCliente(cliente);
			
			request.getSession().setAttribute("mensagem", "sucesso");
			
			response.sendRedirect(request.getContextPath() + "/jsp/cliente/cadastrar.jsp?resultado=sucesso");
			}
		}
		catch(Exception e){
			e.printStackTrace();
			
			request.getSession().setAttribute("mensagem", "erro");
			
			response.sendRedirect(request.getContextPath() + "/jsp/cliente/cadastrar.jsp?resultado=erro");
		}
	}
}
