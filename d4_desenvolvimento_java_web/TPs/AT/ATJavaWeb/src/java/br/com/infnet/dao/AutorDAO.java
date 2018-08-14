package br.com.infnet.dao;

import br.com.infnet.model.Autor;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("autorDao")
public class AutorDAO {
    private EntityManager em;
    
    @PersistenceContext
    public void setEntityManager(EntityManager em){
        this.em = em;
    }
    
    @Transactional
    public List<Autor> listAutor() {
        List<Autor> r = em.createNativeQuery("SELECT * FROM java_web.autor", Autor.class).getResultList();
        return r;
    }
    
    @Transactional
    public void addAutor(Autor autor) {   
        em.persist(autor);
    }
    
    @Transactional
    public Autor getAutor(int id) throws SQLException {   
        Autor autor = new Autor();
        try {    
            Query q = em.createNativeQuery("SELECT * FROM java_web.autor where id = ?", Autor.class);
            q.setParameter(1, id);
            autor = (Autor) q.getSingleResult();   
        } catch(NoResultException e) {
            System.out.println("Nenhum usuário com este email encontrado.");
        }
        return autor;
    }
}
