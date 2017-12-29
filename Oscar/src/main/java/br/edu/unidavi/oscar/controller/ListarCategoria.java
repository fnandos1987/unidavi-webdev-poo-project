package br.edu.unidavi.oscar.controller;

import br.edu.unidavi.oscar.model.Categoria;
import br.edu.unidavi.oscar.persistence.CategoriaDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.schwambach
 */
public class ListarCategoria extends Action {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        
        ArrayList<Categoria> lista = new CategoriaDao(super.getConnection(req)).findAll();

        req.setAttribute("categorias", lista);

        return "categoria.jsp";
    }
}
