/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Iterator;

/**
 *
 * @author beto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        //ArbolABB Arbol = new ArbolABB();
        int [] lista = {10,20,30,40,50,5,4};
        for(int i=0;i<lista.length;i++){
           arbol.insertar(lista[i]);
        }
        arbol.eliminar(20);

        Iterator it = arbol.graficar().iterator();
        while(it.hasNext()){
            String h = (String)it.next();
            System.out.println(h);
        }
       
        /*if(arbol.RetornarRaiz()!=null){
        Nodo dato =arbol.RetornarRaiz();
        System.out.println(dato.llave);
        System.out.println(dato.balance);
        }*/
        
        
        
    }
}
