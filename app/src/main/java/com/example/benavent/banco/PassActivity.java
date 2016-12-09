package com.example.benavent.banco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.benavent.banco.bd.MiBancoOperacional;
import com.example.benavent.banco.pojo.Cliente;

public class PassActivity extends AppCompatActivity {

    private TextView userName;
    Cliente cliente;
    MiBancoOperacional mbo ;
    private EditText pass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass);

        String getUser = getIntent().getStringExtra("user");
        cliente = (Cliente)getIntent().getExtras().getSerializable("cliente");
        userName = (TextView)findViewById(R.id.txtUser);


        userName.setText(cliente.getNombre());

        pass = (EditText)findViewById(R.id.editText);

    }

    public void goToLogin(View v) {
        Intent Login = new Intent(getApplicationContext(), MenuActivity.class);
        Login.putExtra("cliente", cliente);
        startActivity(Login);
    }

    public void changePass(View v){
        mbo = MiBancoOperacional.getInstance(this);
        // Cambiamos la password
        Log.e(this.getComponentName().getClassName(), "Cambiamos la password del cliente");


        cliente.setClaveSeguridad(String.valueOf(pass.getText()));
        int p = mbo.changePassword(cliente);
        Log.e(this.getComponentName().getClassName(), "Hemos obtenido tras cambiar un " + String.valueOf(p));
        if (p==1){
            Log.e(this.getComponentName().getClassName(), "Contraseña cambiada con exito");
            Intent Login = new Intent(getApplicationContext(), MenuActivity.class);
            Login.putExtra("cliente", cliente);

            startActivity(Login);
        } else {
            Log.e(this.getComponentName().getClassName(), "ERROR: Contraseña no cambiada");

        }

    }
}
