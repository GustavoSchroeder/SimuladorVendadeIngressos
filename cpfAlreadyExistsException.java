package simuladorvendadeingressos;

import javax.swing.JOptionPane;

/**
 *
 * @author Unisinos
 */
public class cpfAlreadyExistsException extends Exception {

   public void showMessage(){
       JOptionPane.showMessageDialog(null, "Este Cpf já está cadastrado!");
   }
    
}
