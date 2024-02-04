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
import Bean.Cliente;
import Bean.Conexao;

/**
 *
 * @author kalvi
 */
public class ClienteDAO {
   Cliente c = Cliente.getInstancia();
  public List<Cliente> getLista() {
    String sql = "SELECT * FROM cliente";
    List<Cliente> lista = new ArrayList<>();
    try {
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Cliente cliente = new Cliente(); // Use o construtor padrão para criar uma nova instância
            cliente.setIdCliente(rs.getInt("ID_Cliente"));
            cliente.setNome(rs.getString("Nome"));
            cliente.setTelefone(rs.getString("Telefone"));
            cliente.setEmail(rs.getString("Email"));
            cliente.setRua(rs.getString("Rua"));
            cliente.setNumero(rs.getString("Numero"));
            lista.add(cliente);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro de SQL: " + ex.getMessage());
    }
    return lista;
}
    public boolean salvar(Cliente cliente) {
        if (cliente.getIdCliente() == null) {
            return incluir(cliente);
        } else {
            return alterar(cliente);
        }
    }
     public boolean incluir(Cliente cliente) {
        String sql = "insert into cliente (Nome, Rua, Telefone, Email,numero) values (?,?,?,?,?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getRua());
            pst.setString(3, cliente.getTelefone());
            pst.setString(4, cliente.getEmail());
            pst.setString(5, cliente.getNumero());           
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cliente incluído com sucesso.\n :)");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Algo deu errado. \nCliente incluído sem sucesso.\n :(");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + ex.getMessage());
            return false;
        }
     }
       
     public boolean alterar(Cliente cliente) {
        String sql = "update cliente set nome = ?, Rua = ?, Telefone = ?, Email = ?, "
                + "Numero = ?, where idCliente = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(4, cliente.getRua());
            pst.setString(2, cliente.getTelefone());
            pst.setString(3, cliente.getEmail());
            pst.setString(6, cliente.getNumero());
            pst.setInt(8, cliente.getIdCliente());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Informações alteradas com sucesso.\n :)");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Algo deu errado :(. Informações alteradas sem sucesso.");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + ex.getMessage());
            return false;
        }
    }
      public boolean remover(int id) {
        String sql = "delete from cliente where ID_Cliente = ?";
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
    
     

