package clienteServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bd.BD;

/**
 * Servlet implementation class UpdateDadosResidenciaisCliente
 */
@WebServlet("/UpdateDadosResidenciaisCliente")
public class UpdateDadosResidenciaisCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateDadosResidenciaisCliente() {
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

		String cpf = request.getParameter("cpf"); //pegar parâmetro da URL

		String cep = request.getParameter("cliente_cep");
		String endereco = request.getParameter("cliente_endereco");
		String bairro = request.getParameter("cliente_bairro");
		String numero = request.getParameter("cliente_numero");
		String complemento = request.getParameter("cliente_complemento");
		String cidade = request.getParameter("cliente_cidade");
		String estado = request.getParameter("cliente_estado");

		try{							
			BD.clientes.updateDadosResidenciaisCliente(cep, endereco, bairro, numero, complemento, cidade, estado, cpf);
			
			request.getSession().setAttribute("mensagem", "sucesso");

			request.getSession().setAttribute("cpf", cpf);

			response.sendRedirect(request.getContextPath() + "/jsp/cliente/consultar.jsp?resultado=sucesso");
		}

		catch(Exception e){
			e.printStackTrace();

			request.getSession().setAttribute("mensagem", "erro");

			response.sendRedirect(request.getContextPath() + "/jsp/cliente/consultar.jsp?resultado=erro");
		}
	}
}
