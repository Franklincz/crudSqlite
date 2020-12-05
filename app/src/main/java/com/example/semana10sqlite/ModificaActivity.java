package com.example.semana10sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ModificaActivity extends AppCompatActivity {

    private EditText txtMPais;
    private EditText txtMMoneda;
    private Button btnActualizar , btnEliminar;
    private long _id;
    private DBManager dbManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifica);

        setTitle("Modificar divisas");


        dbManager= new DBManager( this);
        dbManager.open();


        txtMPais =(EditText) findViewById(R.id.txtMPais);
        txtMMoneda=(EditText)findViewById(R.id.txtMMoneda);


        btnActualizar = (Button) findViewById(R.id.btnActualizar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);


        Intent intent = getIntent();

        String id = intent.getStringExtra("id");

        String pais = intent.getStringExtra("pais");
        String moneda = intent.getStringExtra("moneda");

        _id = Long.parseLong(id);

        txtMPais.setText(pais);
        txtMMoneda.setText(moneda);


  btnActualizar.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          String mPais = txtMPais.getText().toString();
          String mMoneda = txtMMoneda.getText().toString();

          dbManager.update(_id ,mPais,mMoneda);
          returnHome();
          Toast.makeText(ModificaActivity.this, "Se ha modificado el registro", Toast.LENGTH_SHORT).show();

      }
  });


   btnEliminar.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           dbManager.delete(_id);
           returnHome();
           Toast.makeText(ModificaActivity.this, "Se ha eliminado el registro", Toast.LENGTH_SHORT).show();
       }
   });










    }


    public void returnHome(){

        Intent home_intent = new Intent (getApplicationContext(), ListadoActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


        startActivity(home_intent);


    }

}