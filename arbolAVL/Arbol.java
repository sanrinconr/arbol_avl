/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author fires
 * blog: http://proyectosbeta.blogspot.com/
 */
public class Arbol {
    private Nodo root;

    public void insertar( Comparable x ){
        root = insertar( x, root );
    }

    /*
     * x es una instancia de una clase que implementa Comparable
    */
    private Nodo insertar( Comparable x, Nodo t ){
        if( t == null )
            t = new Nodo( x, null, null );
        else if( x.compareTo( t.dato ) < 0 ) {
            t.izquierdo = insertar( x, t.izquierdo );
            if( altura( t.izquierdo ) - altura( t.derecho ) == 2 )
                if( x.compareTo( t.izquierdo.dato ) < 0 )
                    t = rotateWithLeftChild( t ); /* Caso 1 */
                else
                    t = doubleWithLeftChild( t ); /* Caso 2 */
        }
        else if( x.compareTo( t.dato ) > 0 ) {
            t.derecho = insertar( x, t.derecho );
            if( altura( t.derecho ) - altura( t.izquierdo ) == 2 )
                if( x.compareTo( t.derecho.dato ) > 0 )
                    t = rotateWithRightChild( t ); /* Caso 4 */
                else
                    t = doubleWithRightChild( t ); /* Caso 3 */
        }
        else
            ; // Duplicado; no hago nada
        t.altura = max( altura( t.izquierdo ), altura( t.derecho ) ) + 1;
        return t;
    }


    private static int max( int lhs, int rhs ){
        return lhs > rhs ? lhs : rhs;
    }


    private static Nodo rotateWithLeftChild( Nodo k2 ){
        Nodo k1 = k2.izquierdo;
        k2.izquierdo = k1.derecho;
        k1.derecho = k2;
        k2.altura = max( altura(k2.izquierdo), altura(k2.derecho)) + 1;
        k1.altura = max( altura( k1.izquierdo ), k2.altura ) + 1;
        return k1;
    }


    private static Nodo rotateWithRightChild( Nodo k1 ){
        Nodo k2 = k1.derecho;
        k1.derecho = k2.izquierdo;
        k2.izquierdo = k1;
        k1.altura = max( altura(k1.izquierdo), altura(k1.derecho) ) + 1;
        k2.altura = max( altura( k2.derecho ), k1.altura ) + 1;
        return k2;
    }


    private static Nodo doubleWithLeftChild( Nodo k3 ){
        k3.izquierdo = rotateWithRightChild( k3.izquierdo );
        return rotateWithLeftChild( k3 );
    }


    private static Nodo doubleWithRightChild( Nodo k1 ){
        k1.derecho = rotateWithLeftChild( k1.derecho );
        return rotateWithRightChild( k1 );
    }


    private static int altura( Nodo t ){
    	if( t == null) {
    		return -1;
    	}else {
    		return t.altura;
    	}
    }

    /*
     * Imprime el arbol con el recorrido InOrden
     */
    public void imprimir(){
        imprimir(root);
    }

    private void imprimir(Nodo nodo){
        if ( nodo != null ){
            imprimir(nodo.derecho);
            System.out.println("["+ nodo.dato + "]");
            imprimir(nodo.izquierdo);
        }
    }

    public void imprimirXaltura(){
        imprimirXaltura ( root );
    }

    /*
     * Imprime cada nodo linea por linea. Recorriendo el arbol desde
     * el Nodo más a la derecha hasta el nodo más a la izquierda,
     * y dejando una identacion de varios espacios en blanco segun su
     * altura en el arbol
     */
    private void imprimirXaltura(Nodo nodo){
        if ( nodo != null ){
            imprimirXaltura(nodo.derecho);
            System.out.println( replicate(" ",altura(root) - altura(nodo)) +"["+ nodo.dato + "]");
            imprimirXaltura(nodo.izquierdo);
        }
    }

    /*
     * Metodo estatico auxiliar que dada una cadena a y un enterto cnt
     * replica o concatena esa cadena a, cnt veces
     */
    private static String replicate (String a, int cnt){
        String x = new String("");

        for ( int i = 0; i < cnt; i++ )
            x = x + a;
        return x;
    }

    /*
    * Obtiene la altura del arbol AVL
    */
    public int calcularAltura(){
        return calcularAltura(root);
    }

    private int calcularAltura(Nodo actual ){
       if (actual == null)
            return -1;
       else
            return 1 + Math.max(calcularAltura(actual.izquierdo), calcularAltura(actual.derecho));
    }

    // Imprime el arbol por niveles. Comienza por la raiz.
    public void imprimirPorNiveles(){
        imprimirPorNiveles(root);
    }

    // Imprime el arbol por niveles.
    private void imprimirPorNiveles(Nodo nodo){
        // Mediante la altura calcula el total de nodos posibles del árbol
        // Y crea una array cola con ese tamaño
        int max = 0;
        int nivel = calcularAltura();

        for ( ; nivel >= 0; nivel--)
            max += Math.pow(2, nivel);
        max++;      // Suma 1 para no utilizar la posicion 0 del array

        Nodo cola[] = new Nodo[ max ];

        // Carga en la pos 1 el nodo raiz
        cola[1] = nodo;
        int x = 1;

        // Carga los demas elementos del arbol,
        // Carga null en izq y der si el nodo es null
        // i aumenta de a 2 por q carga en izq y der los hijos
        // x aumenta 1, que son los nodos raiz - padre
        for (int i = 2; i < max; i += 2, x++){
            if (cola[x] == null){
                cola[i] = null;
                cola[i + 1] = null;
            }
            else{
                cola[i]   = cola[x].izquierdo;
                cola[i + 1] = cola[x].derecho;
            }
        }
        nivel = 0;
        int cont = 0;                       // contador para cada nivel
        int cantidad = 1;                   // cantidad de nodos por nivel
        int ultimaPosicion = 1;             // ultimaPosicion del nodo en la cola de cada nivel

        // Cuando i es = a 2^nivel hay cambio de nivel
        // 2 ^ 0 = 1 que es el nodo raiz
        for (int i = 1; i < max; i++){
            if(i == Math.pow(2, nivel)){
            	// Nodo raiz tiene nivel 1, por eso (nivel + 1)
            	System.out.print("\n Nivel " + (nivel) + ": ");
                nivel++;
            }
            if( cola[i] != null ){
                System.out.print("[" + cola[i].dato + "]");
                cont++;
            }
            if(ultimaPosicion == i  && cantidad == Math.pow(2, --nivel)){
                if(cantidad == 1)
                    System.out.print(" Cantidad de nodos: " + cont + " (raiz)");
                else
                    System.out.print(" Cantidad de nodos: " +  cont);
                cont = 0;
                cantidad *= 2;
                ultimaPosicion += (int)Math.pow(2, ++nivel);
            }
        }
    }
}