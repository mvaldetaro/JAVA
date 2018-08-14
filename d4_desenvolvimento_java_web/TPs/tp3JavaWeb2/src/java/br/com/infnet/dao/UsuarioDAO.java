package br.com.infnet.dao;

import br.com.infnet.model.Usuario;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UsuarioDAO {
    
    public EntityManager getEM(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TP3PU");
        return factory.createEntityManager();
    }
    
    public void addUsuario(Usuario usuario) throws SQLException {   
        
        EntityManager em = getEM();
        try {  
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public Usuario findUsuario(String email) throws SQLException {   
        EntityManager em = getEM();
        Usuario usuario = new Usuario();
        try {    
            Query q = em.createNativeQuery("SELECT * FROM java_web.usuario where email = ?", Usuario.class);
            q.setParameter(1, email);
            usuario = (Usuario) q.getSingleResult();   
        } catch(NoResultException e) {
            System.out.println("Nenhum usuário com este email encontrado.");
        }
        return usuario;
    }
}

