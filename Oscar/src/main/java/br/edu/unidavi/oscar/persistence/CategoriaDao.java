package br.edu.unidavi.oscar.persistence;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.unidavi.oscar.model.Categoria;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaDao extends Dao implements IDao<Integer, Categoria> {

    private static final Logger LOGGER = Logger.getLogger(Dao.class.getName());
    private final String SELECT = "select * from categoria order by catcodigo";
    private final String INSERT = "insert into categoria(catcodigo, descricao) values (?,?)";
    private final String UPDATE = "update categoria set descricao = ? where catcodigo = ?";
    private final String DELETE = "delete from categoria where catcodigo = ?";

    public CategoriaDao(Connection connection) {
        super(connection);
    }

    @Override
    public Boolean save(Categoria entity) {
        entity.setCatCodigo(getSequence("CATEGORIA", "catcodigo"));
        return execute(this.INSERT, entity.getCatCodigo(), entity.getDescricao());
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
    public ArrayList<Categoria> findAll() {
        ArrayList<Categoria> array = new ArrayList<>();

        try {
            ResultSet rs = getAllByQuery(SELECT);
            if (rs instanceof ResultSet) {
                while (rs.next()) {
                    array.add(new Categoria(rs.getInt("catcodigo"), rs.getString("descricao")));

                }
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }

        return array;
    }

    @Override
    public Categoria findById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }
}
