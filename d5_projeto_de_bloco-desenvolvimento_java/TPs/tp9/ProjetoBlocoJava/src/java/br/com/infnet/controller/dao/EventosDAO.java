package br.com.infnet.controller.dao;

import br.com.infnet.model.Evento;
import br.com.infnet.model.TipoEvento;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EventosDAO {
    public EntityManager getEM(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjetoBlocoJavaPU");
        return factory.createEntityManager();
    }
    
    public List<Evento> listAll() throws SQLException {   
        EntityManager em = getEM();
        List<Evento> r = em.createNativeQuery("SELECT * FROM java_web.evento", Evento.class).getResultList();
        return r;
    }
    
    public List<TipoEvento> tiposEventos() throws SQLException {   
        EntityManager em = getEM();
        List<TipoEvento> r = em.createNativeQuery("SELECT * FROM java_web.tipo_evento", TipoEvento.class).getResultList();
        return r;
    }
    
    public List<Evento> filtroEventos(int tipo) throws SQLException {   
        EntityManager em = getEM();
        List<Evento> r = em.createNativeQuery("SELECT * FROM java_web.evento where fk_idtipo_evento = " + tipo, Evento.class).getResultList();
        return r;
    }
    
    public List<Evento> getEvento(int id) throws SQLException {   
        EntityManager em = getEM();
        List<Evento> r = em.createNativeQuery("SELECT * FROM java_web.evento where idevento = " + id, Evento.class).getResultList();
        return r;
    }
    
}
