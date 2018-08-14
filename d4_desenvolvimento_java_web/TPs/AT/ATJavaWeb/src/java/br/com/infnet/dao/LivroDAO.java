package br.com.infnet.dao;

import br.com.infnet.model.Livro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("livroDao")
public class LivroDAO {
    
    private EntityManager em;
    
    @PersistenceContext
    public void setEntityManager(EntityManager em){
        this.em = em;
    }
    
    @Transactional
    public void addLivro(Livro livro) {
        em.persist(livro);
    }
    
    @Transactional
    public List<Livro> listLivros(){
        List<Livro> r = em.createNativeQuery("SELECT * FROM java_web.livro", Livro.class).getResultList();
        return r;
    }
    
    @Transactional
    public void excluir(Livro livro){
         em.remove(em.find(Livro.class,livro.getId()));
    }
    
    @Transactional
    public Livro getLivro(int id){
         Livro r = em.find(Livro.class, id);
         return r;
    }
    
    @Transactional
    public void update(Livro livro){
         em.merge(livro);
    }
}
