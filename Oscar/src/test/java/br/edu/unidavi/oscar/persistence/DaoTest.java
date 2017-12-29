/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.oscar.persistence;

import br.edu.unidavi.oscar.util.Conexao;
import java.sql.ResultSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fernando.schwambach
 */
public class DaoTest {
    
    private Dao dao;
    
    public DaoTest() {
    }
    
    @Before
    public void setUp() {
        dao = new Dao(Conexao.getInstance().getConnection());
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testExecute(){
        Integer cod = 999999;
        Boolean ok = dao.execute("delete from categoria where catcodigo = ?", cod);
        assertEquals(true, ok);
    }
    
    @Test
    public void testGetAllByQuery() {
        ResultSet set = dao.getAllByQuery("select * from categoria");
        assertNotSame(null, set);
    }
    
    @Test
    public void testGetAllByQueryWithParameters(){
        Integer cod = 1;
        ResultSet set = dao.getAllByQueryWithParameters("select * from categoria where catcodigo = ?", cod);   
        assertNotSame(null, set);
    }   
    
    @Test
    public void testGetSequence() {
        Integer resul = dao.getSequence("categoria", "catcodigo");
        assertNotSame(new Integer("0"), resul);
    }    
}
