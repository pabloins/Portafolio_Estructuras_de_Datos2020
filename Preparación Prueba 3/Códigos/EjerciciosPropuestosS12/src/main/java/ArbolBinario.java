public class ArbolBinario {

    protected Nodo root;

    public ArbolBinario() { this.root = null; }

    /**
     * Método que busca un nodo dentro del árbol binario en pre orden.
     * @param nodo nodo que hay que encontrar.
     * @param value valor del nodo a encontrar.
     * @return retorna un true o falso si el valor se encuentra dentro del árbol binario.
     * */
    public boolean buscar(Nodo nodo, int value){
        //Caso: la raíz del árbol es null
        if(nodo == null) return false;
        //Caso: el valor de la raíz del árbol no es null y es igual que el valor value
        if(nodo.value == value){
            return true;
            //Caso: el valor del nodo es mayor que el que se busca,
            //el nodo debe sestar en el sub árbol izquierdo
        } else if(nodo.value > value){
            return buscar(nodo.leftChild, value);
        } else {
            //Caso: valor del nodo es menor que el que se busca,
            // el nodo debe estar en el sub árbol derecho
            return buscar(nodo.rightChild, value);
        }
    }

    /**
     * Método que comprueba si un árbol binario es lleno.
     * @param nodo raíz del árbol que hay que comprobar.
     * @return retorna un true o false comrobando el árbol binario.
     * */
    public boolean comprobarArbolLleno(Nodo nodo){
        //Caso: la raíz del árbol es null
        if(nodo == null) return false;
        //Caso: la raíz del arbol exista
        else return false;
        //Caso: si cada nodo es una hoja
        //COMPLETAR!!
    }

    /**
     * Método que recorre un árbol binario en pre orden.
     * */
    public void imprimirEnPreOrden(Nodo nodo){
        if(nodo == null) return;

        /* luego imprimir el valor del nodo*/
        System.out.print(nodo.value + " ");

        /* primero el nodo izquierdo*/
        imprimirEnPreOrden(nodo.leftChild);

        /* luego el nodo  derecho */
        imprimirEnPreOrden(nodo.rightChild);
    }

    /**
     * Método que Inserta un nodo con determinado valor.
     * */
    public void insertar(int value){
        root = agregarNodo(root,value);
    }

    //Define la posición donde se insertará el nodo
    private Nodo agregarNodo(Nodo actual, int valor){
        if (actual==null) actual = new Nodo(valor); //agrega nodo cuando es hoja
        else if (valor < actual.value) actual.leftChild = agregarNodo(actual.leftChild,valor); //recorre lado izquiero para agregar
        else if (valor > actual.value) actual.rightChild = agregarNodo(actual.rightChild,valor); //recorre lado derecho para agregar
        return actual; //retorna el nodo
    }
}
