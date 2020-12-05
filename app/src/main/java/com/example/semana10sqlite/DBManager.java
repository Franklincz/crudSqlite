package com.example.semana10sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.widget.Toast;

public class DBManager {

    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DBManager (Context c){

        context = c;



    }

    public DBManager open() throws SQLException {


        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;


    }

    public void  close(){

        dbHelper.close();

    }

    public void insert (String name , String desc ){

        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.PAIS, name);
        contentValue.put(DatabaseHelper.MONEDA , desc);
        /* Insertar la nueva fila
             insert(nombretabla ,que hacer si no hice ningun put ,
        */
        database.insert(DatabaseHelper.TABLE_NAME , null , contentValue);

    }


    public Cursor fetch (){

        String[] columns = new String[]{  DatabaseHelper._ID , DatabaseHelper.PAIS
        ,DatabaseHelper.MONEDA
        };

        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME , columns,null,null,null,null,null);

        if(cursor != null){

            cursor.moveToFirst();

        }

        Toast.makeText(context, "hast hechoo", Toast.LENGTH_SHORT).show();
        return cursor;
    }




    public int update (long _id , String name , String desc){


       /* ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.PAIS , name);
        contentValues.put(DatabaseHelper.MONEDA , desc);
        int i = database.update(DatabaseHelper.TABLE_NAME
        ,contentValues ,DatabaseHelper._ID+"="+_id , null);
*/

        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.PAIS,name);
        contentValue.put(DatabaseHelper.MONEDA,desc);
        int i = database.update(DatabaseHelper.TABLE_NAME
                , contentValue
                , DatabaseHelper._ID + " = " + _id
                , null);

        return i;
    }

 //para eliminar los datoosss
    public void delete (long _id){


        database.delete(DatabaseHelper.TABLE_NAME , DatabaseHelper._ID+"="+_id , null);


    }









}
