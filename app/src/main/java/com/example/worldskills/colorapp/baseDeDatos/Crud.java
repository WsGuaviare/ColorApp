package com.example.worldskills.colorapp.baseDeDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.worldskills.colorapp.entidades.ConfiguracionVo;

import java.util.ArrayList;

public class Crud extends SQLiteOpenHelper{
    public Crud(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tb_puntajes(id integer primary key autoincrement,puntaje integer)");
        db.execSQL("create table tb_configuracion(id integer primary key autoincrement,intTime integer,tiempo integer,intentos integer,tiempoPalabra integer,cDefault integer)");
        for(int i=0;i<2;i++) {
            ContentValues registro1 = new ContentValues();
            registro1.put("intTime","0");
            registro1.put("tiempo","0");
            registro1.put("intentos","3");
            registro1.put("tiempoPalabra","3000");
            if(i==1) {
                registro1.put("cDefault", 1);
            }
            else {
                registro1.put("cDefault", "0");
            }
            db.insert("tb_configuracion",null,registro1);
        }
        for(int i=0;i<4;i++){
            ContentValues registro=new ContentValues();
            registro.put("puntaje","0");
            db.insert("tb_puntaje",null,registro);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists tb_puntaje");
        db.execSQL("drop table if exists tb_configuracion");
        db.execSQL("create table tb_puntajes(id integer primary key autoincrement,puntaje integer)");
        db.execSQL("create table tb_configuracion(id integer primary key autoincrement,intTime integer,tiempo integer,intentos integer,tiempoPalabra integer,cDefault integer)");

    }
    public void iniciarBd(Context context){
        Crud crud=new Crud(context,"colores",null,1);
        SQLiteDatabase db=crud.getWritableDatabase();
    }
    ArrayList<String> listaPuntajes;
    public void consultarPuntajes(Context context, ArrayList<String> listaPuntajes){
        this.listaPuntajes=listaPuntajes;
        Crud crud=new Crud(context,"colores",null,1);
        SQLiteDatabase db=crud.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from tb_puntaje",null);
        while (cursor.moveToNext()){
            listaPuntajes.add(cursor.getString(1));
        }
        cursor.close();

    }
    ArrayList<ConfiguracionVo> listaConfiguracion;
    public void consultarConfiguracion(Context context,ArrayList<ConfiguracionVo> listaConfiguracion){
        this.listaConfiguracion=listaConfiguracion;
        Crud crud=new Crud(context,"colores",null,1);
        SQLiteDatabase db=crud.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from tb_puntaje",null);
        while (cursor.moveToNext()){
            listaConfiguracion.add(new ConfiguracionVo(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5)));
        }
        cursor.close();

    }
    public void modificarBd(Context context,String table,String id,ContentValues registro){
        Crud crud=new Crud(context,"colores",null,1);
        SQLiteDatabase db=crud.getWritableDatabase();
        db.update(table,registro,"id="+id,null);
    }
}
