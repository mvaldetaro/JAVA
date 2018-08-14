package br.com.infnet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtipo_evento;
    private String titulo;
    private String descricao;

    public int getIdtipo_evento() {
        return idtipo_evento;
    }

    public void setIdtipo_evento(int idtipo_evento) {
        this.idtipo_evento = idtipo_evento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
