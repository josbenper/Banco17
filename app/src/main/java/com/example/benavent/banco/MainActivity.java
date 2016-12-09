package com.example.benavent.banco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.benavent.banco.bd.MiBancoOperacional;
import com.example.benavent.banco.pojo.Cliente;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToLogin(View v) {



        Intent Login = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(Login);
    }
}
