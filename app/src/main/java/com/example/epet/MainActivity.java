package com.example.epet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //criando variável dos botões
        ImageButton imgbAband = findViewById(R.id.imgbAbandono);
        ImageButton imgbMaus = findViewById(R.id.imgbMausTratos);
        ImageButton imgbAdocao  = findViewById(R.id.imgbAdocao);
        ImageButton imgbApad = findViewById(R.id.imgbApadrinhar);
        Button bt_cadastro = findViewById(R.id.bt_cadastro);

        //evento ao clicar no botão
        imgbAband.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //método para abrir a outra tela
                Intent intent = new Intent(MainActivity.this, telaDenunciaMausTratos.class);
                startActivity(intent);
            }
        });

        //evento clicar no botão de cadastro invisivel
        bt_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //método para abrir a outra tela
                Intent intent = new Intent(MainActivity.this, TelaCadastro.class);
                startActivity(intent);
            }
        });
    }
}