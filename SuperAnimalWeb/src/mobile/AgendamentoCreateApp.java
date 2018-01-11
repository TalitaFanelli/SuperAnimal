package mobile;

import javax.ws.rs.core.MediaType;
import bd.BD;
import bd.core.MeuResultSet;
import bd.dbos.Agendamento;

import java.util.*;
import javax.ws.rs.*;

//@Path é obrigatório
@Path("/AgendamentoCreateApp")
public class AgendamentoCreateApp {

	private boolean resultado;
	private MeuResultSet retorno;

	@GET//@GET é obrigatório
	@Path("/{parmCPF}/{parmData}/{parmHorario}/{parmAnimal}/{parmTotal}/{parmBanho}/{parmTosa}/{parmHidratacao}/{parmUnhas}/{parmDentes}/{parmOuvidos}")//@Path é obrigatório
	@Produces(MediaType.APPLICATION_JSON)
	public String setAgendamento(@PathParam("parmCPF") String parmCPF,@PathParam("parmData") String parmData, 
			@PathParam("parmHorario") String parmHorario, @PathParam("parmAnimal") String parmAnimal, @PathParam("parmTotal") String parmTotal,
			@PathParam("parmBanho") String parmBanho, @PathParam("parmTosa") String parmTosa,
			@PathParam("parmHidratacao") String parmHidratacao, @PathParam("parmUnhas") String parmUnhas,
			@PathParam("parmDentes") String parmDentes, @PathParam("parmOuvidos") String parmOuvidos) {
		
		try {
			System.out.println("CPF = " + parmCPF);
			System.out.println("DATA = " + parmData);
			System.out.println("HORARIO = " + parmHorario);
			System.out.println("ANIMAL = " + parmAnimal);
			System.out.println("TOTAL = " + parmTotal);
			System.out.println("BANHO = " + parmBanho);
			System.out.println("TOSA = " + parmTosa);
			System.out.println("HIDRATACAO = " + parmHidratacao);
			System.out.println("UNHAS = " + parmUnhas);
			System.out.println("DENTES = " + parmDentes);
			System.out.println("OUVIDOS = " + parmOuvidos);
			
			resultado = BD.agendamentos.createAgedamento(parmCPF, parmData, parmHorario, parmAnimal, parmTotal, parmBanho, parmTosa, parmHidratacao, parmUnhas, parmDentes, parmOuvidos);
			
			return String.valueOf(resultado);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return String.valueOf(resultado);
	}
}