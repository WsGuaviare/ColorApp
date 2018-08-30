package com.example.worldskills.colorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.worldskills.colorapp.baseDeDatos.Crud;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Crud crud=new Crud(this,"colores",null,1);
        crud.iniciarBd(this);
    }
}
