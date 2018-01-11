package animalServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bd.BD;
/**
 * Servlet implementation class UpdateDadosAnimal
 */
@WebServlet("/UpdateDadosAnimal")
public class UpdateDadosAnimal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateDadosAnimal() {
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

		String id_animal = request.getParameter("id_animal");

		String nome = request.getParameter("animal_nome");
		String sobrenome = request.getParameter("animal_sobrenome");
		String sexo = request.getParameter("animal_sexo");
		String nascimento = request.getParameter("animal_nascimento");

		String especie = request.getParameter("animal_especie");
		String raca = request.getParameter("animal_raca");
		String pelagem = request.getParameter("animal_pelagem");
		String cpf = request.getParameter("animal_dono");

		try{		

			int medico = BD.animais.selectCPFMedico(cpf);

			int cliente = BD.animais.selectCPFCliente(cpf);

			if(medico >= 1 || cliente >= 1){
				BD.animais.UpdateDadosAnimal(nome, sobrenome, nascimento, sexo, especie, raca, pelagem, cpf, id_animal);

				request.getSession().setAttribute("mensagem", "sucesso");

				response.sendRedirect(request.getContextPath() + "/jsp/animal/consultar.jsp?resultado=sucesso");
			}
			else{
				request.getSession().setAttribute("mensagem", "aviso");
				
				request.getSession().setAttribute("cpf_digitado", cpf);
				
				response.sendRedirect(request.getContextPath() + "/jsp/animal/consultar.jsp?resultado=aviso");
			}
		}

		catch(Exception e){
			e.printStackTrace();

			request.getSession().setAttribute("mensagem", "erro");

			response.sendRedirect(request.getContextPath() + "/jsp/animal/consultar.jsp?resultado=erro");
		}
	}
}
