/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.oscar.persistence;

import br.edu.unidavi.oscar.model.Elenco;
import br.edu.unidavi.oscar.model.ElencoPk;
import br.edu.unidavi.oscar.model.Filme;
import br.edu.unidavi.oscar.model.Pessoa;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando.schwambach
 */
public class ElencoDao extends Dao implements IDao<ElencoPk, Elenco>{

    private static final Logger LOGGER = Logger.getLogger(ElencoDao.class.getName());
    
    public ElencoDao(Connection connection) {
        super(connection);
    }

    @Override
    public Boolean save(Elenco entity) {
        throw new UnsupportedOperationException(NOTSUPPORTED); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean update(Elenco entity) {
        throw new UnsupportedOperationException(NOTSUPPORTED); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean delete(Elenco entity) {
        throw new UnsupportedOperationException(NOTSUPPORTED); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Elenco> findAll() {
        throw new UnsupportedOperationException(NOTSUPPORTED); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Elenco findById(ElencoPk id) {
        throw new UnsupportedOperationException(NOTSUPPORTED); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Elenco> findAllByFilme(Integer filCodigo) {
        StringBuilder sql = new StringBuilder("select filme.filcodigo,");
        sql.append("filme.titulo,");
        sql.append("pessoa.pescodigo,");
        sql.append("pessoa.nome");
        sql.append("from elenco");
        sql.append("join filme");
        sql.append("on filme.filcodigo = elenco.filcodigo");
        sql.append("join pessoa");
        sql.append("on pessoa.pescodigo = elenco.pescodigo");
        sql.append("where elenco.filcodigo = ?");
        sql.append("order by pessoa.pescodigo");
        
        List<Elenco> array = new ArrayList<>();
        try {
            ResultSet rs = super.getAllByQueryWithParameters(sql.toString(), filCodigo);
            while (rs.next()) {
                Filme filme = new Filme(rs.getInt("filcodigo"), rs.getString("titulo"));
                Pessoa pessoa = new Pessoa(rs.getInt("pescodigo"), rs.getString("nome"));
                ElencoPk pk = new ElencoPk(pessoa, filme);
                array.add(new Elenco(pk));
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        return array;
    }    
}