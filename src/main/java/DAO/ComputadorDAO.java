/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Bean.Computador;
import Bean.Conexao;
import DAO.ClienteDAO;
import Bean.Cliente;
/**
 *
 * @author kalvi
 */
public class ComputadorDAO {
    
    ClienteDAO daoC = new ClienteDAO();
    Cliente cli = Cliente.getInstancia();
    
    public boolean incluir(Computador computador,int id) {
        String sql = "insert into computador (Marca, Defeito, Especificações, ID_Cliente,Tipo) values (?,?,?,?,?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, computador.getMarca());
            pst.setString(2,computador.getDefeitos());
            pst.setString(3, computador.getEspecificacoes());
            pst.setInt(4, id);
            pst.setString(5,computador.getTipo());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Computador incluído com sucesso.\n:)");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Algo deu errado.\nComputador incluída sem sucesso.\n:(");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + ex.getMessage());
            return false;
        }
    }
    public boolean removerFK(int id) {
        String sql = "delete from computador where ID_Cliente = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso. \n :)");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Algo deu errado.\nCliente excluído sem sucesso.\n :(");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + ex.getMessage());
            return false;
        }
    }
    public boolean remover(int id) {
        String sql = "delete from computador where ID_Computador = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso. \n :)");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Algo deu errado.\nCliente excluído sem sucesso.\n :(");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + ex.getMessage());
            return false;
        }
    }
}
