package com.example.benavent.banco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.benavent.banco.bd.MiBancoOperacional;
import com.example.benavent.banco.pojo.Cliente;
import com.example.benavent.banco.pojo.Cuenta;
import com.example.benavent.banco.pojo.Movimiento;

import java.util.ArrayList;
import java.util.List;

public class GlobalActivity extends AppCompatActivity {

    Cliente cliente;
    ArrayList<Movimiento> listaMovimientos;
    MiBancoOperacional mbo;

    ListView lista;
    ArrayAdapter<String> adaptador;
    List<String> saldo = new ArrayList<>();
    ArrayList<Cuenta> listaCuentas;
    float total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global);


        lista = (ListView)findViewById(R.id.listaGlobal);
        mbo = MiBancoOperacional.getInstance(this);
        cliente = (Cliente) getIntent().getExtras().getSerializable("cliente");


        listaCuentas = mbo.getCuentas(cliente);

        for(int i=0;i<listaCuentas.size();i++){
            total += listaCuentas.get(i).getSaldoActual();
            saldo.add("Cuenta: " + listaCuentas.get(i).getNumeroCuenta() + "\nsaldo: " + listaCuentas.get(i).getSaldoActual());


        }
        saldo.add("Saldo Total: " + total);

        adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, saldo);
        lista.setAdapter(adaptador);
    }
}
