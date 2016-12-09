package com.example.benavent.banco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.benavent.banco.bd.MiBancoOperacional;
import com.example.benavent.banco.pojo.Cliente;
import com.example.benavent.banco.pojo.Cuenta;

import java.util.ArrayList;
import java.util.List;

public class CuentasActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    Cliente cliente;
    TextView idCuenta;
    ArrayList<Cuenta> listaCuentas;
    MiBancoOperacional mbo;

    ListView lista;
    ArrayAdapter<Cuenta> adaptador;
//    String[] cuentas = new String[100];
    List<Cuenta> cuentas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuentas);

        lista = (ListView)findViewById(R.id.listaCuentas);

        mbo = MiBancoOperacional.getInstance(this);
        cliente = (Cliente)getIntent().getExtras().getSerializable("cliente");

        listaCuentas = mbo.getCuentas(cliente);

        for(int i=0;i<listaCuentas.size();i++){
            cuentas.add(listaCuentas.get(i));
            Log.e(this.getComponentName().getClassName(), listaCuentas.get(i).getNumeroCuenta());
        }


        adaptador = new ArrayAdapter<Cuenta>(this,android.R.layout.simple_list_item_1, cuentas);

        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Cuenta cuentaActual = adaptador.getItem(position);
        String msg = "Elegiste la cuenta:\n" + cuentaActual.getId();
        Toast.makeText(this,msg, Toast.LENGTH_LONG).show();

        Intent activity = new Intent(getApplicationContext(), MovimientosActivity.class);
        activity.putExtra("cuenta", cuentaActual);
        startActivity(activity);

    }
}
