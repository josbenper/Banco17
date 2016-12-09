package com.example.benavent.banco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.benavent.banco.bd.MiBancoOperacional;
import com.example.benavent.banco.pojo.Cliente;
import com.example.benavent.banco.pojo.Cuenta;

import java.util.ArrayList;
import java.util.List;

public class TransferenciaActivity extends AppCompatActivity {

    private Spinner cmbOpciones;
    MiBancoOperacional mbo;
    Cliente cliente;
    ArrayList<Cuenta> listaCuentas;
    List<Cuenta> cuentas = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transferencia);

        mbo = MiBancoOperacional.getInstance(this);
        cliente = (Cliente)getIntent().getExtras().getSerializable("cliente");

        listaCuentas = mbo.getCuentas(cliente);
        String datos = null;
//                new String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};

        for(int i=0;i<listaCuentas.size();i++){
            cuentas.add(listaCuentas.get(i));
            datos = listaCuentas.get(i).getNumeroCuenta();
            Log.e(this.getComponentName().getClassName(), listaCuentas.get(i).getNumeroCuenta());
        }



        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, Integer.parseInt(datos));


        cmbOpciones = (Spinner)findViewById(R.id.spinnerCuentaOrigen);

        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        cmbOpciones.setAdapter(adaptador);

    }
}
