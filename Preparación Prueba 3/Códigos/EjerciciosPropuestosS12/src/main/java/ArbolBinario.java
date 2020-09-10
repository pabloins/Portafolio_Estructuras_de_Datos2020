public class ArbolBinario {

    protected Nodo root;

    public ArbolBinario() { this.root = null; }

    /**
     * EJERCICIO 1
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
     * EJERCICIO 2
     * Método que comprueba si un árbol binario es lleno.
     * @param nodo árbol que hay que comprobar.
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
     * EJERCICIO 3
     * Método que entrega el nivel de un árbol binario.
     * @param nodo árbol que hay que analizar.
     * @return retorna un entero con el valor del nivel del árbol.
     * */
    public int obtenerNivel(Nodo nodo){
        if(nodo != null){
            return 1 + Math.max(obtenerNivel(nodo.leftChild), obtenerNivel(nodo.rightChild));
        }
        return 0;
    }

    /**
     * EJERCICIO 4
     * Método donde entrega el valor más grande en cada nivel de un árbol binario.
     * @param nodo árbol que hay que analizar.
     * */
    public void obtenerValorMaxNivel(Nodo nodo){
        if(nodo != null){
            //COMPLETAR
        } else throw new NullPointerException("El árbol no existe");
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
     * Dado un árbol binario, imprime sus nodos en En Orden
     * */
    public void imprimirEnOrden(Nodo node) {
        if (node == null) return;

        /* primero el nodo izquierdo*/
        imprimirEnOrden(node.leftChild);

        /* luego imprimir el valor del nodo*/
        System.out.print(node.value + " ");

        /* luego el nodo  derecho */
        imprimirEnOrden(node.rightChild);
    }

    /**
     * Método que inserta un nodo con determinado valor.
     * @param value entero que corresponde al valor del nodo que se va a ingresar.
     * */
    public void insertar(int value){ root = agregarNodo(root,value); }

    /**
     * Método privado que define la posición donde se insertará el nodo.
     * @param actual nodo que hay que ingresar al árbol.
     * @param valor entero que corresponde al valor del nodo que se va a ingresar.
     * @return retorna el árbol.
     * */
    private Nodo agregarNodo(Nodo actual, int valor){
        if (actual==null) actual = new Nodo(valor); //agrega nodo cuando es hoja
        else if (valor < actual.value) actual.leftChild = agregarNodo(actual.leftChild,valor); //recorre lado izquiero para agregar
        else if (valor > actual.value) actual.rightChild = agregarNodo(actual.rightChild,valor); //recorre lado derecho para agregar
        return actual; //retorna el nodo
    }
}
