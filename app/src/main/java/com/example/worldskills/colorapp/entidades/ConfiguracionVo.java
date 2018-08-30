package com.example.worldskills.colorapp.entidades;

public class ConfiguracionVo {
    String intTiempo;
    String tiempo;
    String intentos;
    String tiempoPalabra;
    String cDefault;

    public ConfiguracionVo(String intTiempo, String tiempo, String intentos, String tiempoPalabra, String cDefault) {
        this.intTiempo = intTiempo;
        this.tiempo = tiempo;
        this.intentos = intentos;
        this.tiempoPalabra = tiempoPalabra;
        this.cDefault = cDefault;
    }

    public String getIntTiempo() {
        return intTiempo;
    }

    public void setIntTiempo(String  intTiempo) {
        this.intTiempo = intTiempo;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getIntentos() {
        return intentos;
    }

    public void setIntentos(String intentos) {
        this.intentos = intentos;
    }

    public String getTiempoPalabra() {
        return tiempoPalabra;
    }

    public void setTiempoPalabra(String tiempoPalabra) {
        this.tiempoPalabra = tiempoPalabra;
    }

    public String getcDefault() {
        return cDefault;
    }

    public void setcDefault(String cDefault) {
        this.cDefault = cDefault;
    }
}
