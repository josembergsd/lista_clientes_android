package app.modelo.meusclientes.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import app.modelo.meusclientes.api.AppUtil;
import app.modelo.meusclientes.datamodel.ClienteDataModel;
import app.modelo.meusclientes.model.Cliente;

public class AppDataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "MeusClientes.sqlite";
    public static final int DB_VERSION = 1;

    SQLiteDatabase db;

    //Escrita do método foi alterada retirando o name, factory e versions
    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.d(AppUtil.TAG, "AppDataBase: Criando banco de dados");
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ClienteDataModel.createTable()); //Cria a tabela no banco de dados
        Log.i(AppUtil.TAG, "onCreate: Tabela Cliente criada... " + ClienteDataModel.createTable());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * Metodo para inserção de dados no banco de dados
     *
     * @param nomeTabela
     * @param dados
     * @return boolean
     */
    public boolean insert(String nomeTabela, ContentValues dados) {
        db = getWritableDatabase();
        boolean retorno = false;
        try {
            retorno = db.insert(nomeTabela, null, dados) > 0;
        } catch (Exception e) {
            Log.i(AppUtil.TAG, "insert: Erro ao inserir dados no banco... " + e.getMessage());
        }
        return retorno;
    }

    /**
     * Método para deletar registro no banco de dados
     *
     * @param table
     * @param id
     * @return boolean
     */
    public boolean deleteById(String table, int id) {
        db = getWritableDatabase();
        boolean retorno = false;
        try {
            retorno = db.delete(table, "id = ?", new String[]{String.valueOf(id)}) > 0;

        } catch (Exception e) {
            Log.i(AppUtil.TAG, "delete: Erro ao deletar registro ou registro inesistente... " + e.getMessage());
        }

        return retorno;
    }

    /**
     * Método para atualizar registro no banco de daos
     *
     * @param table
     * @param values
     * @return boolean
     */
    public boolean update(String table, ContentValues values) {
        db = getWritableDatabase();
        boolean retorno = false;
        try {
            retorno = db.update(table, values, "id = ?", new String[]{String.valueOf(values.get("id"))}) > 0;
        } catch (Exception e) {
            Log.i(AppUtil.TAG, "update: Erro ao atualizar registro ou registro inesistente... " + e.getMessage());
        }

        return retorno;
    }

    public List<Cliente> getAllCliente(String tabela) {
        db = getWritableDatabase();
        Cliente obj;
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM " + tabela;
        Cursor cursor; //recebe dados da consulta no bd
        cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                obj = new Cliente();
                obj.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.ID)));
                obj.setName(cursor.getString(cursor.getColumnIndex(ClienteDataModel.NOME)));
                obj.setEmail(cursor.getString(cursor.getColumnIndex(ClienteDataModel.EMAIL)));
                clientes.add(obj);
            }while(cursor.moveToNext());
        }
        return clientes;
    }

}