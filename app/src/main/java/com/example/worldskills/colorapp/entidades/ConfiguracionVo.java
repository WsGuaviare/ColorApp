package com.example.worldskills.colorapp.entidades;

public class ConfiguracionVo {
    int intTiempo,tiempo,intentos,tiempoPalabra,cDefault;

    public ConfiguracionVo(int intTiempo, int tiempo, int intentos, int tiempoPalabra, int cDefault) {
        this.intTiempo = intTiempo;
        this.tiempo = tiempo;
        this.intentos = intentos;
        this.tiempoPalabra = tiempoPalabra;
        this.cDefault = cDefault;
    }

    public int getIntTiempo() {
        return intTiempo;
    }

    public void setIntTiempo(int intTiempo) {
        this.intTiempo = intTiempo;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public int getTiempoPalabra() {
        return tiempoPalabra;
    }

    public void setTiempoPalabra(int tiempoPalabra) {
        this.tiempoPalabra = tiempoPalabra;
    }

    public int getcDefault() {
        return cDefault;
    }

    public void setcDefault(int cDefault) {
        this.cDefault = cDefault;
    }
}
