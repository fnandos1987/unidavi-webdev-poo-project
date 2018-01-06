package br.edu.unidavi.oscar.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dao {

    public static final String NOTSUPPORTED = "Not supported yet.";
    private static final Logger LOGGER = Logger.getLogger(Dao.class.getName());
    private final Connection connection;

    protected Dao(Connection connection) {
        this.connection = connection;
    }

    protected Connection getConnection() {
        return connection;
    }

    protected Boolean execute(String sql, Object... parametros) {
        try (PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
            
            for (int i = 0; i < parametros.length; i++) {
                pstmt.setObject(i + 1, parametros[i]);
            }

            pstmt.execute();
            return true;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
            return false;
        }
    }

    protected int getSequence(String table, String column) {
        StringBuilder sql = new StringBuilder("select");
        sql.append("coalesce(max(");
        sql.append(column);
        sql.append(")) + 1 as sequence from from");
        sql.append(table);
        
        try (PreparedStatement pstmt = getConnection().prepareStatement(sql.toString()); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                return rs.getInt("sequence");
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        return 0;
    }

    protected ResultSet getAllByQuery(String sql) {
        ResultSet resul = null;
        try (PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
            resul = pstmt.executeQuery();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        return resul;
    }

    protected ResultSet getAllByQueryWithParameters(String sql, Object... parametros) {
        ResultSet resul = null;
        try (PreparedStatement pstmt = getConnection().prepareStatement(sql)) {

            for (int i = 0; i < parametros.length; i++) {
                pstmt.setObject(i + 1, parametros[i]);
            }

            resul = pstmt.executeQuery();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.toString(), ex);
        }
        return resul;
    }
}