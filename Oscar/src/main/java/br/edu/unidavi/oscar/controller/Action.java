package br.edu.unidavi.oscar.controller;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.schwambach
 */
public abstract class Action {
    
    public abstract String execute(HttpServletRequest req, HttpServletResponse res);
    
    protected Connection getConnection(HttpServletRequest req){
        return (Connection) req.getAttribute("conexao");        
    }    
    
}
