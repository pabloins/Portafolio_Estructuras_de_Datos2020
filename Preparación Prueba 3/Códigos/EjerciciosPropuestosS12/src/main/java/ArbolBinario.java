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
            //el nodo debe estar en el sub árbol izquierdo
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
        if (nodo!=null) {
            if(nodo.rightChild == null && nodo.leftChild == null) {
                return true;
            }
            if ((nodo.rightChild != null && nodo.leftChild != null)) {
                return comprobarArbolLleno(nodo.leftChild)&&comprobarArbolLleno(nodo.rightChild);
            }
        }
        return false;
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
     * Método que recorre un árbol binario.
     * */
    public void recorrer(Nodo nodo){
        if (nodo == null)
            return;

        /* primero el nodo izquierdo*/
        recorrer(nodo.leftChild);

        /* luego el nodo  derecho */
        recorrer(nodo.rightChild);
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
