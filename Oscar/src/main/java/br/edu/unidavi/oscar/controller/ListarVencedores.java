package br.edu.unidavi.oscar.controller;

import br.edu.unidavi.oscar.persistence.VencedorDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.schwambach
 */
public class ListarVencedores extends Action {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {

        req.setAttribute("vencedores", new VencedorDao(super.getConnection(req)).findAll());

        return "listaVencedores.jsp";
    }    
}