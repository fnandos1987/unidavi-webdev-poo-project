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
import java.util.ArrayList;

/**
 *
 * @author fernando.schwambach
 */
public class VencedorDao extends Dao implements IDao<VencedorPk, Vencedor> {

    public VencedorDao(Connection connection) {
        super(connection);
    }

    @Override
    public Boolean save(Vencedor entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean update(Vencedor entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean delete(Vencedor entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Vencedor> findAll() {
        ArrayList<Vencedor> array = new ArrayList<>();

        String sql = "select vencedor.ano,"
                + "          categoria.catcodigo,"
                + "          categoria.descricao,"
                + "          filme.filcodigo,"
                + "          filme.titulo,"
                + "          pessoa.pescodigo,"
                + "          pessoa.nome"
                + "     from vencedor"
                + "     join categoria"
                + "       on categoria.catcodigo = vencedor.catcodigo"
                + "     join filme"
                + "       on filme.filcodigo = vencedor.filcodigo "
                + "     left join indicacaoelenco"
                + "       on indicacaoelenco.ano = vencedor.ano "
                + "      and indicacaoelenco.filcodigo = vencedor.filcodigo "
                + "      and indicacaoelenco.catcodigo = vencedor.catcodigo "
                + "     left join pessoa"
                + "       on pessoa.pescodigo = indicacaoelenco.pescodigo "
                + "    order by vencedor.ano, vencedor.catcodigo";

        try {
            ResultSet rs = getAllByQuery(sql);
            if (rs instanceof ResultSet) {
                while (rs.next()) {
                    Categoria categoria = new Categoria(rs.getInt("catcodigo"), rs.getString("descricao"));
                    Filme filme = new Filme(rs.getInt("filcodigo"), rs.getString("titulo"));
                    Pessoa pessoa = new Pessoa(rs.getInt("pescodigo"), rs.getString("nome"));
                    VencedorPk pk = new VencedorPk(rs.getShort("ano"), categoria, filme);
                    array.add(new Vencedor(pk, pessoa));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return array;
    }

    @Override
    public Vencedor findById(VencedorPk object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
