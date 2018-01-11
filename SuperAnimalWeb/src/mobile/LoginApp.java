package mobile;

import javax.ws.rs.core.MediaType;
import bd.BD;
import bd.core.MeuResultSet;
import java.util.*;
import javax.ws.rs.*;

//@Path é obrigatório
@Path("/LoginApp")
public class LoginApp {

	private boolean resultado;

	@GET//@GET é obrigatório
	@Path("/{parmLogin}/{parmSenha}")//@Path é obrigatório
	@Produces(MediaType.APPLICATION_JSON)
	public String getLogin(@PathParam("parmLogin") String parmLogin, @PathParam("parmSenha") String parmSenha) {
		
		try {
			System.out.println("Login = " + parmLogin);
			System.out.println("Senha = " + parmSenha);
			
			resultado = BD.clientes.loginCliente(parmLogin, parmSenha);
			
			return String.valueOf(resultado);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return String.valueOf(resultado);
	}
}

