/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.oscar.persistence;

import br.edu.unidavi.oscar.model.Categoria;
import br.edu.unidavi.oscar.model.Filme;
import br.edu.unidavi.oscar.model.Indicacao;
import br.edu.unidavi.oscar.model.IndicacaoPk;
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
public class VencedorDao extends Dao implements IDao<IndicacaoPk, Indicacao> {
    
    private static final Logger LOGGER = Logger.getLogger(VencedorDao.class.getName());

    public VencedorDao(Connection connection) {
        super(connection);
    }

    @Override
    public Boolean save(Indicacao entity) {
        throw new UnsupportedOperationException(Dao.NOTSUPPORTED); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean update(Indicacao entity) {
        throw new UnsupportedOperationException(Dao.NOTSUPPORTED);
    }

    @Override
    public Boolean delete(Indicacao entity) {
        throw new UnsupportedOperationException(Dao.NOTSUPPORTED); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Indicacao> findAll() { 
        List<Indicacao> array = new ArrayList<>();
        StringBuilder sql = new StringBuilder(" select indicacao.ano, ");
        sql.append(" categoria.catcodigo, ");
        sql.append(" categoria.descricao, ");
        sql.append(" filme.filcodigo, ");
        sql.append(" filme.titulo, ");
        sql.append(" pessoa.pescodigo, ");
        sql.append(" pessoa.nome ");
        sql.append(" from indicacao ");
        sql.append(" join categoria ");
        sql.append(" on categoria.catcodigo = indicacao.catcodigo ");
        sql.append(" join filme ");
        sql.append(" on filme.filcodigo = indicacao.filcodigo ");
        sql.append(" left join indicacaoelenco ");
        sql.append(" on indicacaoelenco.ano = indicacao.ano ");
        sql.append(" and indicacaoelenco.filcodigo = indicacao.filcodigo ");
        sql.append(" and indicacaoelenco.catcodigo = indicacao.catcodigo ");
        sql.append(" left join pessoa ");
        sql.append(" on pessoa.pescodigo = indicacaoelenco.pescodigo ");
        sql.append(" where indicacao.vencedor = 1 ");
        sql.append(" order by indicacao.ano, indicacao.catcodigo ");

        try {            
            ResultSet rs = getAllByQuery(sql.toString());
            if (rs instanceof ResultSet) {
                while (rs.next()) {
                    Categoria categoria = new Categoria(rs.getInt("catcodigo"), rs.getString("descricao"));
                    Filme filme = new Filme(rs.getInt("filcodigo"), rs.getString("titulo"));
                    Pessoa pessoa = new Pessoa(rs.getInt("pescodigo"), rs.getString("nome"));
                    IndicacaoPk pk = new IndicacaoPk(rs.getShort("ano"), categoria, filme);
                    array.add(new Indicacao(pk, pessoa));
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }

        return array;
    }

    @Override
    public Indicacao findById(IndicacaoPk id) {
        throw new UnsupportedOperationException(Dao.NOTSUPPORTED); //To change body of generated methods, choose Tools | Templates.
    }
}