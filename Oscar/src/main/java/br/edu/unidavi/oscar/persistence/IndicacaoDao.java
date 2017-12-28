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

/**
 *
 * @author fernando.schwambach
 */
public class IndicacaoDao extends Dao implements IDao<IndicacaoPk, Indicacao> {
    
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
        ArrayList<Indicacao> array = new ArrayList<>();

        String sql = "select indicacao.ano,"
                + "          categoria.catcodigo,"
                + "          categoria.descricao,"
                + "          filme.filcodigo,"
                + "          filme.titulo," 
                + "          pessoa.pescodigo," 
                + "          pessoa.nome" 
                + "     from indicacao"
                + "     join categoria"
                + "       on categoria.catcodigo = indicacao.catcodigo"
                + "     join filme"
                + "       on filme.filcodigo = indicacao.filcodigo "
                + "     left join indicacaoelenco"
                + "       on indicacaoelenco.ano = indicacao.ano "
                + "      and indicacaoelenco.filcodigo = indicacao.filcodigo "
                + "      and indicacaoelenco.catcodigo = indicacao.catcodigo "
                + "     left join pessoa"
                + "       on pessoa.pescodigo = indicacaoelenco.pescodigo "
                + "    order by indicacao.filcodigo";
        try {
            ResultSet rs = super.getAllByQuery(sql);
            while (rs.next()) {
                Categoria categoria = new Categoria(rs.getInt("catcodigo"), rs.getString("descricao"));
                Filme filme = new Filme(rs.getInt("filcodigo"), rs.getString("titulo"));
                Pessoa pessoa = new Pessoa(rs.getInt("pescodigo"), rs.getString("nome"));
                IndicacaoPk pk = new IndicacaoPk(rs.getShort("ano"), categoria, filme);
                array.add(new Indicacao(pk, pessoa));
            }
        } catch (SQLException ex) {
        }
        return array;
    }

    @Override
    public Indicacao findById(IndicacaoPk id) {
        Indicacao indicacao = new Indicacao();
        try {
            String sql = "select indicacao.ano,"
                + "          categoria.catcodigo,"
                + "          categoria.descricao,"
                + "          filme.filcodigo,"
                + "          filme.titulo," 
                + "          pessoa.pescodigo," 
                + "          pessoa.nome" 
                + "     from indicacao"
                + "     join categoria"
                + "       on categoria.catcodigo = indicacao.catcodigo"
                + "     join filme"
                + "       on filme.filcodigo = indicacao.filcodigo "
                + "     left join indicacaoelenco"
                + "       on indicacaoelenco.ano = indicacao.ano "
                + "      and indicacaoelenco.filcodigo = indicacao.filcodigo "
                + "      and indicacaoelenco.catcodigo = indicacao.catcodigo "
                + "     left join pessoa"
                + "       on pessoa.pescodigo = indicacaoelenco.pescodigo "
                + "    where indicacao.ano = ? "
                + "      and indicacao.catcodigo"
                + "      and indicacao.filcodigo";
            
            ResultSet rs = super.getAllByQueryWithParameters(sql, id.getAno(), id.getCategoria().getCatCodigo(), id.getFilme().getFilCodigo());
            while (rs.next()) {
                Categoria categoria = new Categoria(rs.getInt("catcodigo"), rs.getString("descricao"));
                Filme filme = new Filme(rs.getInt("filcodigo"), rs.getString("titulo"));
                Pessoa pessoa = new Pessoa(rs.getInt("pescodigo"), rs.getString("nome"));
                IndicacaoPk pk = new IndicacaoPk(rs.getShort("ano"), categoria, filme);
                
                indicacao.setPk(pk);
                indicacao.setPessoa(pessoa);
            }
        } catch (SQLException ex) {
        }
        return indicacao;
    }

    public ArrayList<Indicacao> findAllByCategoria(Integer catCodigo) {
        ArrayList<Indicacao> array = new ArrayList<>();

        String sql = "select indicacao.ano,"
                + "          categoria.catcodigo,"
                + "          categoria.descricao,"
                + "          filme.filcodigo,"
                + "          filme.titulo," 
                + "          pessoa.pescodigo," 
                + "          pessoa.nome" 
                + "     from indicacao"
                + "     join categoria"
                + "       on categoria.catcodigo = indicacao.catcodigo"
                + "     join filme"
                + "       on filme.filcodigo = indicacao.filcodigo "
                + "     left join indicacaoelenco"
                + "       on indicacaoelenco.ano = indicacao.ano "
                + "      and indicacaoelenco.filcodigo = indicacao.filcodigo "
                + "      and indicacaoelenco.catcodigo = indicacao.catcodigo "
                + "     left join pessoa"
                + "       on pessoa.pescodigo = indicacaoelenco.pescodigo "
                + "    where indicacao.catcodigo = ? "
                + "    order by indicacao.filcodigo";
        try {
            ResultSet rs = super.getAllByQueryWithParameters(sql, catCodigo);
            while (rs.next()) {
                Categoria categoria = new Categoria(rs.getInt("catcodigo"), rs.getString("descricao"));
                Filme filme = new Filme(rs.getInt("filcodigo"), rs.getString("titulo"));
                Pessoa pessoa = new Pessoa(rs.getInt("pescodigo"), rs.getString("nome"));
                IndicacaoPk pk = new IndicacaoPk(rs.getShort("ano"), categoria, filme);
                array.add(new Indicacao(pk, pessoa));
            }
        } catch (SQLException ex) {
        }
        return array;
    }
}