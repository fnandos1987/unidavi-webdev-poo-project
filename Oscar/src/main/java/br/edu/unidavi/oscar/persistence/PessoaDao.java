package br.edu.unidavi.oscar.persistence;

import br.edu.unidavi.oscar.model.Pessoa;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fernando.schwambach
 */
public class PessoaDao extends Dao implements IDao<Integer, Pessoa>{
    
    private final String SELECT = "select * from pessoa order by pescodigo";
    private final String INSERT = "insert into filme(pescodigo, nome, sexo, anoscarreira, nomeacoes, conquistas) values (?,?,?,?,?,?)";
    private final String UPDATE = "update pessoa set nome = ?, sexo = ?, anoscarreira = ?, nomeacoes = ?, conquistas = ? where pescodigo = ?";
    private final String DELETE = "delete from pessoa where pescodigo = ?";

    public PessoaDao(Connection connection) {
        super(connection);
    }

    @Override
    public Boolean save(Pessoa entity) {
        entity.setPesCodigo(getSequence("pessoa", "pescodigo"));
        return execute(this.INSERT, entity.getPesCodigo(), entity.getNome(), entity.getSexo(), entity.getAnosCarreira(), entity.getNomeacoes(), entity.getConquistas());
    }

    @Override
    public Boolean update(Pessoa entity) {
        return execute(this.UPDATE, entity.getNome(), entity.getSexo(), entity.getAnosCarreira(), entity.getNomeacoes(), entity.getConquistas(), entity.getPesCodigo());
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
                    array.add(new Pessoa(rs.getInt("pescodigo"), rs.getString("nome"), rs.getString("sexo"), 
                                        rs.getInt("anoscarreira"), rs.getInt("nomeacoes"), rs.getInt("conquistas")));

                }
            }
        } catch (SQLException ex) {
        }

        return array;
    }

    @Override
    public Pessoa findById(Integer id) {
        Pessoa pessoa = new Pessoa();
        try {
            ResultSet rs = super.getAllByQueryWithParameters("select * from pessoa where pescodigo = ?", id);
            while (rs.next()) {
                pessoa.setPesCodigo(rs.getInt("pescodigo"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setSexo(rs.getString("sexo"));
                pessoa.setAnosCarreira(rs.getInt("anoscarreira"));
                pessoa.setNomeacoes(rs.getInt("nomeacoes"));
                pessoa.setConquistas(rs.getInt("conquistas"));
            }
        } catch (SQLException ex) {
        }
        return pessoa;
    }    
}