package br.edu.unidavi.oscar.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Conexao {
    
    private static final Logger LOGGER = Logger.getLogger(Conexao.class.getName());
    private static final Conexao INSTANCE = new Conexao();
    
    private Conexao(){
    }

    public static Conexao getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/oscarprj2", "postgres", "postgres");
        } catch (ClassNotFoundException | SQLException ex) {
            LOGGER.log(Level.ALL, ex.toString(), ex);
        }
        return null;
    }
}
