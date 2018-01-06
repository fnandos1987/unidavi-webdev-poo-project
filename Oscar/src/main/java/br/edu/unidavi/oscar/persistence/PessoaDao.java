package br.edu.unidavi.oscar.persistence;

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
public class PessoaDao extends Dao implements IDao<Integer, Pessoa>{
    
    private static final String SELECT = "select * from pessoa order by pescodigo";
    private static final String INSERT = "insert into filme(pescodigo, nome, sexo, anoscarreira, nomeacoes, conquistas) values (?,?,?,?,?,?)";
    private static final String UPDATE = "update pessoa set nome = ?, sexo = ?, anoscarreira = ?, nomeacoes = ?, conquistas = ? where pescodigo = ?";
    private static final String DELETE = "delete from pessoa where pescodigo = ?";

    public PessoaDao(Connection connection) {
        super(connection);
    }

    @Override
    public Boolean save(Pessoa entity) {
        if(entity.getPesCodigo() == null){
            entity.setPesCodigo(getSequence("pessoa", "pescodigo"));
        }
        return execute(INSERT, entity.getPesCodigo(), entity.getNome(), entity.getSexo(), entity.getAnosCarreira(), entity.getNomeacoes(), entity.getConquistas());
    }

    @Override
    public Boolean update(Pessoa entity) {
        return execute(UPDATE, entity.getNome(), entity.getSexo(), entity.getAnosCarreira(), entity.getNomeacoes(), entity.getConquistas(), entity.getPesCodigo());
    }

    @Override
    public Boolean delete(Pessoa entity) {
        return execute(DELETE, entity.getPesCodigo());
    }

    @Override
    public ArrayList<Pessoa> findAll() {
        ArrayList<Pessoa> array = new ArrayList<>();

        try {
            ResultSet rs = getAllByQuery(SELECT);
            if (rs instanceof ResultSet) {
                while (rs.next()) {
                    array.add(this.getModelPessoaPopulado(rs));

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, ex.toString(), ex);
        }

        return array;
    }

    @Override
    public Pessoa findById(Integer id) {
        Pessoa pessoa = null;
        try {
            ResultSet rs = super.getAllByQueryWithParameters("select * from pessoa where pescodigo = ?", id);
            while (rs.next()) {
                pessoa = this.getModelPessoaPopulado(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, ex.toString(), ex);
            pessoa = new Pessoa();
        }
        return pessoa;
    }    
    
    private Pessoa getModelPessoaPopulado(ResultSet rs) throws SQLException{
        return new Pessoa(rs.getInt("pescodigo"), 
                          rs.getString("nome"), 
                          rs.getString("sexo"), 
                          rs.getInt("anoscarreira"), 
                          rs.getInt("nomeacoes"), 
                          rs.getInt("conquistas"));
    }
}