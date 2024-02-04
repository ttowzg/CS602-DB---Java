/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bean;
import java.util.Calendar;

/**
 *
 * @author WIN 10
 */
public class Serviço {
    
    private int ID_servico;
    private int ID_cliente;
    private int ID_maquina;
    private int ID_tecnico;
    private double valor;
    private String inicio;
    private String fim;

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

   

  


    public int getID_servico() {
        return ID_servico;
    }

    public void setID_servico(int ID_servico) {
        this.ID_servico = ID_servico;
    }

    public int getID_cliente() {
        return ID_cliente;
    }

    public void setID_cliente(int ID_cliente) {
        this.ID_cliente = ID_cliente;
    }

    public int getID_maquina() {
        return ID_maquina;
    }

    public void setID_maquina(int ID_maquina) {
        this.ID_maquina = ID_maquina;
    }

    public int getID_tecnico() {
        return ID_tecnico;
    }

    public void setID_tecnico(int ID_tecnico) {
        this.ID_tecnico = ID_tecnico;
    }
    
}