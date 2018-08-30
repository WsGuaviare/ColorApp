package com.example.worldskills.colorapp.pantallas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.worldskills.colorapp.R;
import com.example.worldskills.colorapp.baseDeDatos.Crud;

public class Configuracion extends AppCompatActivity {
    CheckBox tiempo;
    EditText duracionPartida,numeroIntentos,tiempoPalabras;
    Button volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        tiempo=findViewById(R.id.siTiempo);
        duracionPartida=findViewById(R.id.duracionPartida);
        numeroIntentos=findViewById(R.id.numeroIntentos);
        tiempoPalabras=findViewById(R.id.tiempoPalabras);
        volver=findViewById(R.id.volver);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Crud crud=new Crud()
    }
}
