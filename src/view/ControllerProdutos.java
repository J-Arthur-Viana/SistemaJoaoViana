/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.JatProdutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author pc
 */
public class ControllerProdutos extends AbstractTableModel {
    
    List lstProdutos;
    
    public void setLista(List lstProdutos) {
        this.lstProdutos = lstProdutos;
    }
    
    public JatProdutos getBean (int rowIndex) {
        return (JatProdutos) lstProdutos.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return lstProdutos.size();
    }
    
    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        JatProdutos produtos = (JatProdutos) lstProdutos.get(rowIndex);
        if (columnIndex == 0) {
            return produtos.getJatIdProdutos();
        }
        if (columnIndex == 1) {
            return produtos.getJatNome();
        }
        if (columnIndex == 2) {
            return produtos.getJatModelo();
        }
        if (columnIndex == 3) {
            return produtos.getJatValor();
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
            return "Modelo";
        }
        if (column == 3) {
            return "Valor";
        }else {
            return "";
        }
    }
    
}