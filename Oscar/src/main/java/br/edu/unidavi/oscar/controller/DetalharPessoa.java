/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.oscar.controller;

import br.edu.unidavi.oscar.persistence.PessoaDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.schwambach
 */
public class DetalharPessoa extends Action {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        Integer pesCodigo = Integer.parseInt(req.getParameter("pescodigo"));
        
        req.setAttribute("pessoa", new PessoaDao(super.getConnection(req)).findById(pesCodigo));
        
        return "detalhePessoa.jsp";
    }    
}