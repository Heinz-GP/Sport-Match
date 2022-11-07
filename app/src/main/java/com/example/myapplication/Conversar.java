package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;




public class Conversar extends AppCompatActivity {

    private Button btn_1msg;
    private Button btn_2msg;
    private Button btn_3msg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversar);

        try {

            btn_1msg = findViewById(R.id.btn_1msg);
            btn_2msg = findViewById(R.id.btn_2msg);
            btn_3msg = findViewById(R.id.btn_3msg);


            btn_1msg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), Chat.class);
                    startActivity(i);
                }
            });

            btn_2msg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), Chat.class);
                    startActivity(i);
                }
            });

            btn_3msg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), Chat.class);
                    startActivity(i);
                }
            });

        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }

    }
}
