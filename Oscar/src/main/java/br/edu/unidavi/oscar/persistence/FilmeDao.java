package br.edu.unidavi.oscar.persistence;

import br.edu.unidavi.oscar.model.Filme;
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
public class FilmeDao extends Dao implements IDao<Integer, Filme> {
    
    private static final Logger LOGGER = Logger.getLogger(FilmeDao.class.getName());
    private static final String SELECT = "select * from filme order by filcodigo";
    private static final String INSERT = "insert into filme(filcodigo, titulo, genero, paisorigem, estreia, duracao, sinopse) values (?,?,?,?,?,?,?)";
    private static final String UPDATE = "update filme set titulo = ?, genero = ?, paisorigem = ?, estreia = ?, duracao = ?, sinopse = ? where filcodigo = ?";
    private static final String DELETE = "delete from filme where filcodigo = ?";

    public FilmeDao(Connection connection) {
        super(connection);
    }

    @Override
    public Boolean save(Filme entity) {
        if(entity.getFilCodigo() == null){
            entity.setFilCodigo(getSequence("filme", "filcodigo"));
        }
        return execute(INSERT, entity.getFilCodigo(), entity.getTitulo(), entity.getGenero(), entity.getPaisOrigem(), entity.getEstreia(), entity.getDuracao(), entity.getSinopse());
    }

    @Override
    public Boolean update(Filme entity) {        
        return execute(UPDATE, entity.getTitulo(), entity.getGenero(), entity.getPaisOrigem(), entity.getEstreia(), entity.getDuracao(), entity.getSinopse(), entity.getFilCodigo());
    }

    @Override
    public Boolean delete(Filme entity) {
        return execute(DELETE, entity.getFilCodigo());
    }

    @Override
    public List<Filme> findAll() {
        List<Filme> array = new ArrayList<>();

        try {
            ResultSet rs = getAllByQuery(SELECT);
            if (rs instanceof ResultSet) {
                while (rs.next()) {
                    array.add(this.getModelFilmePopulado(rs));

                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }

        return array;
    }

    @Override
    public Filme findById(Integer id) {
        Filme filme = null;
        try {
            ResultSet rs = getAllByQuery(SELECT);
            if (rs instanceof ResultSet) {
                while (rs.next()) {
                    filme = this.getModelFilmePopulado(rs);
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
            filme = new Filme();
        }
        return filme;
    }    
    
    private Filme getModelFilmePopulado(ResultSet rs) throws SQLException{
        return new Filme(rs.getInt("filcodigo"), 
                         rs.getString("titulo"), 
                         rs.getShort("genero"), 
                         rs.getString("paisorigem"), 
                         rs.getDate("estreia"), 
                         rs.getShort("duracao"), 
                         rs.getString("sinopse"));
    }
}