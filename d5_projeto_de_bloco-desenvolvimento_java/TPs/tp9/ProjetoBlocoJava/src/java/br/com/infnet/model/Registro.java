package br.com.infnet.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Registro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idhistorico_compras;
    private int ID;
    private int idsessao;
    private int idevento;
    private int idassentos;
    private String titulo;
    private int preco;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    private Time horario;
    private String status;

    public int getIdhistorico_compras() {
        return idhistorico_compras;
    }

    public void setIdhistorico_compras(int idhistorico_compras) {
        this.idhistorico_compras = idhistorico_compras;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIdsessao() {
        return idsessao;
    }

    public void setIdsessao(int idsessao) {
        this.idsessao = idsessao;
    }

    public int getIdevento() {
        return idevento;
    }

    public void setIdevento(int idevento) {
        this.idevento = idevento;
    }

    public int getIdassentos() {
        return idassentos;
    }

    public void setIdassentos(int idassentos) {
        this.idassentos = idassentos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
