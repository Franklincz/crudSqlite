package com.example.semana10sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registro extends AppCompatActivity {


    private Button btnAgregar;
    private EditText txtPais;
    private EditText txtMoneda;
    private DBManager dbManager;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        setTitle("Gestion de divisas");


        txtPais = findViewById(R.id.txtpais);
        txtMoneda = findViewById(R.id.txtMoneda);


        btnAgregar= findViewById(R.id.btnArgegar);

        dbManager = new DBManager( this);

        dbManager.open();


        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String pais = txtPais.getText().toString();
                final String moneda = txtMoneda.getText().toString();



                dbManager.insert(pais , moneda);
                Intent main = new Intent(getApplicationContext(), ListadoActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);

            }
        });




    }
}