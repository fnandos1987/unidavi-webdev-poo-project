package br.edu.unidavi.oscar.controller;

import br.edu.unidavi.oscar.persistence.IndicacaoDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.schwambach
 */
public class ListarIndicacoes extends Action {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Integer catCodigo = Integer.parseInt(req.getParameter("catcodigo"));
        
        req.setAttribute("indicacoes", new IndicacaoDao(super.getConnection(req)).findAllByCategoria(catCodigo));
        
        return "indicacoes.jsp";
    }    
}