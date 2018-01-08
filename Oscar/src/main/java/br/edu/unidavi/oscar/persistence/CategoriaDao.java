package br.edu.unidavi.oscar.persistence;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.unidavi.oscar.model.Categoria;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaDao extends Dao implements IDao<Integer, Categoria> {

    private static final String SELECT = "select * from categoria order by catcodigo";
    private static final String INSERT = "insert into categoria(catcodigo, descricao) values (?,?)";
    private static final String UPDATE = "update categoria set descricao = ? where catcodigo = ?";
    private static final String DELETE = "delete from categoria where catcodigo = ?";

    public CategoriaDao(Connection connection) {
        super(connection);
    }

    @Override
    public Boolean save(Categoria entity) {
        if(entity.getCatCodigo() == null){
            entity.setCatCodigo(getSequence("CATEGORIA", "catcodigo"));
        }
        return execute(INSERT, entity.getCatCodigo(), entity.getDescricao());
    }

    @Override
    public Boolean update(Categoria entity) {
        return execute(UPDATE, entity.getDescricao(), entity.getCatCodigo());
    }

    @Override
    public Boolean delete(Categoria entity) {
        return execute(DELETE, entity.getCatCodigo());
    }

    @Override
    public List<Categoria> findAll() {
        List<Categoria> array = new ArrayList<>();

        try {
            ResultSet rs = getAllByQuery(SELECT);
            if (rs instanceof ResultSet) {
                while (rs.next()) {
                    array.add(this.getModelCategoriaPopulado(rs));
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, ex.toString(), ex);
        }

        return array;
    }

    @Override
    public Categoria findById(Integer id) {
        Categoria categoria = null;
        try {
            ResultSet rs = super.getAllByQueryWithParameters("select * from categoria where catcodigo = ?", id);
            while (rs.next()) {
                categoria = this.getModelCategoriaPopulado(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, ex.toString(), ex);
            categoria = new Categoria();
        }
        return categoria;
    }

    private Categoria getModelCategoriaPopulado(ResultSet rs) throws SQLException {
        return new Categoria(rs.getInt("catcodigo"), rs.getString("descricao"));
    }
}
