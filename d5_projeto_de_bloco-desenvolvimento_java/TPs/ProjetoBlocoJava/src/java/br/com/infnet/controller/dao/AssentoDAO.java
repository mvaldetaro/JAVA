package br.com.infnet.controller.dao;

import br.com.infnet.model.Assento;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AssentoDAO {
    public EntityManager getEM(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjetoBlocoJavaPU");
        return factory.createEntityManager();
    }
    
    public List<Assento> getAssento(int id) throws SQLException {   
        EntityManager em = getEM();
        List<Assento> r = em.createNativeQuery("SELECT * FROM java_web.assentos where idassentos = " + id, Assento.class).getResultList();
        return r;
    }
}
