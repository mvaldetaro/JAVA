package br.com.infnet.dao;

import br.com.infnet.model.Autor;
import br.com.infnet.model.Editora;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("EditoraDao")
public class EditoraDAO {

    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public List<Editora> listEditora() throws SQLException {
        List<Editora> r = em.createNativeQuery("SELECT * FROM java_web.editora", Editora.class).getResultList();
        return r;
    }
    
    @Transactional
    public void addEditora(Editora editora) {   
        em.persist(editora);
    }
    
    @Transactional
    public Editora getEditora(int id) throws SQLException {   
        Editora editora = new Editora();
        try {    
            Query q = em.createNativeQuery("SELECT * FROM java_web.editora where id = ?", Editora.class);
            q.setParameter(1, id);
            editora = (Editora) q.getSingleResult();   
        } catch(NoResultException e) {
            System.out.println("Nenhum usuário com este email encontrado.");
        }
        return editora;
    }
}
