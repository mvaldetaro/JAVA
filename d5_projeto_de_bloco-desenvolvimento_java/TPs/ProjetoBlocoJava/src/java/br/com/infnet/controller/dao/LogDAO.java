package br.com.infnet.controller.dao;

import br.com.infnet.model.Log;
import br.com.infnet.model.Registro;
import br.com.infnet.model.Sala;
import br.com.infnet.model.Sessoes;
import br.com.infnet.model.Usuario;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class LogDAO {
    
    public EntityManager getEM(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjetoBlocoJavaPU");
        return factory.createEntityManager();
    }
    
    public void addRegistro(Log registro) throws SQLException {           
        EntityManager em = getEM();
        try {  
            em.getTransaction().begin();
            em.persist(registro);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public List<Registro> listLogs() throws SQLException {   
        EntityManager em = getEM();
        String q =  "SELECT idhistorico_compras, ID, idsessao, idevento, idassentos, titulo, preco, data, horario, status, sessao.fk_idsala   FROM java_web.log " +
                    "INNER JOIN java_web.sessao inner JOIN  java_web.evento inner join java_web.usuario inner join java_web.assentos " +
                    "on java_web.log.fk_idusuario = java_web.usuario.ID " +
                    "and java_web.log.fk_idsessao = java_web.sessao.idsessao " +
                    "and java_web.log.fk_idassento = java_web.assentos.idassentos " +
                    "and java_web.sessao.fk_idevento = java_web.evento.idevento";
        List<Registro> r = em.createNativeQuery(q, Registro.class).getResultList();
        return r;
    }
    
    public List<Registro> listLogsUser(int id) throws SQLException {   
        EntityManager em = getEM();
        String q =  "SELECT idhistorico_compras, ID, idsessao, idevento, idassentos, titulo, preco, data, horario, status, sessao.fk_idsala  FROM java_web.log " +
                    "INNER JOIN java_web.sessao inner JOIN  java_web.evento inner join java_web.usuario inner join java_web.assentos " +
                    "on java_web.log.fk_idusuario = java_web.usuario.ID " +
                    "and java_web.log.fk_idsessao = java_web.sessao.idsessao " +
                    "and java_web.log.fk_idassento = java_web.assentos.idassentos " +
                    "and java_web.sessao.fk_idevento = java_web.evento.idevento " +
                    "where ID = " + id;
        List<Registro> r = em.createNativeQuery(q, Registro.class).getResultList();
        return r;
    }
    
    public List<Registro> listLogsAssentosSala(int id) throws SQLException {   
        EntityManager em = getEM();
        String q =  "SELECT idhistorico_compras, ID, idsessao, idevento, idassentos, titulo, preco, data, horario, status, sessao.fk_idsala  FROM java_web.log " +
                    "INNER JOIN java_web.sessao inner JOIN  java_web.evento inner join java_web.usuario inner join java_web.assentos " +
                    "on java_web.log.fk_idusuario = java_web.usuario.ID " +
                    "and java_web.log.fk_idsessao = java_web.sessao.idsessao " +
                    "and java_web.log.fk_idassento = java_web.assentos.idassentos " +
                    "and java_web.sessao.fk_idevento = java_web.evento.idevento " +
                    "where sessao.fk_idsala = "+id;
        List<Registro> r = em.createNativeQuery(q, Registro.class).getResultList();
        return r;
    }
   
}

