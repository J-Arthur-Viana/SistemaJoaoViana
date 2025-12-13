/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.JatVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author pc
 */
public class ControllerConsultasVendas extends AbstractTableModel {

    private List lstVendas;

    public void setList(List lstVendas) {
        this.lstVendas = lstVendas;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lstVendas.size();
                
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        JatVendas vendas = (JatVendas) lstVendas.get( rowIndex);
        if ( columnIndex == 0 ){
            return vendas.getJatIdVendas();
        } else if (columnIndex ==1) {
            return vendas.getJatFuncionarios();        
        } else if (columnIndex ==2) {
            return vendas.getJatValorVenda();
        } 
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Funcionário";         
        } else if ( columnIndex == 2) {
            return "Total";
        }
        return "";
    }
}
