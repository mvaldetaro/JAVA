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
public class AssentoDAOTest {
    
    private AssentoDAO dao;
    
    public AssentoDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dao = new AssentoDAO();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEM method, of class AssentoDAO.
     */
    @Test
    public void testGetEM() {
        assertEquals(true, dao.getEM().isOpen());
    }

    /**
     * Test of getAssento method, of class AssentoDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAssento() throws Exception {
        assertNotNull(dao.getAssento(1));
    }
    
}
