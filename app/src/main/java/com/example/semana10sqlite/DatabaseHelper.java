package com.example.semana10sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

 // name table
    public static  final String TABLE_NAME="PAISES";


  // table columns
    public static final String _ID ="_id";
    public static final String PAIS ="pais";
    public static final String MONEDA="moneda";
// name data base
    static  final String DB_NAME ="MOVILES.DB";
    //database version
    static final int DB_VERSION=1;
//para crear la  instruccion o scipt que va a crear la tabla
    private static  final String CREATE_TABLE=
        "create table "+TABLE_NAME +"("+_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +PAIS +"TEXT NOT NULL,"+MONEDA+"TEXT );";




    public DatabaseHelper(Context context){
        super(context , DB_NAME ,null, DB_VERSION);


    }











    // ejecutamos la sentencia que crea la  tabla
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);

    }

    @Override

//si la version de la base de datos se incremena , posteriormente de haber creado la BD , se llama a este metodo
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
          db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
          onCreate(db);
    }
}
