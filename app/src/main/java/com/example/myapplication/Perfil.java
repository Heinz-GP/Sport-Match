package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import androidx.appcompat.app.AppCompatActivity;

public class Perfil extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btn_editarPerfil;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil);

        btn_editarPerfil = findViewById(R.id.btn_editarPerfil);

        btn_editarPerfil.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, EditarPerfil.class);
        startActivity(i);
    }
}
