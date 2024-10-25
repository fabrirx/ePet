

package com.example.epet;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        EditText bairro = findViewById(R.id.editTextBairro);
        EditText num = findViewById(R.id.editTextNum);
        EditText cep = findViewById(R.id.editTextCep);
        EditText email = findViewById(R.id.editTextEmail);
        EditText senha = findViewById(R.id.editTextSenha);
        EditText rua = findViewById(R.id.editTextRua);

        // Configurar o botão de cadastro
        cadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Chamar o método do Retrofit
                UsuariosService usuariosService = RetrofitClient.getRetrofitInstance().create(UsuariosService.class);
                Call<String> call = usuariosService.cadastrarUsuario(
                        nome.getText().toString(),
                        telefone.getText().toString(),
                        cep.getText().toString(),
                        "cidade", // Altere conforme necessário
                        bairro.getText().toString(),
                        rua.getText().toString(),
                        "complemento", // Altere conforme necessário
                        cpf.getText().toString(),
                        email.getText().toString(),
                        "dataNasc", // Altere conforme necessário
                        senha.getText().toString(),
                        "nao" //
                );

                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(TelaCadastro.this, "Cadastro realizado!", Toast.LENGTH_SHORT).show();
                        } else {
                            Log.e("Cadastro", "Erro: " + response.code());
                            Toast.makeText(TelaCadastro.this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.e("Cadastro", "Falha na chamada: " + t.getMessage());
                        Toast.makeText(TelaCadastro.this, "Erro ao enviar", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
