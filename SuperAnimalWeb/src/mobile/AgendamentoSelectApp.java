package mobile;

import javax.ws.rs.core.MediaType;
import bd.BD;
import bd.core.MeuResultSet;
import bd.dbos.Agendamento;
import java.util.*;
import javax.ws.rs.*;

//@Path é obrigatório
@Path("/AgendamentoSelectApp")
public class AgendamentoSelectApp {

	private boolean resultado;
	private MeuResultSet retorno;

	@GET//@GET é obrigatório
	@Path("/{parmCPF}")//@Path é obrigatório
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Agendamento> setAgendamento(@PathParam("parmCPF") String parmCPF) {
		
		MeuResultSet resultado;
		ArrayList<Agendamento> agendamento = new ArrayList<>();
		
		try {
			
			System.out.println("CPF Select = " + parmCPF);
			
			resultado = BD.agendamentos.selectAgendamentos(parmCPF);
			
			while(resultado.next()){
				agendamento.add(new Agendamento(String.valueOf(resultado.getInt("ID_AGENDAMENTO")), resultado.getString("CLIENTE_CPF"), resultado.getString("DATA_AGENDADA"), 
						resultado.getString("HORARIO"), resultado.getString("ANIMAL"), resultado.getString("BANHO"), 
						resultado.getString("TOSA"), resultado.getString("HIDRATACAO"), 
						resultado.getString("UNHAS"), resultado.getString("DENTES"), resultado.getString("OUVIDOS"), resultado.getString("TOTAL")));
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return agendamento;
	}
}