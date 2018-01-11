package clinicaServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bd.BD;
import bd.dbos.Medico;

/**
 * Servlet implementation class CreateMedico
 */
@WebServlet("/CreateMedico")// This is the URL of the servlet.
public class CreateMedico extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateMedico() {
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
		
		String cpf = request.getParameter("clinica_cpf");
		String crmv = request.getParameter("clinica_crmv");
		String senha = request.getParameter("clinica_senha");

		String nome = request.getParameter("clinica_nome");
		String sobrenome = request.getParameter("clinica_sobrenome");
		String nascimento = request.getParameter("clinica_nascimento");
		String genero = request.getParameter("clinica_genero");

		String cep = request.getParameter("clinica_cep");
		String endereco = request.getParameter("clinica_endereco");
		String bairro = request.getParameter("clinica_bairro");
		String numero = request.getParameter("clinica_numero");
		String complemento = request.getParameter("clinica_complemento");
		String cidade = request.getParameter("clinica_cidade");
		String estado = request.getParameter("clinica_estado");

		String email = request.getParameter("clinica_email");
		String fixo = request.getParameter("clinica_fixo");
		String celular = request.getParameter("clinica_cel");
		
		if(complemento.trim() == ""){
			complemento = "N/A";
		}
		
		if(fixo.trim() == ""){
			fixo = "(00)0000-0000";
		}
				
		try{		
			
			boolean retorno = BD.medicos.selectTodosMedicosCadastrados(cpf);
			
			if(retorno == true){
				
				request.getSession().setAttribute("cpf_digitado", cpf);
				request.getSession().setAttribute("mensagem", "aviso");
				
				response.sendRedirect(request.getContextPath() + "/jsp/clinica/cadastrar.jsp?resultado=aviso");
			}
			
			else{
			
			Medico medico = new Medico(cpf, crmv, senha, nome, sobrenome, nascimento, genero,
					cep, endereco, bairro, numero, complemento, cidade, estado, email,
					fixo, celular);
			
			BD.medicos.createMedico(medico);
			
			request.getSession().setAttribute("mensagem", "sucesso");
			
			response.sendRedirect(request.getContextPath() + "/jsp/clinica/cadastrar.jsp?resultado=sucesso");
			}
		}
		catch(Exception e){
			e.printStackTrace();
			
			request.getSession().setAttribute("mensagem", "erro");
			
			response.sendRedirect(request.getContextPath() + "/jsp/clinica/cadastrar.jsp?resultado=erro");
		}
	}
}
