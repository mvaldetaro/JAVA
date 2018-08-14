package br.com.infnet.controller.dao;

import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EventosDAOTest {
    
    private EventosDAO dao;
    
    public EventosDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dao = new EventosDAO();
        
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of getEM method, of class EventosDAO.
     * @throws java.sql.SQLException
     */
    @Test
    public void testGetEM()throws SQLException {
        assertEquals(true, dao.getEM().isOpen());
    }

    /**
     * Test of listAll method, of class EventosDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testListAll() throws Exception {
        assertNotNull(dao.listAll());
    }

    /**
     * Test of tiposEventos method, of class EventosDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testTiposEventos() throws Exception {
        assertNotNull(dao.tiposEventos());
    }

    /**
     * Test of filtroEventos method, of class EventosDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testFiltroEventos() throws Exception {
        assertNotNull(dao.filtroEventos(1));
    }
    
}
