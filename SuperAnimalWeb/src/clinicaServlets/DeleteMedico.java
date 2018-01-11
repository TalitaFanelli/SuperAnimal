package clinicaServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bd.BD;

/**
 * Servlet implementation class DeleteMedico
 */
@WebServlet("/DeleteMedico")
public class DeleteMedico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMedico() {
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
		
		String cpf = request.getParameter("cadastro"); //pegar parâmetro da URL

		try{
		BD.medicos.deleteMedico(cpf);
		
		request.getSession().setAttribute("mensagem", "sucesso");

		response.sendRedirect(request.getContextPath() + "/jsp/usuarios.jsp?resultado=sucesso");
		}
		
		catch(Exception e){
			e.printStackTrace();

			request.getSession().setAttribute("mensagem", "erro");

			response.sendRedirect(request.getContextPath() + "/jsp/usuarios.jsp?resultado=erro");
		}
	}
}
