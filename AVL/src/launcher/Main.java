/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package launcher;
import java.util.Iterator;

import logica.Arbol;
import vista.VistaPrincipal;

public class Main {

      public static void main(String[] args) {   
       detalles();
       VistaPrincipal ventana = new VistaPrincipal();
       ventana.setVisible(true);
    }
    
    
    
    
    public static void detalles() {
    	  //TODO ESTO HACE VER LA VENTANA BONITA QUITAR PARA PROBAR COMO SE VE COMO SE VE NORMAL
    	 try {
             for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                 if ("Nimbus".equals(info.getName())) {
                     javax.swing.UIManager.setLookAndFeel(info.getClassName());
                     break;
                 }
             }
         } catch (ClassNotFoundException ex) {
             java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
             java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
    }
}
