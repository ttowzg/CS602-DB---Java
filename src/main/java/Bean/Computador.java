/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bean;
import java.io.Serializable;
import java.util.Objects;
import javax.swing.JOptionPane;
/**
 *
 * @author kalvi
 */
public class Computador implements Serializable {
    private Integer ID_Computador;
    private String Marca;
    private String Especificacoes;
    private String Defeitos;
    private String Tipo;
    private int ID_Cliente;
    
    private static Computador instancia;
    public static Computador getInstancia() {
        if (instancia == null) {
            instancia = new Computador();
        }
        return instancia;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.ID_Computador);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Computador other = (Computador) obj;
        return Objects.equals(this.ID_Computador, other.ID_Computador);
    }

    public Integer getID_Computador() {
        return ID_Computador;
    }

    public void setID_Computador(Integer ID_Computador) {
        this.ID_Computador = ID_Computador;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getEspecificacoes() {
        return Especificacoes;
    }

    public void setEspecificacoes(String Especificacoes) {
        this.Especificacoes = Especificacoes;
    }

    public String getDefeitos() {
        return Defeitos;
    }

    public void setDefeitos(String Defeitos) {
        this.Defeitos = Defeitos;
    }

   
    
    
}
