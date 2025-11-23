/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.JatVendasProdutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u1845853
 */
public class ControllerVendasProdutos extends AbstractTableModel {

    private List lstVenProd;

    public void setList(List lstVendasProdutos) {
        this.lstVenProd = lstVendasProdutos;
    }
    
    public JatVendasProdutos getBean(int rowIndex) {
        return (JatVendasProdutos) lstVenProd.get(rowIndex);
    }
    
    public void addBean(JatVendasProdutos vendasProdutos){
        this.lstVenProd.add(vendasProdutos);
        this.fireTableDataChanged();
    }
    
    public void removeBean(int rowIndex) {
        this.lstVenProd.remove(rowIndex); 
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lstVenProd.size();
                
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        JatVendasProdutos venProd = (JatVendasProdutos) lstVenProd.get( rowIndex);
        if ( columnIndex == 0 ){
            return venProd.getJatProdutos().getJatIdProdutos();
        } else if (columnIndex ==1) {
            return venProd.getJatProdutos().getJatNome();        
        } else if (columnIndex ==2) {
            return venProd.getJatQuantidade();
        } else if (columnIndex ==3) {
            return venProd.getJatValorUnitario();
        } else if (columnIndex ==4) {
            return venProd.getJatQuantidade() * venProd.getJatValorUnitario();
        }
        
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome";         
        } else if ( columnIndex == 2) {
            return "Quantidade";
        } else if ( columnIndex == 3) {
            return "Valor Unitário";
        } else if ( columnIndex == 4) {
            return "Total";
        } 
        return "";
    }
    
}
