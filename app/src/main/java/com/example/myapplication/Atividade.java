package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class Atividade extends AppCompatActivity implements View.OnClickListener{


    protected TextView tv_descricao;
    private TextView tv_local;
    private Button btn_participar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atividade);

        try{
            tv_descricao = findViewById(R.id.tv_descricao);
            tv_local = findViewById(R.id.tv_local);
            btn_participar = findViewById(R.id.btn_participar);





            btn_participar.setOnClickListener(this);
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        try{
                Toast.makeText(getApplicationContext(),"Atividade Adicionada", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }

}
