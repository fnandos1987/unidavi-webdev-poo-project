/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.oscar.filter;

import br.edu.unidavi.oscar.util.Conexao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 *
 * @author fernando.schwambach
 */
@WebFilter(filterName = "ConnnectionFilter", urlPatterns = {"/*"})
public class ConnnectionFilter implements Filter {
    
    private Connection connection;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            request.setAttribute("conexao", connection);
            chain.doFilter(request, response);                       
        } catch (IOException | ServletException e) {
            throw new ServletException(e);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try{
            connection = Conexao.getInstance().getConnection();            
        } catch (Exception ex){
            Logger.getLogger(ConnnectionFilter.class.getName()).log(Level.SEVERE, ex.toString(), ex);
        }
    }

    @Override
    public void destroy() {
        try{
            connection.close();          
        } catch (SQLException ex){
            Logger.getLogger(ConnnectionFilter.class.getName()).log(Level.SEVERE, ex.toString(), ex);
        }               
    }
}