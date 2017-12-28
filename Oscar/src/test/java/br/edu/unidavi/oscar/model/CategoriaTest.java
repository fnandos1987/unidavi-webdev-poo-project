/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.oscar.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author fernando.schwambach
 */
public class CategoriaTest {
    
    public CategoriaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCategoriaConstructor(){
        Categoria instance = new Categoria(1, "Melhor Filme");
        Assert.assertEquals(new Integer(1), instance.getCatCodigo());
    }
    
    
    @Test
    public void testSetCatCodigo() {
        Integer catCodigo = 1;
        Categoria instance = new Categoria();
        instance.setCatCodigo(catCodigo);
        Assert.assertEquals(catCodigo, instance.getCatCodigo());
    }    
}
