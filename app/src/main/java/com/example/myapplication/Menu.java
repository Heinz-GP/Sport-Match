package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity implements  View.OnClickListener{

    private ImageButton btn_categorias;
    private ImageButton btn_perfil;
    private ImageButton btn_mural;
    private ImageButton btn_sair;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        try {
            btn_categorias = findViewById(R.id.btn_categorias);
            btn_perfil = findViewById(R.id.btn_perfil);
            btn_mural = findViewById(R.id.btn_mural);
            btn_sair = findViewById(R.id.btn_sair);

            btn_categorias.setOnClickListener(this);
            btn_perfil.setOnClickListener(this);
            btn_mural.setOnClickListener(this);
            btn_sair.setOnClickListener(this);
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }


    @Override
    public void onClick(View view) {
        if(view == btn_perfil){
            Intent i = new Intent(getApplicationContext(), Perfil.class);
            startActivity(i);
        }else if(view == btn_categorias){
            Intent i = new Intent(getApplicationContext(), MenuCategorias.class);
            startActivity(i);
        }else if(view == btn_mural){
            Intent i = new Intent(getApplicationContext(), Mural.class);
            startActivity(i);
        }else if(view == btn_sair){
            finish();
            System.exit(0);
        }
    }
}
