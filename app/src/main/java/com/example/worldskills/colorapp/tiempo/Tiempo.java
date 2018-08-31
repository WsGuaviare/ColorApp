package com.example.worldskills.colorapp.tiempo;

import android.os.SystemClock;
import android.widget.Chronometer;

public class Tiempo {
    Boolean running = false;//variable para saber si el chronometro esta iniciado
    long detenerse;// detenemos el chronometro

    //iniciamos el chronometro
    public void iniciarChronometro(Chronometer chronometro){
        if (running){
            chronometro.setBase(SystemClock.elapsedRealtime() - detenerse);
            chronometro.start();
            running=true;
        }
    }

    //pausamos el chronometro
    public void pausarChronometro(Chronometer chronometro){
        if (!running){
            chronometro.stop();
            detenerse = SystemClock.elapsedRealtime() - chronometro.getBase();
            running = false;
        }
    }

    //reiniciamos el chronometro
    public void reiniciarChronometro(Chronometer chronometro){
        chronometro.setBase(SystemClock.elapsedRealtime());
        detenerse = 0;
        chronometro.stop();
    }
}
