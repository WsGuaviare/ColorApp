package com.example.worldskills.colorapp.pantallas;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.worldskills.colorapp.R;
import com.example.worldskills.colorapp.baseDeDatos.Crud;
import com.example.worldskills.colorapp.entidades.ConfiguracionVo;

import java.util.ArrayList;
import java.util.Random;

public class Juego extends AppCompatActivity {
    int pausarClick=0;
    TextView tiempo,intentId,palabrasDesplegadas,palabrasCorrectas,intentos,palabra;
    Button boton1,boton2,boton3,boton4;
    ImageView volver,pausar;
    ArrayList<Button> botonIds;//este array contiene los id de los botones
    ArrayList<String> juego;
    ArrayList<ConfiguracionVo> listaConfiguracion;
    ArrayList<String> palabraColores;//este array contiene las palabras con su respectivo color
    ArrayList<String> tintaColores;//este array contiene los colores que vamos a utilizar
    String colorPalabra;//aca asignamos el color que queremos que lleve la palabra
    Handler handler=new Handler();

    //con este runnable le damos el numero de intentos
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            intentos.setText(String.valueOf(Integer.valueOf(intentos.getText().toString())-1));
            finalizar();
            handler.removeCallbacks(runnable);
            llenarListas();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        botonIds=new ArrayList<>();
        listaConfiguracion=new ArrayList<>();
        tiempo=findViewById(R.id.timepoId);intentId=findViewById(R.id.intentId);palabrasDesplegadas=findViewById(R.id.palabrasDesplegadas);palabrasCorrectas=findViewById(R.id.palabrasCorrectas);intentos=findViewById(R.id.intentos);palabra=findViewById(R.id.palabra);
        botonIds.add(boton1=findViewById(R.id.boton1));botonIds.add(boton2=findViewById(R.id.boton2));botonIds.add(boton3=findViewById(R.id.boton3));botonIds.add(boton4=findViewById(R.id.boton4));
        volver=findViewById(R.id.volver);pausar=findViewById(R.id.pausar);
        palabrasCorrectas.setText("0");
        palabrasDesplegadas.setText("0");
        intentos.setText("3");
        tiempo.setText("00:00");

        //pausamos la pantalla de juego
        pausar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pausarClick++;
                if(pausarClick==1 || pausarClick==3) {
                    handler.removeCallbacks(runnable);
                    for (int i = 0; i < 4; i++) {
                        botonIds.get(i).setEnabled(false);
                        pausar.setImageResource(R.drawable.reanudar);
                    }
                }
                else if(pausarClick==2 || pausarClick==4){
                    for (int i = 0; i < 4; i++) {
                        botonIds.get(i).setEnabled(true);
                        pausar.setImageResource(R.drawable.pausar);
                    }
                    llenarListas();
                }
            }
        });
        //configuracion
        Crud crud=new Crud(this,"colores",null,1);
        crud.consultarConfiguracion(this,listaConfiguracion);
        llenarListas();
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    //llanamos los arrays con su respectiva informacion
    private void llenarListas(){
        palabraColores=new ArrayList<>();
        tintaColores=new ArrayList<>();
        juego=new ArrayList<>();
        palabraColores.add("amarillo");palabraColores.add("azul");palabraColores.add("rojo");palabraColores.add("verde");
        tintaColores.add("#ffff00");tintaColores.add("#0000ff");tintaColores.add("#ff0000");tintaColores.add("#00ff00");
        for(int i=0;i<4;i++){
            juego.add("0");
        }
        palabrasDesplegadas.setText(String.valueOf(Integer.valueOf(palabrasDesplegadas.getText().toString())+1));
        handler.postDelayed(runnable,3000);
        generarPalabra();
    }

    //generamos la palabra de manera aleatoria
    private void generarPalabra(){
        Random rnd=new Random(System.currentTimeMillis());
        int palabraRandom=rnd.nextInt(4);
        int colorRandom=rnd.nextInt(4);
        while(palabraRandom==colorRandom){
            palabraRandom=rnd.nextInt(4);
            colorRandom=rnd.nextInt(4);
        }
        colorPalabra=tintaColores.get(colorRandom);
        palabra.setText(palabraColores.get(palabraRandom));
        palabra.setTextColor(Color.parseColor(tintaColores.get(colorRandom)));
        generarBotones();
    }

    //generamos los botones de manera aleatoria
    private void generarBotones(){
        Random rnd=new Random(System.currentTimeMillis());
        for(int i=0;i<4;i++) {
            int botonRandom = rnd.nextInt(4);
            while (!juego.get(botonRandom).equals("0")){
                botonRandom=rnd.nextInt(4);
            }
            juego.set(botonRandom,tintaColores.get(i));
            botonIds.get(botonRandom).setBackgroundColor(Color.parseColor(tintaColores.get(i)));
        }
    }

    //proceso para sumar puntajes, verificar intentos, etc...
    public void logica(View view){
        for(int i=0;i<4;i++){
            if(findViewById(view.getId()).getId()==botonIds.get(i).getId()){
                if(juego.get(i).equals(colorPalabra)){
                    palabrasCorrectas.setText(String.valueOf(Integer.valueOf(palabrasCorrectas.getText().toString())+1));
                }
                else {
                    intentos.setText(String.valueOf(Integer.valueOf(intentos.getText().toString()) - 1));
                    finalizar();
                }
                handler.removeCallbacks(runnable);
                break;
            }
        }
        llenarListas();
    }

    //verificamos si ya perdio
    public void finalizar(){
        if(intentos.getText().toString().equals("0")){
            Intent intent=new Intent(Juego.this,Resultados.class);
            intent.putExtra("palabrasCorrectas",palabrasCorrectas.getText().toString());
            intent.putExtra("palabrasDesplegadas",palabrasDesplegadas.getText().toString());
            //insertar tiempo
            intent.putExtra("tiempo","01:15");
            startActivity(intent);
            finish();
        }
    }

    //inicializamos el temporisador, cuando el usuario lo activa
    public void temporizador(){
        CountDownTimer iniciarTemporizador = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long l) {
                long minutos = l / 1000;
                long segundos = minutos % 60;
                String minutosMostrados = String.format("%02d",minutos);
                String segundosMostrados = String.format("%02d",segundos);
                tiempo.setText("" + minutosMostrados + ":" + segundosMostrados);

            }

            @Override
            public void onFinish() {
                tiempo.setText("Paila!");
            }
        }.start();
    }
}
