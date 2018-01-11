package mobile;

import javax.ws.rs.core.MediaType;
import bd.BD;
import bd.core.MeuResultSet;
import bd.dbos.Agendamento;
import java.util.*;
import javax.ws.rs.*;

//@Path � obrigat�rio
@Path("/AgendamentoDeleteApp")
public class AgendamentoDeleteApp {

	private boolean resultado;
	private MeuResultSet retorno;

	@GET//@GET � obrigat�rio
	@Path("/{parmID_Agendamento}")//@Path � obrigat�rio
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteAgendamento(@PathParam("parmID_Agendamento") String parmID_Agendamento) {
		
		ArrayList<Agendamento> agendamento = new ArrayList<>();
		
		try {
			System.out.println("ID_Agendamento = " + parmID_Agendamento);

			boolean resultado = BD.agendamentos.deleteAgendamento(parmID_Agendamento);
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return String.valueOf(resultado);
	}
}