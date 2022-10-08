package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import androidx.appcompat.app.AppCompatActivity;

public class MenuCategorias extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btn_futebol;
    private ImageButton btn_volei;
    private ImageButton btn_basquete;
    private ImageButton btn_tenis;
    private ImageButton btn_trilha;
    private ImageButton btn_rugby;
    private ImageButton btn_skate;
    private ImageButton btn_corrida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_categorias);

        try {
            btn_futebol = findViewById(R.id.btn_futebol);
            btn_volei = findViewById(R.id.btn_volei);
            btn_basquete = findViewById(R.id.btn_basquete);
            btn_tenis = findViewById(R.id.btn_tenis);
            btn_trilha = findViewById(R.id.btn_trilha);
            btn_rugby = findViewById(R.id.btn_rugby);
            btn_skate = findViewById(R.id.btn_skate);
            btn_corrida = findViewById(R.id.btn_corrida);

            btn_futebol.setOnClickListener(this);
            btn_volei.setOnClickListener(this);
            btn_basquete.setOnClickListener(this);
            btn_tenis.setOnClickListener(this);
            btn_trilha.setOnClickListener(this);
            btn_rugby.setOnClickListener(this);
            btn_skate.setOnClickListener(this);
            btn_corrida.setOnClickListener(this);
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }


    @Override
    public void onClick(View view) {
        try{
            if(view == btn_futebol){

            }else if(view == btn_volei){

            }else if(view == btn_basquete){

            }else if(view == btn_tenis){

            }else if(view == btn_trilha){

            }else if(view == btn_rugby){

            }else if(view == btn_skate){

            }else if(view == btn_corrida){

            }
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }
}
