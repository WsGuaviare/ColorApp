package com.example.worldskills.colorapp.pantallas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.worldskills.colorapp.R;
import com.example.worldskills.colorapp.baseDeDatos.Crud;
import com.example.worldskills.colorapp.entidades.ConfiguracionVo;

import java.util.ArrayList;

public class Juego extends AppCompatActivity {
    TextView tiempo,intentId,palabrasDesplegadas,palabrasCorrectas,intentos,palabra;
    Button boton1,boton2,boton3,boton4;
    ImageView volver,pausar;
    ArrayList<ConfiguracionVo> listaConfiguracion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        listaConfiguracion=new ArrayList<>();
        tiempo=findViewById(R.id.timepoId);intentId=findViewById(R.id.intentId);palabrasDesplegadas=findViewById(R.id.palabrasDesplegadas);palabrasCorrectas=findViewById(R.id.palabrasCorrectas);intentos=findViewById(R.id.intentos);palabra=findViewById(R.id.palabra);
        boton1=findViewById(R.id.boton1);boton2=findViewById(R.id.boton2);boton3=findViewById(R.id.boton3);boton4=findViewById(R.id.boton4);volver=findViewById(R.id.volver);pausar=findViewById(R.id.pausar);
        Crud crud=new Crud(this,"colores",null,1);
        crud.consultarConfiguracion(this,listaConfiguracion);

    }
}
