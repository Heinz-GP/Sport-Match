package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Mural extends AppCompatActivity implements View.OnClickListener {

    private Spinner spn_escolherCat;
    private Button btn_1msg;
    private Button btn_2msg;
    private Button btn_3msg;
    private ImageButton btn_novaPostagem;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mural);

        try {
            btn_1msg = findViewById(R.id.btn_1msg);
            btn_2msg = findViewById(R.id.btn_2msg);
            btn_3msg = findViewById(R.id.btn_3msg);
            btn_novaPostagem = findViewById(R.id.btn_novaPostagem);

            spn_escolherCat = (Spinner) findViewById(R.id.spn_escolherCat);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spn_categorias, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spn_escolherCat.setAdapter(adapter);




            btn_1msg.setOnClickListener(this);
            btn_2msg.setOnClickListener(this);
            btn_3msg.setOnClickListener(this);
            btn_novaPostagem.setOnClickListener(this);
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View view) {
        if(view == spn_escolherCat){

        }else if(view == btn_1msg){

        }else if(view == btn_2msg){

        }else if(view == btn_3msg){

        }else if(view == btn_novaPostagem){

        }
    }


}
