/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kalvi
 */
public class Conexao {
    private static final String BANCO = "jdbc:mysql://localhost:3306/Loja_informatica";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USUARIO = "root";
    private static final String SENHA = "prok2003a";
    private static Connection con = null;
   
    public Conexao() {
    }
        
        public static Connection getConexao() {
        if (con == null) {
            try {
                Class.forName(DRIVER);
                con = DriverManager.getConnection(BANCO, USUARIO, SENHA);
            } catch (ClassNotFoundException ex) {
                System.out.println("Não foi possível encontrar o driver: " + ex.getMessage());
            } catch (SQLException ex) {
                System.out.println("Erro na conexão: " + ex.getMessage());
            }
        }
        return con;
    }
        public static PreparedStatement getPreparedStatement(String sql) {
        if (con == null) {
            con = getConexao();
        }
        try {
            return con.prepareStatement(sql);
        } catch (SQLException ex) {
            System.out.println("Erro de SQL: " + ex.getMessage());
        }
        return null;
    }
    
    public static void closeConnection(Connection con){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
    

