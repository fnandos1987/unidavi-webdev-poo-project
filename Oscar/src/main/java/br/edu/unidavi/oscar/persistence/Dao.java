package br.edu.unidavi.oscar.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {

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
            pstmt.close();
            return true;
        } catch (SQLException e) {
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
        } catch (SQLException e) {
        }
        return 0;
    }

    protected ResultSet getAllByQuery(String sql) {
        ResultSet resul = null;
        try (PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
            resul = pstmt.executeQuery();
            pstmt.close();
        } catch (Exception ex) {
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
            pstmt.close();
        } catch (Exception ex) {
        }
        return resul;
    }
}