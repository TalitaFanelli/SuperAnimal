package clinicaServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bd.BD;
import bd.core.MeuResultSet;

/**
 * Servlet implementation class LoginMedico
 */
@WebServlet("/LoginMedico")// This is the URL of the servlet.
public class LoginMedico extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginMedico() {
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
		
		String login = request.getParameter("login");//igualzinho ao id e name do html
		String senha = request.getParameter("senha");//igualzinho ao id e name do html

		try{
			boolean retorno = BD.medicos.loginMedico(login, senha);
			
			if(retorno == true){
				
				HttpSession session = request.getSession(true); // reuse existing
				
				MeuResultSet resultado = BD.medicos.selectNomeMedico(login);
				
				session.setAttribute("cpf", login);
				
				session.setAttribute("nomeUsuario", resultado.getString("NOME"));
				session.setMaxInactiveInterval(-1); //nunca expirar
				
				response.sendRedirect(request.getContextPath() + "/jsp/home.jsp");
			}

			else{		
				request.getSession().setAttribute("mensagem", "aviso");

				response.sendRedirect(request.getContextPath() + "/jsp/login.jsp?resultado=aviso");
			}
		}

		catch(Exception e){
			e.printStackTrace();

			request.getSession().setAttribute("mensagem", "erro");

			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp?resultado=erro");
		}
	}
}
