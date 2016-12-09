package com.example.benavent.banco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.benavent.banco.bd.MiBancoOperacional;
import com.example.benavent.banco.pojo.Cuenta;
import com.example.benavent.banco.pojo.Movimiento;

import java.util.ArrayList;
import java.util.List;

public class MovimientosActivity extends AppCompatActivity {

    Cuenta cuenta;
    ArrayList<Movimiento> listaMovimientos;
    MiBancoOperacional mbo;

    ListView lista;
    ArrayAdapter<Movimiento> adaptador;
    List<Movimiento> movimientos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimientos);

        lista = (ListView)findViewById(R.id.listaMovimientos);
        mbo = MiBancoOperacional.getInstance(this);
        cuenta = (Cuenta)getIntent().getExtras().getSerializable("cuenta");
        listaMovimientos = mbo.getMovimientos(cuenta);


        for(int i=0;i<listaMovimientos.size();i++){
            movimientos.add(listaMovimientos.get(i));
            Log.e(this.getComponentName().getClassName(), String.valueOf(listaMovimientos.get(i)));
        }
        adaptador = new ArrayAdapter<Movimiento>(this,android.R.layout.simple_list_item_1, movimientos);
        lista.setAdapter(adaptador);

    }
}
