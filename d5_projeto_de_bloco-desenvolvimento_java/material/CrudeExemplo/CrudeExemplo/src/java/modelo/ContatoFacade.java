/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author md20
 */
@Stateless
public class ContatoFacade extends AbstractFacade<Contato> {
    @PersistenceContext(unitName = "CrudeExemploPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContatoFacade() {
        super(Contato.class);
    }
    
}
