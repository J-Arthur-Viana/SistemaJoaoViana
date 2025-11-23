/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.util.Date;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Lucas
 */
public class Util {
    
    public static void habilitar(boolean valor, JComponent ... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            componentes[i].setEnabled(valor);            
        }
    }
    public static void limpar(JComponent ... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            if (componentes[i] instanceof JTextField) {
                ((JTextField) componentes[i]).setText("");
                //instanceof
            }
        }
    }
    
    public static void mensagem(String cad) {
        JOptionPane.showMessageDialog(null, cad);        
    }
    
    public static boolean perguntar(String cad) {
        int resp = JOptionPane.showConfirmDialog(null, cad, "Perguntar", JOptionPane.YES_NO_OPTION);
        return resp == JOptionPane.YES_OPTION;
    }
    
    public static int strToInt(String num) {
        return Integer.valueOf(num);
    }
    public static String intToStr(int num) {
        return String.valueOf(num);
    }
    public static double strToDouble(String num) {
        return Double.valueOf(num);
    }
    public static String doubleToStr(double num) {
        return String.valueOf(num);
    }
    public static Date strToDate(String num) {
        return null;
    }
    public static String dateToStr(Date num) {
        return "";
    }
}