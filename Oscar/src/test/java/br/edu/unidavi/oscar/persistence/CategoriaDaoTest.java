/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.oscar.persistence;

import br.edu.unidavi.oscar.model.Categoria;
import br.edu.unidavi.oscar.util.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fernando.schwambach
 */
public class CategoriaDaoTest {
    
    private Connection conn;
    
    public CategoriaDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        conn = Conexao.getInstance().getConnection();
    }
    
    @After
    public void tearDown() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testSave() {
        Categoria entity = new Categoria(Integer.MAX_VALUE, "Categoria Teste");
        CategoriaDao instance = new CategoriaDao(conn);
        Boolean result = instance.save(entity);
        assertEquals(true, result);
    }

    @Test
    public void testUpdate() {        
        Categoria entity = new Categoria(Integer.MAX_VALUE, "Categoria Teste1");
        CategoriaDao instance = new CategoriaDao(conn);
        Boolean result = instance.update(entity);
        assertEquals(true, result);
    }

    @Test
    public void testDelete() {
        Categoria entity = new Categoria(Integer.MAX_VALUE, "Categoria Teste");
        CategoriaDao instance = new CategoriaDao(conn);
        Boolean result = instance.delete(entity);
        assertEquals(true, result);
    }
}