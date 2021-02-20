package app.modelo.meusclientes.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import app.modelo.meusclientes.R;
import app.modelo.meusclientes.api.AppUtil;
import app.modelo.meusclientes.controller.ClienteController;
import app.modelo.meusclientes.model.Cliente;


public class AddClienteFragmento extends Fragment {

    View view;
    TextView txtTitle;
    EditText edFullName;
    EditText edPhone;
    EditText edEmail;
    EditText edZipCode;
    EditText edPublicPlace;
    EditText edAddrNumber;
    EditText edDistricty;
    EditText edCity;
    EditText edState;
    CheckBox chkUseTerms;
    Button btnCancelar;
    Button btnSave;

    Cliente novoCliente;
    ClienteController clienteController;

    public AddClienteFragmento() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_addcliente, container, false);

       /* TextView txtTitulo = view.findViewById(R.id.txtTitulo);

        txtTitulo.setTextColor(ColorStateList.valueOf(Color.WHITE));*/

        initLayoutComponent();
        listenToEventButton();
        return view;
    }

    /**
     * Inicializar os componentes da tela/layout
     * para adicionar os clientes
     */
    private void initLayoutComponent() {
                    //forma de usar com fragmento
        txtTitle = view.findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.titulo_add_cliente);

        edFullName = view.findViewById(R.id.edFullName);
        edPhone = view.findViewById(R.id.edPhone);
        edEmail = view.findViewById(R.id.edEmail);
        edZipCode = view.findViewById(R.id.edZipCode);
        edPublicPlace = view.findViewById(R.id.edPublicPlaces);
        edAddrNumber = view.findViewById(R.id.edAddrNumber);
        edDistricty = view.findViewById(R.id.edDistricty);
        edCity = view.findViewById(R.id.edCity);
        edState = view.findViewById(R.id.edState);

        chkUseTerms = view.findViewById(R.id.chkUseTerms);

        btnCancelar = view.findViewById(R.id.btnCancelar);
        btnSave = view.findViewById(R.id.btnSave);

        novoCliente = new Cliente();
        clienteController = new ClienteController(getContext());
    }

    private void listenToEventButton() {
        btnCancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                boolean isDadosOK = true;
                if(TextUtils.isEmpty(edFullName.getText())){
                    isDadosOK = isEmptyField(edFullName);
                }
                if(TextUtils.isEmpty(edPhone.getText())){
                    isDadosOK = isEmptyField(edPhone);
                }
                if(TextUtils.isEmpty(edZipCode.getText())){
                    isDadosOK = isEmptyField(edZipCode);
                }
                if(TextUtils.isEmpty(edPublicPlace.getText())){
                    isDadosOK = isEmptyField(edPublicPlace);
                }
                if(TextUtils.isEmpty(edAddrNumber.getText())){
                    isDadosOK = isEmptyField(edAddrNumber);
                }
                if(TextUtils.isEmpty(edDistricty.getText())){
                    isDadosOK = isEmptyField(edDistricty);
                }
                if(TextUtils.isEmpty(edCity.getText())){
                    isDadosOK = isEmptyField(edCity);
                }
                if(TextUtils.isEmpty(edState.getText())){
                    isDadosOK = isEmptyField(edState);
                }
              /* if(chkUseTerms.isChecked()){
                   isDadosOK = false;
                   Toast.makeText(getContext(), "É obrigatório aceitar os termos de uso", Toast.LENGTH_LONG).show();
                   chkUseTerms.requestFocus();
               }*/

                if(isDadosOK) {
                    //Popular cliente
                    novoCliente.setName(edFullName.getText().toString());
                    novoCliente.setEmail(edEmail.getText().toString());
                    novoCliente.setPhoneNumber(edPhone.getText().toString());

                    novoCliente.setZipCode(Integer.parseInt(edZipCode.getText().toString()));

                    novoCliente.setPublicPlace(edPublicPlace.getText().toString());
                    novoCliente.setAddrNumber(edAddrNumber.getText().toString());
                    novoCliente.setDistrict(edDistricty.getText().toString());
                    novoCliente.setCity(edCity.getText().toString());
                    novoCliente.setState(edState.getText().toString());

                    novoCliente.setUseTerms(chkUseTerms.isChecked());

                    clienteController.incluir(novoCliente);
                    Log.i("log_add_cliente", "Dados inseridos");
                }else{

                    Log.i("log_add_cliente", "Dados incorretos ou em branco");
                }
            }
        });
    }

    private boolean isEmptyField(EditText edField) {
        boolean isDadosOK;
        isDadosOK = false;
        edField.setError("O campo " + edField.getHint() +"não pode ser nulo...");
        edField.requestFocus();
        return isDadosOK;
    }
}
