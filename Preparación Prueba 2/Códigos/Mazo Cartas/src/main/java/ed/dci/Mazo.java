package ed.dci;

import java.util.Stack;

public class Mazo {

    private Stack<Carta> cartas;

    public Mazo() {
        this.cartas = new Stack<Carta>();
    }

    public Mazo(Stack<Carta> cartas) {
        this.cartas = cartas;
    }

    public Carta getCarta(int i){
        if(i < this.cartas.size()){
            return this.cartas.get(i);
        } else {
            throw new IndexOutOfBoundsException("No alcanzan las cartas");
        }
    }

    public Carta deleteCarta(int i){
        if(i < this.cartas.size()){
            return this.cartas.remove(i);
        } else {
            throw new IndexOutOfBoundsException("No puedes eliminar esa carta porque no hay suficientes cartas");
        }
    }

    public Stack<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(Stack<Carta> cartas) {
        this.cartas = cartas;
    }
}
