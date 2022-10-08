package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


import androidx.appcompat.app.AppCompatActivity;

public class EditarPerfil extends AppCompatActivity implements View.OnClickListener {

    private Button btn_mudarFoto;
    private Button btn_excluirFoto;
    private ImageButton btn_addCategoria;
    private Button btn_salvar;
    private EditText edText_sobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_perfil);

        try {
            btn_mudarFoto = findViewById(R.id.btn_mudarFoto);
            btn_excluirFoto = findViewById(R.id.btn_excluirFoto);
            btn_addCategoria = findViewById(R.id.btn_addCategoria);
            btn_salvar = findViewById(R.id.btn_salvar);
            edText_sobre = findViewById(R.id.edText_sobre);

            btn_mudarFoto.setOnClickListener(this);
            btn_excluirFoto.setOnClickListener(this);
            btn_addCategoria.setOnClickListener(this);
            btn_salvar.setOnClickListener(this);
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        if(view == btn_mudarFoto){

        }else if(view == btn_excluirFoto){

        }else if(view == btn_addCategoria){

        }else if (view == btn_salvar){

        }
    }
}
