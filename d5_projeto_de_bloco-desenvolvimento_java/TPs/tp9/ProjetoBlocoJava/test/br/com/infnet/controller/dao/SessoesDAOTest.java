/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infnet.controller.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Magno
 */
public class SessoesDAOTest {
    
    private SessoesDAO dao;
    
    public SessoesDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dao = new SessoesDAO();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEM method, of class SessoesDAO.
     */
    @Test
    public void testGetEM() {
        assertEquals(true, dao.getEM().isOpen());
    }

    /**
     * Test of listarSessoesEvento method, of class SessoesDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testListarSessoesEvento() throws Exception {
        assertNotNull(dao.listarSessoesEvento(1));
    }

    /**
     * Test of getSessao method, of class SessoesDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetSessao() throws Exception {
        assertNotNull(dao.getSessao(1));
    }
    
}
