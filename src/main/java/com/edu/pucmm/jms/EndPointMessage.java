package com.edu.pucmm.jms;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;


public class EndPointMessage {

    //LocalDateTime fechaGeneracion;
    int idDispositivo;
    float temperatura;
    float humedad;
    String fechaGeneracion;

    public EndPointMessage(){

    }

    public EndPointMessage(String fechaGeneracion, int idDispositivo, float temperatura, float humedad) {
        this.fechaGeneracion = fechaGeneracion;
        this.idDispositivo = idDispositivo;
        this.temperatura = temperatura;
        this.humedad = humedad;
    }

    public String getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(String fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public int getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public float getHumedad() {
        return humedad;
    }

    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }
}
