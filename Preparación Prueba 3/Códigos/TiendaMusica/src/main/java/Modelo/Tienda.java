package Modelo;

import java.util.*;

public class Tienda implements Operaciones{

    private LinkedList<Guitarra> guitarras;
    private LinkedList<Piano> pianos;

    public Tienda() {
        this.guitarras = new LinkedList<>();
        this.pianos = new LinkedList<>();
    }

    public LinkedList<Guitarra> getGuitarras() { return guitarras; }

    public void setGuitarras(LinkedList<Guitarra> guitarras) { this.guitarras = guitarras; }

    public LinkedList<Piano> getPianos() { return pianos; }

    public void setPianos(LinkedList<Piano> pianos) { this.pianos = pianos; }

    public boolean buscarGuitarra(Guitarra guitarra){
        if (guitarras.isEmpty()){
            throw new NullPointerException();
        } else return guitarras.contains(guitarra);
    }

    public void ordenarPrecioGuitarras(){
        if(guitarras.isEmpty()){
            throw new NullPointerException();
        } else {
            Comparator<Guitarra> comparator = Comparator.comparing(Guitarra::getPrecio);
            guitarras.sort(comparator);
        }
    }

    public boolean buscarPiano(Piano piano){
        if(pianos.isEmpty()){
            throw new NullPointerException();
        } else return pianos.contains(piano);
    }

    public void ordenarPrecioPianos(){
        if(pianos.isEmpty()){
            throw new NullPointerException();
        } else {
            Comparator<Piano> comparator = Comparator.comparing(Piano::getPrecio);
            pianos.sort(comparator);
        }
    }

    @Override
    public void mostrarListaGuitarras(LinkedList<Guitarra> list) {
        for (Guitarra guitarras : list){
            System.out.println(guitarras.toString());
        }
    }

    @Override
    public void mostrarListaPianos(LinkedList<Piano> list) {
        for (Piano pianos : list){
            System.out.println(pianos.toString());
        }
    }
}