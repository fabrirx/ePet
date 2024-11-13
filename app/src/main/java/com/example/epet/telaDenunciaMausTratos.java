package com.example.epet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class telaDenunciaMausTratos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_denuncia_maus_tratos);


        ImageButton ligar = findViewById(R.id.btLigar);


        ligar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fazerChamada();  // Chama o método que faz a ligação
            }
        });
    }

    // Método para realizar a chamada
    public void fazerChamada() {
        String numeroTelefone = "tel:0800618080";

        // Cria o Intent para abrir a interface de discagem com o número
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(numeroTelefone));

        // Verifica se existe algum app de telefone no dispositivo
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);  // Inicia o Intent para abrir a interface de chamadas
        }
    }
}
