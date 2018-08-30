package com.example.worldskills.colorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.worldskills.colorapp.baseDeDatos.Crud;
import com.example.worldskills.colorapp.pantallas.Configuracion;
import com.example.worldskills.colorapp.pantallas.Juego;
import com.example.worldskills.colorapp.pantallas.Puntajes;

public class Inicio extends AppCompatActivity {
    ImageView iniciarId,puntajesId,configuracionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Crud crud=new Crud(this,"colores",null,1);
        crud.iniciarBd(this);
        iniciarId=findViewById(R.id.iniciarId);
        puntajesId=findViewById(R.id.puntajesId);
        configuracionId=findViewById(R.id.configuracionId);
        iniciarId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Inicio.this, Juego.class);
                startActivity(intent);
            }
        });
        puntajesId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Inicio.this, Puntajes.class);
                startActivity(intent);
            }
        });
        configuracionId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Inicio.this, Configuracion.class);
                startActivity(intent);
            }
        });
    }
}
