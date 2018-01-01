/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.oscar.persistence;

import br.edu.unidavi.oscar.model.Categoria;
import br.edu.unidavi.oscar.model.Filme;
import br.edu.unidavi.oscar.model.Pessoa;
import br.edu.unidavi.oscar.model.Vencedor;
import br.edu.unidavi.oscar.model.VencedorPk;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando.schwambach
 */
public class VencedorDao extends Dao implements IDao<VencedorPk, Vencedor> {

    private static final Logger LOGGER = Logger.getLogger(VencedorDao.class.getName());
    
    public VencedorDao(Connection connection) {
        super(connection);
    }

    @Override
    public Boolean save(Vencedor entity) {
        throw new UnsupportedOperationException(NOTSUPPORTED); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean update(Vencedor entity) {
        throw new UnsupportedOperationException(NOTSUPPORTED);
    }

    @Override
    public Boolean delete(Vencedor entity) {
        throw new UnsupportedOperationException(NOTSUPPORTED); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Vencedor> findAll() {
        ArrayList<Vencedor> array = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select vencedor.ano,");
        sql.append("categoria.catcodigo,");
        sql.append("categoria.descricao,");
        sql.append("filme.filcodigo,");
        sql.append("filme.titulo,");
        sql.append("pessoa.pescodigo,");
        sql.append("pessoa.nome");
        sql.append("from vencedor");
        sql.append("join categoria");
        sql.append("on categoria.catcodigo = vencedor.catcodigo");
        sql.append("join filme");
        sql.append("on filme.filcodigo = vencedor.filcodigo");
        sql.append("left join indicacaoelenco");
        sql.append("on indicacaoelenco.ano = vencedor.ano");
        sql.append("and indicacaoelenco.filcodigo = vencedor.filcodigo");
        sql.append("and indicacaoelenco.catcodigo = vencedor.catcodigo");
        sql.append("left join pessoa");
        sql.append("on pessoa.pescodigo = indicacaoelenco.pescodigo");
        sql.append("order by vencedor.ano, vencedor.catcodigo");

        try {
            ResultSet rs = getAllByQuery(sql.toString());
            if (rs instanceof ResultSet) {
                while (rs.next()) {
                    Categoria categoria = new Categoria(rs.getInt("catcodigo"), rs.getString("descricao"));
                    Filme filme = new Filme(rs.getInt("filcodigo"), rs.getString("titulo"));
                    Pessoa pessoa = new Pessoa(rs.getInt("pescodigo"), rs.getString("nome"));
                    VencedorPk pk = new VencedorPk(rs.getShort("ano"), categoria, filme);
                    array.add(new Vencedor(pk, pessoa));
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }

        return array;
    }

    @Override
    public Vencedor findById(VencedorPk object) {
        throw new UnsupportedOperationException(NOTSUPPORTED); //To change body of generated methods, choose Tools | Templates.
    }
}