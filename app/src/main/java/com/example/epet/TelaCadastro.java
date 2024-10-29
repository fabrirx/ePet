

package com.example.epet;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.UrlRewriter;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class TelaCadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        // Iniciar os componentes
        Button cadastra = findViewById(R.id.btCadastrar);
        EditText nome = findViewById(R.id.editTextNome);
        EditText cpf = findViewById(R.id.editTextCpf);
        EditText telefone = findViewById(R.id.editTextFone);
        EditText cidade = findViewById(R.id.editTextCidade);
        EditText bairro = findViewById(R.id.editTextBairro);
        EditText rua = findViewById(R.id.editTextRua);
        EditText num = findViewById(R.id.editTextNum);
        EditText cep = findViewById(R.id.editTextCep);
        EditText email = findViewById(R.id.editTextEmail);
        EditText senha = findViewById(R.id.editTextSenha);



        RequestQueue requisicao = Volley.newRequestQueue(this);
        String url = "http://localhost:5215/api/ServicesUsuario/Cadastrar";

        // Configurar o botão de cadastro

        cadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JSONObject jsonBody = new JSONObject();

                try {
                    jsonBody.put("nome", nome.getText().toString());
                    jsonBody.put("telefone", telefone.getText().toString());
                    jsonBody.put("cep", cep.getText().toString());
                    jsonBody.put("cidade",cidade.getText().toString());
                    jsonBody.put("bairro", bairro.getText().toString());
                    jsonBody.put("rua", rua.getText().toString());
                    jsonBody.put("complemento", rua.getText().toString());
                    jsonBody.put("cpf", cpf.getText().toString());
                    jsonBody.put("email", email.getText().toString());
                    jsonBody.put("dataNasc", num.getText().toString());
                    jsonBody.put("senha", senha.getText().toString());
                    jsonBody.put("isAdm", num.getText().toString());
                }catch (JSONException exc){
                    exc.printStackTrace();
                }


                JsonObjectRequest enviarPost = new JsonObjectRequest(
                        Request.Method.POST, url, jsonBody,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                if (response.has("mensagem")) {
                                    Toast.makeText(TelaCadastro.this, "Cadastro", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(TelaCadastro.this, "Erro ao Enviar", Toast.LENGTH_SHORT).show();
                    }
                }

                );
                requisicao.add(enviarPost);

            }
        });
    }
}