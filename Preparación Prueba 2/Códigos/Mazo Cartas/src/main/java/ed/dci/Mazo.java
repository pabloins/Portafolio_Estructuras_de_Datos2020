package ed.dci;

import java.util.ArrayList;
import java.util.List;

public class Mazo {

    private List<Carta> cartas;

    public Mazo() {
        this.cartas = new ArrayList<Carta>();
    }

    public Mazo(List<Carta> cartas) {
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

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }
}
