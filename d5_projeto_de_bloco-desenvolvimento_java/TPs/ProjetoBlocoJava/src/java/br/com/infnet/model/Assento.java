package br.com.infnet.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Assento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idassentos;
    private int fk_idsala;
    private String fila;
    private int assento;

    public int getIdassentos() {
        return idassentos;
    }

    public void setIdassentos(int idassentos) {
        this.idassentos = idassentos;
    }

    public int getFk_idsala() {
        return fk_idsala;
    }

    public void setFk_idsala(int fk_idsala) {
        this.fk_idsala = fk_idsala;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public int getAssento() {
        return assento;
    }

    public void setAssento(int assento) {
        this.assento = assento;
    }

}
