package br.com.infnet.dao;

import br.com.infnet.model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("usuarioDao")
public class UsuarioDAO {

    private EntityManager em;
    
    @PersistenceContext
    public void setEntityManager(EntityManager em){
        this.em = em;
    }
    
    @Transactional
    public void addUsuario(Usuario usuario) {   
        em.persist(usuario);
    }
    
    @Transactional
    public Usuario findUsuario(String email) {   
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
