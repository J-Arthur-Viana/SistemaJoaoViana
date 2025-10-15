/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.JatFuncionarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author pc
 */
public class ControllerFuncionarios extends AbstractTableModel {
    
    List lstFuncionarios;
    
    public void setLista(List lstFuncionarios) {
        this.lstFuncionarios = lstFuncionarios;
    }
    
    public JatFuncionarios getBean (int rowIndex) {
        return (JatFuncionarios) lstFuncionarios.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return lstFuncionarios.size();
    }
    
    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        JatFuncionarios funcionarios = (JatFuncionarios) lstFuncionarios.get(rowIndex);
        if (columnIndex == 0) {
            return funcionarios.getJatIdFuncionario();
        }
        if (columnIndex == 1) {
            return funcionarios.getJatNome();
        }
        if (columnIndex == 2) {
            return funcionarios.getJatTelefone();
        }
        if (columnIndex == 3) {
            return funcionarios.getJatCpf();
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
            return "Telefone";
        }
        if (column == 3) {
            return "Cpf";
        }else {
            return "";
        }
    }
    
}