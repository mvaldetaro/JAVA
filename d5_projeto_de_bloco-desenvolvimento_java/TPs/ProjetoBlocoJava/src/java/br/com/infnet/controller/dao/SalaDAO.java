package br.com.infnet.controller.dao;

import br.com.infnet.model.Sala;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SalaDAO {
    public EntityManager getEM(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjetoBlocoJavaPU");
        return factory.createEntityManager();
    }
    
    public List<Sala> getSala(int idSala) throws SQLException {   
        EntityManager em = getEM();
        List<Sala> r = em.createNativeQuery("SELECT idassentos, idsala, nome, fila, assento FROM java_web.sala inner join java_web.assentos on java_web.assentos.fk_idsala = java_web.sala.idsala where idsala = " + idSala, Sala.class).getResultList();
        return r;
    }
    
    public List<Sala> getSalaAssento(int idAssento) throws SQLException {   
        EntityManager em = getEM();
        List<Sala> r = em.createNativeQuery("SELECT idassentos, idsala, nome, fila, assento FROM java_web.sala inner join java_web.assentos on java_web.assentos.fk_idsala = java_web.sala.idsala where idassentos = " + idAssento, Sala.class).getResultList();
        return r;
    }
    
}
