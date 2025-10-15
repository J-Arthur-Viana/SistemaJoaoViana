/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.JatUsuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author pc
 */
public class ControllerUsuarios extends AbstractTableModel {
    
    private List lstUsuarios;
    
    public void setLista(List lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }
    
    public JatUsuarios getBean (int rowIndex) {
        return(JatUsuarios) lstUsuarios.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return lstUsuarios.size();
    }
    
    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        JatUsuarios usuarios = (JatUsuarios) lstUsuarios.get(rowIndex);
        if (columnIndex == 0) {
            return usuarios.getJatIdUsuarios();
        }
        if (columnIndex == 1) {
            return usuarios.getJatNome();
        }
        if (columnIndex == 2) {
            return usuarios.getJatCpf();
        }
        if (columnIndex == 3) {
            return usuarios.getJatApelido();
        }
        else {
            return "";
        }
    }
    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Código";
        }
        if (column == 1) {
            return "Nome";
        }
        if (column == 2) {
            return "CPF";
        }
        if (column == 3) {
            return "Apelido";
        }else {
            return "";
        }
    }
    
}