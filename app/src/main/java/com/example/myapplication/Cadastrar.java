package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Cadastrar extends AppCompatActivity {

    private EditText et_nome;
    private EditText et_email;
    private EditText et_senha;
    private EditText et_telefone;
    private Button btn_cadastrar;
    private Button btn_chamaLogin;
    private FirebaseAuth fAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar);

        try {
            et_nome = findViewById(R.id.et_nome);
            et_email = findViewById(R.id.et_email);
            et_senha = findViewById(R.id.et_senha);
            et_telefone = findViewById(R.id.et_telefone);
            btn_cadastrar = findViewById(R.id.btn_cadastrar);
            btn_chamaLogin = findViewById(R.id.btn_chamaLogin);


            btn_chamaLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            });

            fAuth = FirebaseAuth.getInstance();

            if(fAuth.getCurrentUser() != null){
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }

            btn_cadastrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        String email = et_email.getText().toString().trim();
                        String senha = et_senha.getText().toString().trim();

                        if(TextUtils.isEmpty(email)){
                            et_email.setError("Email é necessário");
                            return;
                        }
                        if(TextUtils.isEmpty(senha)){
                            et_senha.setError("Senha é necessária");
                            return;
                        }
                        if(senha.length() < 6){
                            et_senha.setError("Senha deve ter mais de 6 caracteres");
                            return;
                        }

                        //Criar conta

                        fAuth.createUserWithEmailAndPassword(email,senha).addOnCompleteListener(task -> {
                            if (task.isSuccessful()){
                                Toast.makeText(Cadastrar.this, "Usuário Criado!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }else{
                                Toast.makeText(Cadastrar.this, "Erro!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                    }catch (Exception e){
                        e.getMessage();
                        e.printStackTrace();
                    }
                }
            });

        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }


    }





}
