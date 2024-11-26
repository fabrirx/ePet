package com.example.epet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class telaDenunciaAbandono extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_denuncia_abandono);

        EditText relatar = findViewById(R.id.editRelatar);
        EditText rua = findViewById(R.id.editRua);
        EditText bairro = findViewById(R.id.editBairro);
        EditText cidade = findViewById(R.id.editCidade);
        EditText numero = findViewById(R.id.editNumero);
        EditText complemento = findViewById(R.id.editComplemento);
        Button enviar = findViewById(R.id.btENVIARDenunAband);

        RequestQueue requisicao = Volley.newRequestQueue(this);
        String url = "http://10.0.2.2:5000/api/ServiceDenunciar/Denunciar";

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JSONObject dadosBody = new JSONObject();

                try {
                    dadosBody.put("descricao", relatar.getText().toString());
                    dadosBody.put("cidade", cidade.getText().toString());
                    dadosBody.put("bairro", bairro.getText().toString());
                    dadosBody.put("rua", rua.getText().toString());
                    dadosBody.put("numero", numero.getText().toString());
                    dadosBody.put("complemento", complemento.getText().toString());

                }catch (JSONException exc){
                    exc.printStackTrace();
                }

                JsonObjectRequest enviarPost = new JsonObjectRequest(
                        Request.Method.POST, url, dadosBody,

                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                if (response.has("menssagem")) {
                                    Toast.makeText(telaDenunciaAbandono.this, "denuncia feita", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(telaDenunciaAbandono.this, "Erro ao enviar", Toast.LENGTH_SHORT).show();
                    }
                });
                requisicao.add(enviarPost);

            }
        });

    }
}



















