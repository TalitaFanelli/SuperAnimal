package clinicaServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bd.BD;
/**
 * Servlet implementation class UpdateDadosPessoaisMedico
 */
@WebServlet("/UpdateDadosPessoaisMedico")
public class UpdateDadosPessoaisMedico extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateDadosPessoaisMedico() {
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

		String nome = request.getParameter("clinica_nome");
		String sobrenome = request.getParameter("clinica_sobrenome");
		String nascimento = request.getParameter("clinica_nascimento");
		String genero = request.getParameter("clinica_genero");
		String crmv = request.getParameter("clinica_crmv");

		try{		
			BD.medicos.updateCRMV(cpf, crmv);

			BD.medicos.updateDadosPessoaisMedico(cpf, nome, sobrenome, nascimento, genero);

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
