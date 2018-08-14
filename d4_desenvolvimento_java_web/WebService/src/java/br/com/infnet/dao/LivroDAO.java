package br.com.infnet.dao;

import br.com.infnet.model.Livro;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository("livroDao")
public class LivroDAO {
    private EntityManager em;
    
    @PersistenceContext
    public void setEntityManager(EntityManager em){
        this.em = em;
    }
    
    public List<Livro> listLivros() throws SQLException {
        List<Livro> r = em.createNativeQuery("SELECT * FROM java_web.livro", Livro.class).getResultList();
        return r;
    }
}
