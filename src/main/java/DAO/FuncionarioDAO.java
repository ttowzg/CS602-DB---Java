/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Bean.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Bean.Funcionario;

/**
 *
 * @author WIN 10
 */
public class FuncionarioDAO {
    
    public void Inserir(Funcionario f){
        String sql = "INSERT INTO tecnico(Nome_Técnico, Telefone, Endereço,Sálario,Email,Sexo)VALUE(?,?,?,?,?,?)";

        
        try {
            PreparedStatement stmt = Conexao.getPreparedStatement(sql);
            stmt.setString(1,f.getNome_tecnico());
            stmt.setString(2,f.getTel_tecnico());
            stmt.setString(3,f.getEnd_tecnico());
            stmt.setDouble(4,f.getSal_tecnico());
            stmt.setString(5,f.getEmail_tecnico());
            stmt.setString(6, f.getSexo());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar" + ex);
        } finally {
            
        }
    }
    
    
    public List<Funcionario> read(){
        
       
        
        List<Funcionario> funcionarios = new ArrayList<>();
        
           String sql = "SELECT * FROM tecnico";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                
                Funcionario funcionario = new Funcionario();
                
                funcionario.setID_tecnico(rs.getInt("ID_Técnico"));
                funcionario.setEmail_tecnico(rs.getString("Email"));
                funcionario.setEnd_tecnico(rs.getString("Endereço"));
                funcionario.setNome_tecnico(rs.getString("Nome_Técnico"));
                funcionario.setSal_tecnico(rs.getDouble("Sálario"));
                funcionario.setTel_tecnico(rs.getString("Telefone"));
                funcionario.setSexo(rs.getString("Sexo"));
                funcionarios.add(funcionario);
                
            }
            
                    
                    
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return funcionarios;
        
    }
    
       
        public void delete(int id){
        
        
        try {
            String sql = "DELETE FROM tecnico WHERE ID_Técnico = ?";
            PreparedStatement stmt = Conexao.getPreparedStatement(sql);
            stmt.setInt(1,id);
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir" + ex);
        } 
    }
        
    
}