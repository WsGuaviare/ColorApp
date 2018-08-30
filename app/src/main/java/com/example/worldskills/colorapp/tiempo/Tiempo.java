package com.example.worldskills.colorapp.tiempo;

import android.os.SystemClock;
import android.widget.Chronometer;

public class Tiempo {
    Boolean running = false;
    long detenerse;

    public void iniciarChronometro(Chronometer chronometro){
        if (running){
            chronometro.setBase(SystemClock.elapsedRealtime() - detenerse);
            chronometro.start();
            running=true;
        }
    }

    public void pausarChronometro(Chronometer chronometro){
        if (!running){
            chronometro.stop();
            detenerse = SystemClock.elapsedRealtime() - chronometro.getBase();
            running = false;
        }
    }

    public void reiniciarChronometro(Chronometer chronometro){
        chronometro.setBase(SystemClock.elapsedRealtime());
        detenerse = 0;
        chronometro.stop();
    }
}
