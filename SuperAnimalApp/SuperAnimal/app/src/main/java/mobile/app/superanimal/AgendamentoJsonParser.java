package mobile.app.superanimal;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Talita on 22/11/2017.
 */

public class AgendamentoJsonParser {


   public static ArrayList<Agendamento> parseDados(String conteudo) {

        try {
            JSONArray jsonArray = new JSONArray(conteudo);

            ArrayList<Agendamento> agendamentosArray = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                Agendamento agendamento = new Agendamento();

                agendamento.setId_agendamento(jsonObject.getString("id_agendamento"));
                agendamento.setCpf_cliente(jsonObject.getString("cpf_cliente"));
                agendamento.setData(jsonObject.getString("data"));
                agendamento.setHorario(jsonObject.getString("horario"));
                agendamento.setAnimal(jsonObject.getString("animal"));

                if(jsonObject.getString("banho").trim().equals("S")) {
                    agendamento.setBanho("Banho");
                }

                else{
                    agendamento.setBanho(" ");
                }

                if(jsonObject.getString("tosa").trim().equals("S")) {
                    agendamento.setTosa("Tosa");
                }

                else{
                    agendamento.setTosa(" ");
                }

                if (jsonObject.getString("hidratacao").trim().equals("S")) {
                    agendamento.setHidratacao("Hidratação");
                }

                else{
                    agendamento.setHidratacao(" ");
                }

                if(jsonObject.getString("unhas").trim().equals("S")) {
                    agendamento.setUnhas("Cortar as Unhas");
                }

                else{
                    agendamento.setUnhas(" ");
                }


                if(jsonObject.getString("dentes").trim().equals("S")) {
                    agendamento.setDentes("Escovação dos Dentes");
                }

                else{
                    agendamento.setDentes(" ");
                }

                if(jsonObject.getString("ouvidos").trim().equals("S")) {
                    agendamento.setOuvidos("Limpeza dos Ouvidos");
                }

                else{
                    agendamento.setOuvidos(" ");
                }

                agendamento.setTotal(jsonObject.getString("total"));

                agendamentosArray.add(agendamento);
            }

            return agendamentosArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
