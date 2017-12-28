/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.oscar.controller;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.schwambach
 */
abstract public class Action {
    
    protected Connection getConnection(HttpServletRequest req){
        return (Connection) req.getAttribute("conexao");        
    }    
    
    abstract public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception;
}
