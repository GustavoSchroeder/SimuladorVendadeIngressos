
package simuladorvendadeingressos.listaencadeada;

/**
 *
 * @author gschroeder
 */

import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class UnderFlowException extends Exception {

    public void showMessage() {
        JOptionPane.showMessageDialog(null, "Não existem elementos para serem retirados!");
    }
    
}

