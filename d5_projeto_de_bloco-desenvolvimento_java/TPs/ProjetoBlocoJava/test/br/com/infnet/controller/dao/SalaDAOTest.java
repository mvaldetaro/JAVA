/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infnet.controller.dao;

import br.com.infnet.model.Sala;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
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
public class SalaDAOTest {
    
    private SalaDAO dao;
    
    public SalaDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dao = new SalaDAO();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEM method, of class SalaDAO.
     * @throws java.sql.SQLException
     */
    @Test
    public void testGetEM() throws SQLException{
        assertEquals(true, dao.getEM().isOpen());
    }

    /**
     * Test of getSala method, of class SalaDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetSala() throws Exception {
        assertNotNull(dao.getSala(1));
    }

    /**
     * Test of getSalaAssento method, of class SalaDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetSalaAssento() throws Exception {
        assertNotNull(dao.getSalaAssento(1));
    }
    
}
