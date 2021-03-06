package com.example.worldskills.colorapp.pantallas;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.worldskills.colorapp.R;
import com.example.worldskills.colorapp.baseDeDatos.Crud;
import com.example.worldskills.colorapp.entidades.ConfiguracionVo;

import java.util.ArrayList;

public class Configuracion extends AppCompatActivity {
    CheckBox tiempo;
    int intTime;
    EditText duracionPartida,numeroIntentos,tiempoPalabras;
    Button volver,cargarDefault,cargarPersonalizada,aplicar;
    ArrayList<ConfiguracionVo> listaConfiguracion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        aplicar=findViewById(R.id.aplicarId);
        cargarDefault=findViewById(R.id.cargarDefault);
        cargarPersonalizada=findViewById(R.id.cargarPersonalizada);
        listaConfiguracion=new ArrayList<>();
        tiempo=findViewById(R.id.siTiempo);
        duracionPartida=findViewById(R.id.duracionPartida);
        numeroIntentos=findViewById(R.id.numeroIntentos);
        tiempoPalabras=findViewById(R.id.tiempoPalabras);
        volver=findViewById(R.id.volver);

        //verificamos el estado del checkbox
        if(tiempo.isChecked()){
            intTime=1;
        }
        else intTime=0;
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //llamado a la base de datos para saber la configuracion anterior
        final Crud crud=new Crud(this,"colores",null,1);
        crud.consultarConfiguracion(this,listaConfiguracion);
        duracionPartida.setHint(listaConfiguracion.get(0).getTiempo());
        numeroIntentos.setHint(listaConfiguracion.get(0).getIntentos());
        tiempoPalabras.setHint(listaConfiguracion.get(0).getTiempoPalabra());
        cargarDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cambiar=new ContentValues();
                cambiar.put("cDefault","0");
                crud.modificarBd(Configuracion.this,"tb_configuracion","2",cambiar);
            }
        });
        cargarPersonalizada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cambiar=new ContentValues();
                cambiar.put("cDefault","1");
                crud.modificarBd(Configuracion.this,"tb_configuracion","2",cambiar);
            }
        });
        aplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues registro=new ContentValues();
                registro.put("intTime",intTime);
                registro.put("tiempo",duracionPartida.getText().toString());
                registro.put("intentos",numeroIntentos.getText().toString());
                registro.put("tiempoPalabra",tiempoPalabras.getText().toString());
                registro.put("cDefault","1");
                crud.modificarBd(Configuracion.this,"tb_configuracion","2",registro);
            }
        });
    }
}
