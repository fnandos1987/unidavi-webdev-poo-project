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
        try {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);

            for (int i = 0; i < parametros.length; i++) {
                pstmt.setObject(i + 1, parametros[i]);
            }

            pstmt.execute();
            pstmt.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    protected int getSequence(String table, String column) {
        try {
            String sql = "select coalesce(max(" + column + ")) + 1 as sequence from from " + table;
            PreparedStatement pstmt = getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                return rs.getInt("sequence");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    protected ResultSet getAllByQuery(String sql) {
        ResultSet resul = null;
        try {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);
            resul = pstmt.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resul;
    }

    protected ResultSet getAllByQueryWithParameters(String sql, Object... parametros) {
        ResultSet resul = null;
        try {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);

            for (int i = 0; i < parametros.length; i++) {
                pstmt.setObject(i + 1, parametros[i]);
            }

            resul = pstmt.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resul;
    }
}
