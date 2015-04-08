/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorvendadeingressos;

import javax.swing.JOptionPane;

public class ReadDate {

    public Integer readInt(String mensagem) {
        String temp = null;
        while (true) {
            try {
                temp = JOptionPane.showInputDialog(mensagem);
                if (temp == null) {
                    return null;
                }
                int n = Integer.valueOf(temp);
                return n;
            } catch (NumberFormatException e) {
                e.getStackTrace();
                JOptionPane.showMessageDialog(null, "Tipo passado como parametro nÃ£o pode ser convertido para Inteiro!  " + "||" + temp + "||");

            }
        }
    }

    public String readString(String mensagem) {
        String temp = null;
        temp = JOptionPane.showInputDialog(mensagem);
        if (temp == null) {
            return temp;
        }
        String n = temp;
        return n;
    }

    public Double readDouble(String mensagem) {
        String temp = null;
        while (true) {
            try {
                temp = JOptionPane.showInputDialog(mensagem);
                if (temp == null) {
                    return null;
                }

                double n = Double.valueOf(temp);
                return n;
            } catch (NumberFormatException e) {
                e.getStackTrace();
                JOptionPane.showMessageDialog(null, "Tipo passado como parametro nÃ£o pode ser convertido para Inteiro!  " + "||" + temp + "||");
            }
        }
    }
}
