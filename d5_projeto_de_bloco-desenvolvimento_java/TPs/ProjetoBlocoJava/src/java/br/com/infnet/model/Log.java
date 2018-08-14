package br.com.infnet.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Log implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idhistorico_compras;
    private int fk_idsessao;
    private int fk_idusuario;
    private int fk_idassento;
    private String status;
    private int fk_idsala;

    public int getFk_idsala() {
        return fk_idsala;
    }

    public void setFk_idsala(int fk_idsala) {
        this.fk_idsala = fk_idsala;
    }
    
    public int getIdhistorico_compras() {
        return idhistorico_compras;
    }

    public void setIdhistorico_compras(int idhistorico_compras) {
        this.idhistorico_compras = idhistorico_compras;
    }

    public int getFk_idsessao() {
        return fk_idsessao;
    }

    public void setFk_idsessao(int fk_idsessao) {
        this.fk_idsessao = fk_idsessao;
    }

    public int getFk_idusuario() {
        return fk_idusuario;
    }

    public void setFk_idusuario(int fk_idusuario) {
        this.fk_idusuario = fk_idusuario;
    }

    public int getFk_idassento() {
        return fk_idassento;
    }

    public void setFk_idassento(int fk_idassento) {
        this.fk_idassento = fk_idassento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
       
}
