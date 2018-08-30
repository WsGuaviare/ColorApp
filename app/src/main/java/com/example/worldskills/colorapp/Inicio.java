package com.example.worldskills.colorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.worldskills.colorapp.baseDeDatos.Crud;
import com.example.worldskills.colorapp.pantallas.Juego;

public class Inicio extends AppCompatActivity {
    ImageView iniciarId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Crud crud=new Crud(this,"colores",null,1);
        crud.iniciarBd(this);
        iniciarId=findViewById(R.id.iniciarId);
        iniciarId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Inicio.this, Juego.class);
                startActivity(intent);
            }
        });
    }
}
