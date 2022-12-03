package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class BancoDados extends SQLiteOpenHelper {

    private static final int VERSAO_BANCO = 1;
    private static final String BANCO_USUARIO = "bd_usuario";
    private static final String TABELA_USUARIO = "tb_cliente";

    private static final String COLUNA_ID = "id";
    private static final String COLUNA_NOME = "nome";
    private static final String COLUNA_CPF = "cpf";
    private static final String COLUNA_DATNASC = "dataNasc";
    private static final String COLUNA_SEXO = "sexo";
    private static final String COLUNA_SENHA = "senha";
    private static final String COLUNA_EMAIL = "email";
    private static final String COLUNA_TELEFONE = "telefone";
    private static final String COLUNA_ATIVIDADE = "atividade";


    public BancoDados(Context context) {
        super(context, BANCO_USUARIO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String QUERY_COLUNA = "CREATE TABLE " + TABELA_USUARIO + "("
                + COLUNA_ID + " INTEGER PRIMARY KEY,"
                + COLUNA_NOME + " TEXT,"
                + COLUNA_CPF + " TEXT,"
                + COLUNA_DATNASC + " TEXT,"
                + COLUNA_SEXO + " TEXT,"
                + COLUNA_SENHA + " TEXT,"
                + COLUNA_EMAIL + " TEXT,"
                + COLUNA_TELEFONE + " TEXT,"
                + COLUNA_ATIVIDADE + " TEXT)";

        db.execSQL(QUERY_COLUNA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    //CRUD

    public void addUsuario(Usuario usuario){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUNA_NOME, usuario.getNome());
        values.put(COLUNA_CPF, usuario.getCpf());
        values.put(COLUNA_DATNASC, usuario.getDataNasc());
        values.put(COLUNA_SEXO, usuario.getSexo());
        values.put(COLUNA_SENHA, usuario.getSenha());
        values.put(COLUNA_EMAIL, usuario.getEmail());
        values.put(COLUNA_TELEFONE, usuario.getTelefone());
        values.put(COLUNA_ATIVIDADE, usuario.getAtividade());

        db.insert(TABELA_USUARIO, null, values);
        db.close();
    }


    public void deleteUsuario(Usuario usuario){

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABELA_USUARIO,COLUNA_ID + " = ?",new String[] {String.valueOf(usuario.getId())});
        db.close();

    }

    Usuario selecionarUsuario(int id){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABELA_USUARIO, new String[] {COLUNA_ID, COLUNA_NOME, COLUNA_CPF,
                COLUNA_DATNASC, COLUNA_SEXO,COLUNA_SENHA,COLUNA_EMAIL, COLUNA_TELEFONE, COLUNA_ATIVIDADE}
                ,COLUNA_ID + " = ?", new String[] {String.valueOf(id)},
                null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }
        Usuario usuario = new Usuario(cursor.getString(0), cursor.getString(1), cursor.getString(2),cursor.getString(3));

        return usuario;
    }

    void atualizarUsuario(Usuario usuario){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUNA_NOME, usuario.getNome());
        values.put(COLUNA_CPF, usuario.getCpf());
        values.put(COLUNA_DATNASC, usuario.getDataNasc());
        values.put(COLUNA_SEXO, usuario.getSexo());
        values.put(COLUNA_SENHA, usuario.getSenha());
        values.put(COLUNA_EMAIL, usuario.getEmail());
        values.put(COLUNA_TELEFONE, usuario.getTelefone());
        values.put(COLUNA_ATIVIDADE, usuario.getAtividade());

        db.update(TABELA_USUARIO, values, COLUNA_ID + " =?",
                new String[] {String.valueOf(usuario.getId())});
    }

    public List<Usuario> listarTodosUsuarios() {
        List<Usuario> listaUsuario = new ArrayList<Usuario>();
        String query = "SELECT * FROM " + TABELA_USUARIO;

        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()){
            do {
                Usuario usuario = new Usuario();
                usuario.setId(Integer.parseInt(c.getString(0)));
                usuario.setNome(c.getString(1));
                usuario.setCpf(c.getString(2));
                usuario.setDataNasc(c.getString(3));

                listaUsuario.add(usuario);
            }while (c.moveToNext());

        }

        return listaUsuario;
    }

}
