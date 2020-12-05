package com.example.semana10sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListadoActivity extends AppCompatActivity {

    private DBManager dbManager;
    private ListView listView;
    private SimpleCursorAdapter adapter;
    final String[] from = new String[] { DatabaseHelper._ID,
            DatabaseHelper.PAIS, DatabaseHelper.MONEDA };
    final int[] to = new int[] { R.id.r_id, R.id.r_pais, R.id.r_moneda};
    private FloatingActionButton fbtAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_acivity);
        setTitle("Listado de Divisas");
       //aqui le paso el contexto
        dbManager = new DBManager(this);
       //
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        listView = findViewById(R.id.lsvPais);
        //listView.setEmptyView(findViewById(R.id.empty));

        adapter = new SimpleCursorAdapter(this, R.layout.activity_ver_registro, cursor, from, to, 0);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);

        // setOnItemClickListener For List Items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                TextView tvId = view.findViewById(R.id.r_id);
                TextView tvPais = view.findViewById(R.id.r_pais);
                TextView tvMoneda = view.findViewById(R.id.r_moneda);

                String id = tvId.getText().toString();
                String pais = tvPais.getText().toString();
                String moneda = tvMoneda.getText().toString();

                Intent intent = new Intent(getApplicationContext(), ModificaActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("pais", pais);
                intent.putExtra("moneda", moneda);
                Toast.makeText(ListadoActivity.this, "Has hecho cloick"+id, Toast.LENGTH_SHORT).show();
            startActivity(intent);
            }
        });

        fbtAgregar = findViewById(R.id.fbtAgregar);
        fbtAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Registro.class);
                startActivity(intent);
            }
        });
    }





}