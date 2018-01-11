package mobile.app.superanimal;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AgendamentoCreateActivity extends AppCompatActivity {

    Button btnSalvar, btnPronto;
    Dialog mDialog;
    CheckBox checkBoxBanho, checkBoxTosa, checkBoxHidratacao, checkBoxUnhas, checkBoxDentes, checkBoxOuvido;
    double total = 0;
    TextView txtSoma, txtTotalEscolhidos;
    Spinner spinnerData, spinnerHorario, spinnerAnimal;
    FloatingActionButton fatServicos, fabLista;
    String banho = "N", tosa = "N", hidratacao = "N", unhas = "N", dentes = "N", ouvidos = "N", cpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento_create);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cpf = getIntent().getStringExtra("cpf");

        fabLista = (FloatingActionButton) findViewById(R.id.fabLista);
        fabLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle loginParam = new Bundle();

                loginParam.putString("cpf", cpf);

                Intent intent = new Intent(AgendamentoCreateActivity.this, AgendamentoActivity.class);

                intent.putExtras(loginParam);
                startActivity(intent);
            }
        });

        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        fatServicos = (FloatingActionButton) findViewById(R.id.fatServicos);

        txtSoma = (TextView) findViewById(R.id.txtSoma);
        txtTotalEscolhidos = (TextView) findViewById(R.id.txtTotalEscolhidos);

        spinnerData = (Spinner) findViewById(R.id.spinnerData);
        spinnerHorario = (Spinner) findViewById(R.id.spinnerHorario);
        spinnerAnimal = (Spinner) findViewById(R.id.spinnerAnimal);

        fatServicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    //Nenhum servoço foi selecionado
                    if (total == 0) {
                        Toast.makeText(AgendamentoCreateActivity.this, "Insira pelo menos 1 serviço", Toast.LENGTH_LONG).show();
                    } else {

                        //Criar agendamento
                        TaskCreateAgendamento threadAgendamento = new TaskCreateAgendamento();

                        threadAgendamento.execute("http://192.168.43.166:1303/SuperAnimal/mobile/AgendamentoCreateApp/"
                                + cpf + "/" + spinnerData.getSelectedItem().toString() + "/" + spinnerHorario.getSelectedItem().toString() + "/"
                                + spinnerAnimal.getSelectedItem().toString() + "/" + String.valueOf(total) + "/"
                                + banho + "/" + tosa + "/" + hidratacao + "/" + unhas + "/" + dentes + "/" + ouvidos);

                        fatServicos.setEnabled(false);
                        btnSalvar.setEnabled(false);
                        fabLista.setEnabled(false);
                    }
            }
        });

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterData = ArrayAdapter.createFromResource(this,
                R.array.arrayData, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterData.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerData.setAdapter(adapterData);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterHorario = ArrayAdapter.createFromResource(this,
                R.array.arrayHorario, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterHorario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerHorario.setAdapter(adapterHorario);

        String animais[] = {"BANSHEE", "DARA", "NICKS", "JASMIM"};

        // Application of the Array to the Spinner
        ArrayAdapter<String> adapterAnimal = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, animais);
        adapterAnimal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinnerAnimal.setAdapter(adapterAnimal);
    }

    public void openDialog() {

        mDialog = new Dialog(this);
        //vamos remover o titulo da Dialog
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //vamos carregar o xml personalizado
        mDialog.setContentView(R.layout.servicos);
        //Deixamos transparente
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        // não permitimos fechar esta dialog
        mDialog.setCancelable(false);

        mDialog.show();

        btnPronto = (Button) mDialog.findViewById(R.id.btnPronto);

        checkBoxBanho = (CheckBox) mDialog.findViewById(R.id.checkBoxBanho);
        checkBoxTosa = (CheckBox) mDialog.findViewById(R.id.checkBoxTosa);
        checkBoxHidratacao = (CheckBox) mDialog.findViewById(R.id.checkBoxHidratacao);
        checkBoxUnhas = (CheckBox) mDialog.findViewById(R.id.checkBoxUnhas);
        checkBoxDentes = (CheckBox) mDialog.findViewById(R.id.checkBoxDentes);
        checkBoxOuvido = (CheckBox) mDialog.findViewById(R.id.checkBoxOuvido);

        btnPronto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = 0;
                txtTotalEscolhidos.setText("");
                banho = "N";
                tosa = "N";
                hidratacao = "N";
                unhas = "N";
                dentes = "N";
                ouvidos = "N";

                mDialog.dismiss(); //para fechar a dialog

                if (checkBoxBanho.isChecked()) {
                    total += 40.00;
                    txtTotalEscolhidos.append("Banho - R$40,00" + "\n");
                    banho = "S";
                }

                if (checkBoxTosa.isChecked()) {
                    total += 35.00;
                    txtTotalEscolhidos.append("Tosa - R$35,00" + "\n");
                    tosa = "S";
                }

                if (checkBoxHidratacao.isChecked()) {
                    total += 65.00;
                    txtTotalEscolhidos.append("Hidratação - R$65,00" + "\n");
                    hidratacao = "S";
                }

                if (checkBoxUnhas.isChecked()) {
                    total += 15.00;
                    txtTotalEscolhidos.append("Corte de Unhas - R$15,00" + "\n");
                    unhas = "S";
                }

                if (checkBoxDentes.isChecked()) {
                    total += 5.00;
                    txtTotalEscolhidos.append("Escovação dos Dentes - R$5,00" + "\n");
                    dentes = "S";
                }

                if (checkBoxOuvido.isChecked()) {
                    total += 10.00;
                    txtTotalEscolhidos.append("Limpeza dos Ouvidos - R$10,00" + "\n");
                    ouvidos = "S";
                }

                if (!checkBoxBanho.isChecked() && !checkBoxTosa.isChecked() && !checkBoxHidratacao.isChecked() &&
                        !checkBoxUnhas.isChecked() && !checkBoxDentes.isChecked() && !checkBoxOuvido.isChecked()) {
                    txtTotalEscolhidos.setText("Nemhum serviço escolhido" + "\n");
                }

                txtSoma.setText("R$" + String.format("%.2f", total));
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

    private class TaskCreateAgendamento extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {

            if (!isOline()) {
                Toast.makeText(AgendamentoCreateActivity.this, "Ligue seu Wi-Fi ou dados móveis", Toast.LENGTH_LONG).show();

                fatServicos.setEnabled(true);
                btnSalvar.setEnabled(true);
                fabLista.setEnabled(true);
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
            validarCreateAgendamento(conteudo);
        }

        public void validarCreateAgendamento(String conteudo) {

            if (conteudo != null) {

                if (conteudo.trim().equals("true")) {
                    Toast.makeText(AgendamentoCreateActivity.this, "Agendado com sucesso", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(AgendamentoCreateActivity.this, "Agendamento falhou", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(AgendamentoCreateActivity.this, "Falha durante o salvar", Toast.LENGTH_LONG).show();
            }

            fatServicos.setEnabled(true);
            btnSalvar.setEnabled(true);
            fabLista.setEnabled(true);
        }
    }
}