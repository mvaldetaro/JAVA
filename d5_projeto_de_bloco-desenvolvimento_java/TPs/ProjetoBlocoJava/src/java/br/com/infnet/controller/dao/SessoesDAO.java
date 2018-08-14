package br.com.infnet.controller.dao;

import br.com.infnet.model.Sessoes;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SessoesDAO {
    public EntityManager getEM(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjetoBlocoJavaPU");
        return factory.createEntityManager();
    }
    
    public List<Sessoes> listarSessoesEvento(int id) throws SQLException {   
        EntityManager em = getEM();
        List<Sessoes> r = em.createNativeQuery("SELECT idsessao, idsala, data, horario, preco, titulo, nome  FROM java_web.sessao inner join java_web.evento inner join java_web.sala on sessao.fk_idevento = evento.idevento and sessao.fk_idsala = sala.idsala where idevento = " + id, Sessoes.class).getResultList();
        return r;
    }
    
    public List<Sessoes> getSessao(int tipo) throws SQLException {   
        EntityManager em = getEM();
        List<Sessoes> r = em.createNativeQuery("SELECT * FROM java_web.sessao where idsessao = " + tipo, Sessoes.class).getResultList();
        return r;
    }
    
}
