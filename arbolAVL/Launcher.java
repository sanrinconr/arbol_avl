/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author fires
 * blog: http://proyectosbeta.blogspot.com/
 */
public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Arbol arbolAVL = new Arbol();

        Integer elemento1 = new Integer("1");
        Integer elemento2 = new Integer("2");
        Integer elemento3 = new Integer("3");
        Integer elemento4 = new Integer("4");
        Integer elemento5 = new Integer("5");
        Integer elemento6 = new Integer("6");
        Integer elemento7 = new Integer("7");
        Integer elemento8 = new Integer("15");
        Integer elemento9 = new Integer("14");
        Integer elemento10 = new Integer("13");

        arbolAVL.insertar(elemento1);
        arbolAVL.insertar(elemento2);
        arbolAVL.insertar(elemento3);
        arbolAVL.insertar(elemento4);
        arbolAVL.insertar(elemento5);
        arbolAVL.insertar(elemento6);
        arbolAVL.insertar(elemento7);
        arbolAVL.insertar(elemento8);
        arbolAVL.insertar(elemento9);
        arbolAVL.insertar(elemento10);
        arbolAVL.imprimirPorNiveles();
        System.out.println("\n");

        

    }

}
