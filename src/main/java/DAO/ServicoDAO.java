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
import Bean.Serviço;
import DAO.ServicoDAO;
import java.sql.Timestamp;
import java.util.Calendar;
/**
 *
 * @author kalvi
 */
public class ServicoDAO {
    
    public void Inserir(Serviço s,int ID_cli,int ID_comp,int ID_tec){
        String sql = "INSERT INTO servico(ID_Cliente, ID_Computador,ID_Técnico,Valor_Total,Data_Solicitação,Data_Devolução,Tipo)VALUE(?,?,?,?,?,?,?)";

        
        try {
            PreparedStatement stmt = Conexao.getPreparedStatement(sql);
            stmt.setInt(1,ID_cli);
            stmt.setInt(2,ID_comp);
            stmt.setInt(3,ID_tec);
            stmt.setDouble(4,s.getValor());
            stmt.setString(5,s.getFim());
            stmt.setString(6,s.getInicio());
            stmt.setString(7,s.getTipo());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar" + ex);
        } finally {
            
        }
    }
    public List<Serviço> read(){
        
       
        
        List<Serviço> Servico = new ArrayList<>();
        
           String sql = "SELECT * FROM servico";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                
                Serviço S = new Serviço();
                
                S.setID_cliente(rs.getInt("ID_Cliente"));
                S.setID_maquina(rs.getInt("ID_Computador"));
                S.setID_tecnico(rs.getInt("ID_Técnico"));
               S.setInicio(rs.getString("Data_Solicitação"));
                S.setFim(rs.getString("Data_Devolução"));
                S.setValor(rs.getDouble("Valor_Total"));
                S.setTipo(rs.getString("Tipo"));
                Servico.add(S);    
            }
        }
            catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Servico;
    
}
    public void delete(int id){
        
        
        try {
            String sql = "DELETE FROM servico WHERE ID_Serviço = ?";
            PreparedStatement stmt = Conexao.getPreparedStatement(sql);
            stmt.setInt(1,id);
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir" + ex);
        } 
    }
    }

