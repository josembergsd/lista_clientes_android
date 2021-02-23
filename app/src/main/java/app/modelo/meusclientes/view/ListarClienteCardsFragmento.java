package app.modelo.meusclientes.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.modelo.meusclientes.R;
import app.modelo.meusclientes.controller.ClienteController;
import app.modelo.meusclientes.model.Cliente;


public class ListarClienteCardsFragmento extends Fragment {

    View view;
    EditText edFindByName;
    ListView listView;
    List<Cliente> clienteList;
    List<String> clientes;

    ClienteController clienteController;
    Cliente objCliente;

    ArrayAdapter<String> clienteAdapter;
    ArrayList<HashMap<String, String>> clienteFiltro;

    public ListarClienteCardsFragmento() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragmento_listar_clientes_cards, container, false);

        TextView txtTitulo = view.findViewById(R.id.txtTitulo);

        txtTitulo.setText(R.string.fragmento_listar_cliente_cards);

        txtTitulo.setTextColor(ColorStateList.valueOf(Color.RED));

        //Método temporário
        clienteController = new ClienteController(getContext());
        clienteList = clienteController.listar();
        clientes = clienteController.generateClienteListToListView();
        listView = (ListView) view.findViewById(R.id.listView);
        edFindByName = view.findViewById(R.id.edFindByName);

        //TODO: Implemntar regra de negócio da controladora da classe cliente

        clienteAdapter = new ArrayAdapter<>(getContext(), R.layout.lista_cliente_item, R.id.txtItemList, clientes);
        listView.setAdapter(clienteAdapter);

        edFindByName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence filtro, int start, int count, int after) {
                ListarClienteCardsFragmento.this.clienteAdapter.getFilter().filter(filtro);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;
    }


}
