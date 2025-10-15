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
public class ControllerVendas extends AbstractTableModel {
    
    List lstVendas;
    
    public void setLista(List lstVendas) {
        this.lstVendas = lstVendas;
    }
    
    public JatVendas getBean (int rowIndex) {
        return (JatVendas) lstVendas.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return lstVendas.size();
    }
    
    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        JatVendas vendas = (JatVendas) lstVendas.get(rowIndex);
        if (columnIndex == 0) {
            return vendas.getJatIdVendas();
        }
        if (columnIndex == 1) {
            return vendas.getJatFormaPagamento();
        }
        if (columnIndex == 2) {
            return vendas.getJatDataVenda();
        }
        if (columnIndex == 3) {
            return vendas.getJatValorVenda();
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
            return "Forma de pagamento";
        }
        if (column == 2) {
            return "Data da venda";
        }
        if (column == 3) {
            return "Valor da venda";
        }else {
            return "";
        }
    }
    
}