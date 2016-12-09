package com.example.benavent.banco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.benavent.banco.bd.MiBancoOperacional;
import com.example.benavent.banco.pojo.Cliente;
import com.example.benavent.banco.pojo.Cuenta;
import com.example.benavent.banco.pojo.Movimiento;

import java.util.ArrayList;
import java.util.List;

public class TodosMovimientosActivity extends AppCompatActivity {

    Cliente cliente;
    ArrayList<Movimiento> listaMovimientos;
    MiBancoOperacional mbo;

    ListView lista;
    ArrayAdapter<Movimiento> adaptador;
    List<Movimiento> movimientos = new ArrayList<>();
    ArrayList<Cuenta> listaCuentas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos_movimientos);

        lista = (ListView)findViewById(R.id.listaTodosMovimientos);
        mbo = MiBancoOperacional.getInstance(this);
        cliente = (Cliente) getIntent().getExtras().getSerializable("cliente");

        //listaMovimientos = mbo.getMovimientos(cliente);
        listaCuentas = mbo.getCuentas(cliente);

        for(int i=0;i<listaCuentas.size();i++){
            listaMovimientos = mbo.getMovimientos(listaCuentas.get(i));
            for(int j=0;j<listaMovimientos.size();j++){
                movimientos.add(listaMovimientos.get(j));
                Log.e(this.getComponentName().getClassName(), String.valueOf(listaMovimientos.get(j)));
            }

        }

        adaptador = new ArrayAdapter<Movimiento>(this,android.R.layout.simple_list_item_1, movimientos);
        lista.setAdapter(adaptador);
    }
}
