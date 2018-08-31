package com.example.worldskills.colorapp.pantallas;

import android.content.ContentValues;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.worldskills.colorapp.R;
import com.example.worldskills.colorapp.baseDeDatos.Crud;

import java.util.ArrayList;

public class Resultados extends AppCompatActivity {
    TextView palabrasDesplegadas,palabrasCorrectas,tiempo,porcentaje;
    String palabrasDesplegadasInt,palabrasCorrectasInt,tiempoInt;
    Button volver;
    ArrayList<String> listaPuntajes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        listaPuntajes=new ArrayList<>();
        palabrasCorrectas=findViewById(R.id.palabrasCorrectasId);
        palabrasDesplegadas=findViewById(R.id.palabrasDesplegadasId);
        tiempo=findViewById(R.id.tiempoJugadoId);
        porcentaje=findViewById(R.id.porcentajeId);
        volver=findViewById(R.id.volver);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        palabrasDesplegadasInt=getIntent().getStringExtra("palabrasDesplegadas");
        palabrasCorrectasInt=getIntent().getStringExtra("palabrasCorrectas");
        tiempoInt=getIntent().getStringExtra("tiempo");
        palabrasCorrectas.setText(palabrasCorrectasInt);
        palabrasDesplegadas.setText(palabrasDesplegadasInt);
        tiempo.setText(tiempoInt);
        porcentaje.setText(String.valueOf((Integer.valueOf(palabrasCorrectasInt)*100)/Integer.valueOf(palabrasDesplegadasInt))+"%");

        //llamamos al crud para realizar una consulta
        Crud crud=new Crud(this,"colores",null,1);
        crud.consultarPuntajes(this,listaPuntajes);

        //traemos la informacion para mostrarsela al usuario en la pantalla resultado
        for(int i=0;i<4;i++){
            if(Integer.valueOf(palabrasCorrectasInt)>=Integer.valueOf(listaPuntajes.get(i))){
                ContentValues registro=new ContentValues();
                registro.put("puntaje",palabrasCorrectasInt);
                for (int j=i;j<3;j++){
                    ContentValues registro1=new ContentValues();
                    registro1.put("puntaje",listaPuntajes.get(j));
                    crud.modificarBd(this,"tb_puntaje",String.valueOf(j+2),registro1);
                }
                crud.modificarBd(this,"tb_puntaje",String.valueOf(i+1),registro);
                break;
            }
        }

    }
}
