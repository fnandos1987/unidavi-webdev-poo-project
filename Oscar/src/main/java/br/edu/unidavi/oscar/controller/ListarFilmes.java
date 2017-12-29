package br.edu.unidavi.oscar.controller;

import br.edu.unidavi.oscar.persistence.FilmeDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.schwambach
 */
public class ListarFilmes extends Action {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        
        req.setAttribute("filmes", new FilmeDao(super.getConnection(req)).findAll());
        
        return "filme.jsp";
    }
    
}
