package app.modelo.meusclientes.controller;
/**
 * Classe destinada ao modelo objeto relacional
 */

import android.content.ContentValues;
import android.content.Context;

import java.util.List;

import app.modelo.meusclientes.datamodel.ClienteDataModel;
import app.modelo.meusclientes.datasource.AppDataBase;
import app.modelo.meusclientes.model.Cliente;


public class ClienteController extends AppDataBase implements ICrud<Cliente> {

    ContentValues values;

    public ClienteController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(Cliente obj) {

        values = new ContentValues();
        //Key, Value
        values.put(ClienteDataModel.NOME, obj.getName());
        values.put(ClienteDataModel.EMAIL, obj.getEmail());
        values.put(ClienteDataModel.PHONENUMBER, obj.getPhoneNumber());
        values.put(ClienteDataModel.ZIPCODE, obj.getZipCode());
        values.put(ClienteDataModel.PUBLICPLACES, obj.getPublicPlace());
        values.put(ClienteDataModel.ADDRNUMBER, obj.getAddrNumber());
        values.put(ClienteDataModel.DISTRICTY, obj.getDistrict());
        values.put(ClienteDataModel.CITY, obj.getCity());
        values.put(ClienteDataModel.STATE, obj.getState());
        values.put(ClienteDataModel.USE_TERMS, obj.isUseTerms());

        return insert(ClienteDataModel.TABELA, values);
    }

    @Override
    public boolean alter(Cliente obj) {

        values = new ContentValues();
        //Key, Value
        values.put(ClienteDataModel.ID, obj.getId());
        values.put(ClienteDataModel.NOME, obj.getName());
        values.put(ClienteDataModel.EMAIL, obj.getEmail());

        return update(ClienteDataModel.TABELA, values);
    }

    @Override
    public boolean deletar(int id) {
        return deleteById(ClienteDataModel.TABELA, id);
    }

    @Override
    public List<Cliente> listar() {
        return getAllCliente(ClienteDataModel.TABELA);
    }

}
