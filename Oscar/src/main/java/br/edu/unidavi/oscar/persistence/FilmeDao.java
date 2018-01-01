package br.edu.unidavi.oscar.persistence;

import br.edu.unidavi.oscar.model.Filme;
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
public class FilmeDao extends Dao implements IDao<Integer, Filme> {
    
    private static final Logger LOGGER = Logger.getLogger(FilmeDao.class.getName());
    private final String FILCODIGO = "filcodigo";
    private final String SELECT = "select * from filme order by filcodigo";
    private final String INSERT = "insert into filme(filcodigo, titulo, genero, paisorigem, estreia, duracao, sinopse) values (?,?,?,?,?,?,?)";
    private final String UPDATE = "update filme set titulo = ?, genero = ?, paisorigem = ?, estreia = ?, duracao = ?, sinopse = ? where filcodigo = ?";
    private final String DELETE = "delete from filme where filcodigo = ?";

    public FilmeDao(Connection connection) {
        super(connection);
    }

    @Override
    public Boolean save(Filme entity) {
        entity.setFilCodigo(getSequence("filme", FILCODIGO));
        return execute(this.INSERT, entity.getFilCodigo(), entity.getTitulo(), entity.getGenero(), entity.getPaisOrigem(), entity.getEstreia(), entity.getDuracao(), entity.getSinopse());
    }

    @Override
    public Boolean update(Filme entity) {        
        return execute(this.UPDATE, entity.getTitulo(), entity.getGenero(), entity.getPaisOrigem(), entity.getEstreia(), entity.getDuracao(), entity.getSinopse(), entity.getFilCodigo());
    }

    @Override
    public Boolean delete(Filme entity) {
        return execute(DELETE, entity.getFilCodigo());
    }

    @Override
    public ArrayList<Filme> findAll() {
        ArrayList<Filme> array = new ArrayList<>();

        try {
            ResultSet rs = getAllByQuery(SELECT);
            if (rs instanceof ResultSet) {
                while (rs.next()) {
                    array.add(new Filme(rs.getInt(FILCODIGO), rs.getString("titulo"), rs.getShort("genero"), rs.getString("paisorigem"), 
                                        rs.getDate("estreia"), rs.getShort("duracao"), rs.getString("sinopse")));

                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }

        return array;
    }

    @Override
    public Filme findById(Integer id) {
        Filme filme = new Filme();
        try {
            ResultSet rs = getAllByQuery(SELECT);
            if (rs instanceof ResultSet) {
                while (rs.next()) {
                    filme.setFilCodigo(rs.getInt(FILCODIGO));
                    filme.setTitulo(rs.getString("titulo"));
                    filme.setGenero(rs.getShort("genero"));
                    filme.setPaisOrigem(rs.getString("paisorigem"));
                    filme.setEstreia(rs.getDate("estreia"));
                    filme.setDuracao(rs.getShort("duracao"));
                    filme.setSinopse(rs.getString("sinopse"));
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        return filme;
    }    
}