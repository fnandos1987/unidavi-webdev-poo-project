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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando.schwambach
 */
public class IndicacaoDao extends Dao implements IDao<IndicacaoPk, Indicacao> {

    private static final Logger LOGGER = Logger.getLogger(IndicacaoDao.class.getName());
    private final String INSERT = "insert into indicacao(ano, catcodigo, filcodigo) values (?,?,?)";
    private final String DELETE = "delete from indicacao where ano = ? and catcodigo = ? and filcodigo = ?";

    public IndicacaoDao(Connection connection) {
        super(connection);
    }

    @Override
    public Boolean save(Indicacao entity) {
        return execute(this.INSERT, entity.getPk().getAno(), entity.getPk().getCategoria().getCatCodigo(), entity.getPk().getFilme().getFilCodigo());
    }

    @Override
    public Boolean update(Indicacao entity) {
        throw new UnsupportedOperationException("Update não implementado para indicação");
    }

    @Override
    public Boolean delete(Indicacao entity) {
        return execute(this.DELETE, entity.getPk().getAno(), entity.getPk().getCategoria().getCatCodigo(), entity.getPk().getFilme().getFilCodigo());
    }

    @Override
    public ArrayList<Indicacao> findAll() {
        StringBuilder sql = this.getSqlBase();
        sql.append("order by indicacao.filcodigo");

        ArrayList<Indicacao> array = new ArrayList<>();
        try {
            ResultSet rs = super.getAllByQuery(sql.toString());
            while (rs.next()) {
                Categoria categoria = new Categoria(rs.getInt("catcodigo"), rs.getString("descricao"));
                Filme filme = new Filme(rs.getInt("filcodigo"), rs.getString("titulo"));
                Pessoa pessoa = new Pessoa(rs.getInt("pescodigo"), rs.getString("nome"));
                IndicacaoPk pk = new IndicacaoPk(rs.getShort("ano"), categoria, filme);
                array.add(new Indicacao(pk, pessoa));
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        return array;
    }

    @Override
    public Indicacao findById(IndicacaoPk id) {
        Indicacao indicacao = new Indicacao();
        try {
            StringBuilder sql = this.getSqlBase();
            sql.append("where indicacao.ano = ? ");
            sql.append("and indicacao.catcodigo = ?");
            sql.append("and indicacao.filcodigo = ?");

            ResultSet rs = super.getAllByQueryWithParameters(sql.toString(), id.getAno(), id.getCategoria().getCatCodigo(), id.getFilme().getFilCodigo());
            while (rs.next()) {
                Categoria categoria = new Categoria(rs.getInt("catcodigo"), rs.getString("descricao"));
                Filme filme = new Filme(rs.getInt("filcodigo"), rs.getString("titulo"));
                Pessoa pessoa = new Pessoa(rs.getInt("pescodigo"), rs.getString("nome"));
                IndicacaoPk pk = new IndicacaoPk(rs.getShort("ano"), categoria, filme);

                indicacao.setPk(pk);
                indicacao.setPessoa(pessoa);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        return indicacao;
    }

    public ArrayList<Indicacao> findAllByCategoria(Integer catCodigo) {
        ArrayList<Indicacao> array = new ArrayList<>();

        StringBuilder sql = this.getSqlBase();
        sql.append("where indicacao.catcodigo = ?");
        sql.append("order by indicacao.filcodigo");
        try {
            ResultSet rs = super.getAllByQueryWithParameters(sql.toString(), catCodigo);
            while (rs.next()) {
                Categoria categoria = new Categoria(rs.getInt("catcodigo"), rs.getString("descricao"));
                Filme filme = new Filme(rs.getInt("filcodigo"), rs.getString("titulo"));
                Pessoa pessoa = new Pessoa(rs.getInt("pescodigo"), rs.getString("nome"));
                IndicacaoPk pk = new IndicacaoPk(rs.getShort("ano"), categoria, filme);
                array.add(new Indicacao(pk, pessoa));
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        return array;
    }

    private StringBuilder getSqlBase() {
        StringBuilder sql = new StringBuilder("select indicacao.ano,");
        sql.append("categoria.catcodigo,");
        sql.append("categoria.descricao,");
        sql.append("filme.filcodigo,");
        sql.append("filme.titulo,");
        sql.append("pessoa.pescodigo,");
        sql.append("pessoa.nome");
        sql.append("from indicacao");
        sql.append("join categoria");
        sql.append("on categoria.catcodigo = indicacao.catcodigo");
        sql.append("join filme");
        sql.append("on filme.filcodigo = indicacao.filcodigo");
        sql.append("left join indicacaoelenco");
        sql.append("on indicacaoelenco.ano = indicacao.ano");
        sql.append("and indicacaoelenco.filcodigo = indicacao.filcodigo");
        sql.append("and indicacaoelenco.catcodigo = indicacao.catcodigo");
        sql.append("left join pessoa");
        sql.append("on pessoa.pescodigo = indicacaoelenco.pescodigo");
        return sql;
    }
}
