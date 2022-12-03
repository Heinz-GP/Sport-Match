package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class Cadastrar extends AppCompatActivity {

    private EditText et_nome;
    private EditText et_email;
    private EditText et_senha;
    private EditText et_telefone;
    private Button btn_cadastrar;
    private Button btn_chamaLogin;


    private FirebaseAuth mAuth;
    private Task tarefa;

    BancoDados db = new BancoDados(this);


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


            mAuth = FirebaseAuth.getInstance();



        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }

            btn_chamaLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            });


            btn_cadastrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        String email = et_email.getText().toString().trim();
                        String senha = et_senha.getText().toString().trim();
                        String nome = et_nome.getText().toString().trim();
                        String telefone = et_telefone.getText().toString().trim();

                        if (email.isEmpty()) {
                            et_email.setError("Email é necessário");
                        }else{
                            //insert
                            db.addUsuario(new Usuario(nome, email,senha, telefone));
                        }
                        if (senha.isEmpty()) {
                            et_senha.setError("Senha é necessária");
                        }
                        if (senha.length() < 6) {
                            et_senha.setError("Senha deve ter mais de 6 caracteres");
                        }



                        tarefa = mAuth.createUserWithEmailAndPassword(email, senha);
                        if(!tarefa.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "Falha ao cadastrar!", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "Cadastrado com Sucesso", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Menu.class));
                        }


                    } catch (Exception e) {
                        e.getMessage();
                        e.printStackTrace();
                    }
                }
            });



            //TESTE CRUD
            //Adicionar
            //db.addUsuario(new Usuario("fsdfa","fasdf","fasd"));

            //Deletar
            //Usuario usuario = new Usuario();
            //usuario.setId(20);
            //db.deleteUsuario(usuario);

            //Selecionar
            //Usuario usuario = db.selecionarUsuario(4);
            //Log.d("Usuario selecionado", "ID " + usuario.getNome() + " Nome : "
            //    + usuario.getSenha() + " CPF: " + usuario.getEmail());

            //Atualizar
            //Usuario usuario = new Usuario();
            //usuario.setId(4);
            //usuario.setNome("TU");
            //usuario.setSenha("0987654321");
            //usuario.setEmail("Tu@TU.com");
            //db.atualizarUsuario(usuario);
            //Toast.makeText(getApplicationContext(), "Atualizado com Sucesso", Toast.LENGTH_SHORT).show();
    }

}


