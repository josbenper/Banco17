package com.example.benavent.banco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.benavent.banco.pojo.Cliente;

public class MenuActivity extends AppCompatActivity {
    private TextView userName;
    Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        String getUser = getIntent().getStringExtra("user");

        cliente = (Cliente)getIntent().getExtras().getSerializable("cliente");


        userName = (TextView)findViewById(R.id.txtNombre);
//        userName.setText(getUser);
        userName.setText(String.valueOf(cliente.getNombre()));

    }

    public void goToPass(View v) {
        String getUser = getIntent().getStringExtra("user");
        Intent activity = new Intent(getApplicationContext(), PassActivity.class);
        activity.putExtra("cliente", cliente);
        activity.putExtra("user", String.valueOf(String.valueOf(getUser)));
        startActivity(activity);
    }

    public void getToMain(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void goToCuentas(View v){
        Intent activity = new Intent(getApplicationContext(), CuentasActivity.class);
        activity.putExtra("cliente", cliente);
        startActivity(activity);

    }

    public void goToMovimiento(View v){
        Intent activity = new Intent(getApplicationContext(), TodosMovimientosActivity.class);
        activity.putExtra("cliente", cliente);
        startActivity(activity);
    }

    public void goToIngresos(View v){
        Intent activity = new Intent(getApplicationContext(), IngresosActivity.class);
        activity.putExtra("cliente", cliente);
        startActivity(activity);
    }

    public void goToGlobal(View v){
        Intent activity = new Intent(getApplicationContext(), GlobalActivity.class);
        activity.putExtra("cliente", cliente);
        startActivity(activity);
    }
}
