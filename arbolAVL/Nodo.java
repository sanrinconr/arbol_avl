/*
 * Basic node stored in AVL trees
 */


/**
 *
 * @author fires
 * blog: http://proyectosbeta.blogspot.com/
 */
public class Nodo {
    public Comparable dato;      	 // el dato del nodo
    public Nodo izquierdo;            // hijo izquierdo
    public Nodo derecho;              // hijo derecho
    public int altura;                   // altura

    // Constructors
    public Nodo( Comparable dato ){
        this( dato, null, null );
    }

    public Nodo( Comparable dato, Nodo izq, Nodo der ){
        this.dato = dato;
        this.izquierdo = izq;
        this.derecho = der;
        altura   = 0;               // altura predeterminada
    }
}