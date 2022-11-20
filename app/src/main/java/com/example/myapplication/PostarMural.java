package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


import androidx.appcompat.app.AppCompatActivity;

public class PostarMural extends AppCompatActivity implements View.OnClickListener {

    private Spinner spn_escolherCat;
    private EditText et_data;
    private EditText et_horarioInicio;
    private EditText et_horarioFim;
    private EditText et_local;
    private Button btn_salvar;
    private String descricao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postar_mural);

        try {

            et_data = findViewById(R.id.et_data);
            et_horarioInicio = findViewById(R.id.et_horarioInicio);
            et_horarioFim = findViewById(R.id.et_horarioFim);
            et_local = findViewById(R.id.et_local);
            btn_salvar = findViewById(R.id.btn_salvar);



            spn_escolherCat = findViewById(R.id.spn_escolherCat);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spn_categorias, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spn_escolherCat.setAdapter(adapter);


            btn_salvar.setOnClickListener(this);
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }

    }





    @Override
    public void onClick(View view) {
        if(view == btn_salvar){
            proxTela();
        }
    }

    public void pegarInfo(){
        String cat = spn_escolherCat.getSelectedItem().toString();
        String data = et_data.getText().toString();
        String horarioInicio = et_horarioInicio.getText().toString();
        String horarioFim = et_horarioFim.getText().toString();
        String local = String.valueOf(et_local.getText());
        descricao = cat +  " - " + data + " - " + horarioInicio + " ás " + horarioFim + ".";
    }

    public void proxTela(){
        try{
            pegarInfo();
            Intent i = new Intent(this, Atividade.class);
            Bundle params = new Bundle();
            params.putString("descricao", descricao);
            params.putString("local", et_local.getText().toString());


            i.putExtras(params);
            startActivity(i);
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }
}

