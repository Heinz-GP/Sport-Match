package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.analytics.FirebaseAnalytics;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Button btn_login;
    private Button btn_cadastrar;
    private FirebaseAnalytics mFirebaseAnalytics;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            btn_login = findViewById(R.id.btn_login);
            btn_cadastrar = findViewById(R.id.btn_cadastrar);

            btn_cadastrar.setOnClickListener(this);
            btn_login.setOnClickListener(this);

            mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        try{
            if(view == btn_login){
                startActivity(new Intent(this,Menu.class));
            }else if(view == btn_cadastrar){
                startActivity(new Intent(this, Cadastrar.class));
            }
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }

    }

}