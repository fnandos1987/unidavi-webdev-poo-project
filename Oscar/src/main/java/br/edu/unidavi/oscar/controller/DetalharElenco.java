/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.oscar.controller;

import br.edu.unidavi.oscar.persistence.ElencoDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.schwambach
 */
public class DetalharElenco extends Action {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Integer filCodigo = Integer.parseInt(req.getParameter("filcodigo"));
        
        req.setAttribute("elenco", new ElencoDao(super.getConnection(req)).findAllByFilme(filCodigo));
        
        return "listaElenco.jsp";
    }
    
}
