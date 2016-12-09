package com.example.benavent.banco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.benavent.banco.bd.MiBancoOperacional;
import com.example.benavent.banco.pojo.Cliente;

public class LoginActivity extends AppCompatActivity {

    private EditText usuario;
    private EditText pass;
    MiBancoOperacional mbo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = (EditText)findViewById(R.id.txtUser);
        pass = (EditText)findViewById(R.id.txtPass);
    }

    public void getToMenu(View v) {

        mbo = MiBancoOperacional.getInstance(this);

        // Introducimos los datos como si fuera la pantalla inicial
        Log.e(this.getComponentName().getClassName(), "Creando el cliente a");
        Cliente a = new Cliente();
        a.setNif(String.valueOf(usuario.getText()));
        a.setClaveSeguridad(String.valueOf(pass.getText()));

        // logueamos al cliente
        a = mbo.login(a);

        if (a!=null){
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            intent.putExtra("user", String.valueOf(usuario.getText()));
            intent.putExtra("cliente", a);
            startActivity(intent);
        } else {
            Log.e(this.getComponentName().getClassName(), "datos incorrectos");
        }



    }

    public void getToMain(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
