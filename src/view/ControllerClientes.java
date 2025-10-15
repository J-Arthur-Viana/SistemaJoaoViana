/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.JatClientes;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pc
 */
public class ControllerClientes extends AbstractTableModel {

    private List lstClientes;

    public void setLista(List lstClientes) {
        this.lstClientes = lstClientes;
    }

    public JatClientes getBean(int rowIndex) {
        return (JatClientes) lstClientes.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstClientes.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        JatClientes usuarios = (JatClientes) lstClientes.get(rowIndex);
        if (columnIndex == 0) {
            return usuarios.getJatIdClientes();
        }
        if (columnIndex == 1) {
            return usuarios.getJatNome();
        }
        if (columnIndex == 2) {
            return usuarios.getJatCpf();
        }
        if (columnIndex == 3) {
            return usuarios.getJatApelido();
        } else {
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
        } else {
            return "";
        }
    }

}
