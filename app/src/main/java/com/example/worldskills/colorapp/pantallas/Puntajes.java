package com.example.worldskills.colorapp.pantallas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.worldskills.colorapp.R;
import com.example.worldskills.colorapp.baseDeDatos.Crud;

import java.util.ArrayList;

public class Puntajes extends AppCompatActivity {
    TextView puntaje1,puntaje2,puntaje3,puntaje4;
    Button volver;
    ArrayList<String> puntajes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntajes);
        puntajes=new ArrayList<>();
        puntaje1=findViewById(R.id.puntaje1Id);
        puntaje2=findViewById(R.id.puntaje2Id);
        puntaje3=findViewById(R.id.puntaje3Id);
        puntaje4=findViewById(R.id.puntaje4Id);
        volver=findViewById(R.id.volverId);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Crud crud=new Crud(this,"colores",null,1);
        crud.consultarPuntajes(this,puntajes);
        puntaje1.setText(puntajes.get(0));
        puntaje2.setText(puntajes.get(1));
        puntaje3.setText(puntajes.get(2));
        puntaje4.setText(puntajes.get(3));
    }
}
