package com.example.worldskills.colorapp.pantallas;

import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.worldskills.colorapp.R;

public class Resultados extends AppCompatActivity {
    TextView palabrasDesplegadas,palabrasCorrectas,tiempo,porcentaje;
    Button volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        palabrasCorrectas=findViewById(R.id.palabrasCorrectasId);
        palabrasDesplegadas=findViewById(R.id.palabrasDesplegadasId);
        tiempo=findViewById(R.id.timepoId);
        porcentaje=findViewById(R.id.porcentajeId);
    }
}
