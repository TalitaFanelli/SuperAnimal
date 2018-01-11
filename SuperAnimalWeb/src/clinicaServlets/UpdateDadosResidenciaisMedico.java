package clinicaServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bd.BD;

/**
 * Servlet implementation class UpdateDadosResidenciaisMedico
 */
@WebServlet("/UpdateDadosResidenciaisMedico")
public class UpdateDadosResidenciaisMedico extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateDadosResidenciaisMedico() {
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

		String cep = request.getParameter("clinica_cep");
		String endereco = request.getParameter("clinica_endereco");
		String bairro = request.getParameter("clinica_bairro");
		String numero = request.getParameter("clinica_numero");
		String complemento = request.getParameter("clinica_complemento");
		String cidade = request.getParameter("clinica_cidade");
		String estado = request.getParameter("clinica_estado");

		try{							
			BD.medicos.updateDadosResidenciaisMedico(cep, endereco, bairro, numero, complemento, cidade, estado, cpf);

			request.getSession().setAttribute("mensagem", "sucesso");

			request.getSession().setAttribute("cpf", cpf);

			response.sendRedirect(request.getContextPath() + "/jsp/clinica/consultar.jsp?resultado=sucesso");
		}

		catch(Exception e){
			e.printStackTrace();

			request.getSession().setAttribute("mensagem", "erro");

			response.sendRedirect(request.getContextPath() + "/jsp/clinica/consultar.jsp?resultado=erro");
		}
	}
}
