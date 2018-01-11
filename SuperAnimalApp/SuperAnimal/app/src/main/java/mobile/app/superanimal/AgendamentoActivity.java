package mobile.app.superanimal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class AgendamentoActivity extends AppCompatActivity {

    FloatingActionButton fabAdd;
    ListView listAgenda;
    String cpf;
    ArrayList<Agendamento> listAgendaArray;
    ArrayList<String> listAgendaArrayString, listAgendaArrayStringNew;
    String split [];
    TextView txtVazio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cpf = getIntent().getStringExtra("cpf");

        fabAdd = (FloatingActionButton) findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle loginParam = new Bundle();

                loginParam.putString("cpf", cpf);

                Intent intent = new Intent(AgendamentoActivity.this, AgendamentoCreateActivity.class);

                intent.putExtras(loginParam);
                startActivity(intent);
            }
        });

        listAgenda = (ListView) findViewById(R.id.listAgenda);
        listAgendaArray = new ArrayList<>();
        listAgendaArrayString = new ArrayList<>();
        listAgendaArrayStringNew = new ArrayList<>();
        txtVazio = (TextView) findViewById(R.id.txtVazio);

        txtVazio.setVisibility(View.INVISIBLE);

        //Criar agendamento
        AgendamentoActivity.TaskReadAgendamento threadLista= new AgendamentoActivity.TaskReadAgendamento();

        threadLista.execute("http://192.168.43.166:1303/SuperAnimal/mobile/AgendamentoSelectApp/" + cpf);

        listAgenda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder alerta = new AlertDialog.Builder(AgendamentoActivity.this);

                split = listAgendaArrayString.get(i).replaceAll("ID#", "").split("\n");

                alerta.setTitle("EXCLUIR");
                alerta.setMessage("Essa operação é irreversível. Deseja continuar?");

                alerta.setCancelable(false);


                alerta.setNegativeButton("Não",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                dialog.dismiss();
                            }
                        });

                alerta.setPositiveButton("Sim",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                //Criar agendamento
                                AgendamentoActivity.TaskDeleteAgendamento threadDeletar= new AgendamentoActivity.TaskDeleteAgendamento();

                                threadDeletar.execute("http://192.168.43.166:1303/SuperAnimal/mobile/AgendamentoDeleteApp/" + split[0].trim());
                            }
                        });

                alerta.show();
            }
        });
    }

    private boolean isOline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }

    private class TaskReadAgendamento extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {

            if (!isOline()) {
                Toast.makeText(AgendamentoActivity.this, "Ligue seu Wi-Fi ou dados móveis", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        protected String doInBackground(String... params) {

            String conteudo = null;

            if(isOline()) {
                conteudo = HttpManager.getRetorno(params[0]);
            }

            return conteudo;
        }

        @Override
        protected void onPostExecute(String conteudo) {

            if(conteudo != null){

                if(conteudo.trim().length() == 2){
                    txtVazio.setVisibility(View.VISIBLE);
                }

                else  {

                    listAgendaArray = AgendamentoJsonParser.parseDados(conteudo);
                    exibirAgendamento(listAgendaArray);
                    txtVazio.setVisibility(View.INVISIBLE);
                }
            }

            else{
                Toast.makeText(AgendamentoActivity.this, "Falha ao exibir Agendamentos", Toast.LENGTH_LONG).show();
            }
        }

        public void exibirAgendamento(ArrayList<Agendamento> listAgendaArray) {

            for(int x = 0; x < listAgendaArray.size(); x++) {


                listAgendaArrayString.add("ID# " + listAgendaArray.get(x).getId_agendamento().trim() + "\n" + listAgendaArray.get(x).getData().trim() + " - "
                        + listAgendaArray.get(x).getHorario().trim() + " - " + listAgendaArray.get(x).getAnimal().trim() + "\n"
                        + listAgendaArray.get(x).getBanho().trim() + "\n"
                        + listAgendaArray.get(x).getTosa().trim() + "\n"
                        + listAgendaArray.get(x).getHidratacao().trim() + "\n"
                        + listAgendaArray.get(x).getUnhas().trim() + "\n"
                        + listAgendaArray.get(x).getDentes().trim() + "\n"
                        + listAgendaArray.get(x).getOuvidos().trim() + "\n"
                        + "Total = R$" + listAgendaArray.get(x).getTotal().trim());

                listAgendaArrayStringNew.add(listAgendaArrayString.get(x).replaceAll("\n{2,}", "\n"));
            }

            // Create The Adapter with passing ArrayList as 3rd parameter
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(AgendamentoActivity.this, android.R.layout.simple_list_item_1, listAgendaArrayStringNew);
                // Set The Adapter
                listAgenda.setAdapter(arrayAdapter);
        }
    }

    private class TaskDeleteAgendamento extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {

            if (!isOline()) {
                Toast.makeText(AgendamentoActivity.this, "Ligue seu Wi-Fi ou dados móveis", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        protected String doInBackground(String... params) {

            String conteudo = null;

            if(isOline()) {
                conteudo = HttpManager.getRetorno(params[0]);
            }

            return conteudo;
        }

        @Override
        protected void onPostExecute(String conteudo) {

            if (conteudo != null) {
                Toast.makeText(AgendamentoActivity.this, "Excluído com sucesso", Toast.LENGTH_SHORT).show();

                Intent intent = getIntent();
                finish();
                startActivity(intent);
            } else {
                Toast.makeText(AgendamentoActivity.this, "Falha ao excluir Agendamento", Toast.LENGTH_LONG).show();
        }
        }
    }
}