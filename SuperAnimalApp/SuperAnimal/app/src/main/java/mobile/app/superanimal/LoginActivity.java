package mobile.app.superanimal;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    EditText cpf, senha;
    Button btnEntrar;
    ProgressBar progressBarLogin;
    Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        cpf = (EditText )findViewById(R.id.cpf);
        senha = (EditText) findViewById(R.id.senha);

        cpf.addTextChangedListener(Mask.insert("###.###.###-##", cpf));

        btnEntrar = (Button) findViewById(R.id.btnEntrar);

        progressBarLogin = (ProgressBar) findViewById(R.id.progressBarLogin);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(cpf.getText().toString().trim()) && TextUtils.isEmpty(senha.getText().toString().trim())) {
                    cpf.setError("Campo obrigatório");
                    senha.setError("Campo obrigatório");
                    cpf.requestFocus();
                    return;
                }

                else if(TextUtils.isEmpty(cpf.getText().toString().trim())) {
                    cpf.setError("Campo obrigatório");
                    cpf.requestFocus();
                    return;
                }

                else if(TextUtils.isEmpty(senha.getText().toString().trim())) {
                    senha.setError("Campo obrigatório");
                    senha.requestFocus();
                    return;
                }

                else {

                    if(cpf.getText().toString().length() < 14){
                        cpf.setError("Digite 14 números");
                        cpf.requestFocus();
                        return;
                    }

                    else if (senha.getText().toString().length() < 8){
                        senha.setError("Digite 8 caracteres");
                        senha.requestFocus();
                        return;
                    }

                    else {

                        TaskLogin threadLogin = new TaskLogin();

                        threadLogin.execute("http://192.168.43.166:1303/SuperAnimal/mobile/LoginApp/" + cpf.getText().toString() + "/" + senha.getText().toString());
                    }

                }
            }
        });
    }

    private boolean isOline(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnectedOrConnecting()){
            return true;
        }

        else{
            return false;
        }
    }

    private class TaskLogin extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {

            if(isOline()) {
                openDialog();
            }

            else{
                Toast.makeText(LoginActivity.this, "Ligue seu Wi-Fi ou dados móveis", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        protected String doInBackground(String... params) {

            String conteudo = null;

            try{
                Thread.sleep(3000);
            }
            catch(Exception e){
                e.printStackTrace();
            }

            if(isOline()) {
                conteudo = HttpManager.getRetorno(params[0]);
            }

            return conteudo;
        }

        @Override
        protected void onPostExecute (String conteudo){
            validarDados(conteudo);
        }
    }

    public void openDialog(){

        mDialog = new Dialog(this);
        //vamos remover o titulo da Dialog
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //vamos carregar o xml personalizado
        mDialog.setContentView(R.layout.dialog);
        //Deixamos transparente
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        // não permitimos fechar esta dialog
        mDialog.setCancelable(false);
        //temos a instancia do ProgressBar!
        final ProgressBar progressBar = ProgressBar.class.cast(mDialog.findViewById(R.id.progressBarLogin));

        mDialog.show();
    }

    public void validarDados(String conteudo){

        if(conteudo != null){
            mDialog.dismiss(); //para fechar a dialog

            if(conteudo.trim().equals("true")) {

                Bundle loginParam = new Bundle();

                loginParam.putString("cpf", cpf.getText().toString());

                Intent intent = new Intent(LoginActivity.this, AgendamentoActivity.class);

                intent.putExtras(loginParam);
                startActivity(intent);
            }

            else{
                Toast.makeText(this, "Usuário e ou senha inválidos", Toast.LENGTH_LONG).show();
            }
        }

        else{

            if(mDialog != null) {
                mDialog.dismiss(); //para fechar a dialog
            }

            Toast.makeText(this, "Falha ao consultar seus dados", Toast.LENGTH_LONG).show();
        }
    }
}