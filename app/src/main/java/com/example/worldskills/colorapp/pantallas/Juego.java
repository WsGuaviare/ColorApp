package com.example.worldskills.colorapp.pantallas;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.worldskills.colorapp.R;
import com.example.worldskills.colorapp.baseDeDatos.Crud;
import com.example.worldskills.colorapp.entidades.ConfiguracionVo;

import java.util.ArrayList;
import java.util.Random;

public class Juego extends AppCompatActivity {
    TextView tiempo,intentId,palabrasDesplegadas,palabrasCorrectas,intentos,palabra;
    Button boton1,boton2,boton3,boton4;
    ImageView volver,pausar;
    ArrayList<Button> botonIds;
    ArrayList<Integer> juego;
    ArrayList<ConfiguracionVo> listaConfiguracion;
    ArrayList<String> palabraColores;
    ArrayList<String> tintaColores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        botonIds=new ArrayList<>();
        listaConfiguracion=new ArrayList<>();
        palabraColores=new ArrayList<>();
        tintaColores=new ArrayList<>();
        tiempo=findViewById(R.id.timepoId);intentId=findViewById(R.id.intentId);palabrasDesplegadas=findViewById(R.id.palabrasDesplegadas);palabrasCorrectas=findViewById(R.id.palabrasCorrectas);intentos=findViewById(R.id.intentos);palabra=findViewById(R.id.palabra);
        botonIds.add(boton1=findViewById(R.id.boton1));botonIds.add(boton2=findViewById(R.id.boton2));botonIds.add(boton3=findViewById(R.id.boton3));botonIds.add(boton4=findViewById(R.id.boton4));
        volver=findViewById(R.id.volver);pausar=findViewById(R.id.pausar);
        Crud crud=new Crud(this,"colores",null,1);
        crud.consultarConfiguracion(this,listaConfiguracion);
        llenarListas();
        generarPalabra();


    }
    private void llenarListas(){
        palabraColores.add("amarillo");palabraColores.add("azul");palabraColores.add("rojo");palabraColores.add("verde");
        tintaColores.add("#ffff00");tintaColores.add("#0000ff");tintaColores.add("#ff0000");tintaColores.add("#00ff00");
    }
    private void generarPalabra(){
        Random rnd=new Random(SystemClock.currentThreadTimeMillis());
        int palabraRandom=rnd.nextInt(3);
        int colorRandom=rnd.nextInt(3);
        while(palabraRandom==colorRandom){
            palabraRandom=rnd.nextInt(3);
            colorRandom=rnd.nextInt(3);
        }
        palabra.setText(palabraColores.get(palabraRandom));
        palabra.setTextColor(Color.parseColor(tintaColores.get(colorRandom)));
    }
    private void generarBotones(){
        Random rnd=new Random(SystemClock.currentThreadTimeMillis());
        for(int i=0;i<4;i++) {
            int botonRandom = rnd.nextInt(3);
        }
    }
}
