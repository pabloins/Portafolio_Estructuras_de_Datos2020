package ed.dci;

import java.util.HashSet;
import java.util.Set;

public class Mazo {

    private Set<Carta> cartas;

    public Mazo() {
        cartas = new HashSet<Carta>();
    }

    public Set<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(Set<Carta> cartas) {
        this.cartas = cartas;
    }

    public boolean agregarCarta(Carta carta){
        return cartas.add(carta);
    }

    public boolean obtenerCarta(Carta carta){
        if(cartas.isEmpty()){
            throw new NullPointerException("No alcanzan las cartas");
        } else {
            return getCartas().contains(carta);
        }
    }

    public boolean deleteCarta(Carta carta){
        if(cartas.isEmpty()){
            throw new NullPointerException("No puedes eliminar esa carta porque no hay suficientes cartas");
        } else {
            return getCartas().remove(carta);
        }
    }
}
