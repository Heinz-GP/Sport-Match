package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Chat extends AppCompatActivity implements View.OnClickListener {


    private EditText et_msg;
    private TextView tv_msg1;
    private TextView tv_msg2;
    private TextView tv_msg3;
    private TextView tv_msg4;
    private TextView tv_msg5;
    private TextView tv_msg6;
    private TextView tv_msg7;
    private TextView tv_msg8;
    private Button btn_msg;
    private Integer nroCliques = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);

        et_msg = findViewById(R.id.et_msg);
        tv_msg1 = findViewById(R.id.tv_msg1);
        tv_msg2 = findViewById(R.id.tv_msg2);
        tv_msg3 = findViewById(R.id.tv_msg3);
        tv_msg4 = findViewById(R.id.tv_msg4);
        tv_msg5 = findViewById(R.id.tv_msg5);
        tv_msg6 = findViewById(R.id.tv_msg6);
        tv_msg7 = findViewById(R.id.tv_msg7);
        tv_msg8 = findViewById(R.id.tv_msg8);
        btn_msg = findViewById(R.id.btn_msg);


        btn_msg.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == btn_msg){
            click();
            nroCliques++;
            et_msg.setText("");
        }
    }

    public void click(){
        if(nroCliques == 0){
            tv_msg1.setText(et_msg.getText().toString());
            tv_msg2.setText("Olá");
        }else if (nroCliques == 1){
            tv_msg3.setText(et_msg.getText().toString());
            tv_msg4.setText("Tudo bem, e tu?");
        }else if(nroCliques == 2){
            tv_msg5.setText(et_msg.getText().toString());
            tv_msg6.setText("Irei sim");
        }else if(nroCliques == 3){
            tv_msg7.setText(et_msg.getText().toString());
            tv_msg8.setText("OK. Nós falamos no jogo.");
        }
    }
}
